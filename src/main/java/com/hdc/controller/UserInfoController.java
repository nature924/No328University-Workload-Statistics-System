package com.hdc.controller;


import com.google.common.base.CaseFormat;
import com.hdc.dto.PasswordDto;
import com.hdc.dto.UserInfoDto;
import com.hdc.entity.*;
import com.hdc.security.MyUser;
import com.hdc.service.UserInfoService;
import com.hdc.service.UsersService;
import com.hdc.service.impl.UserLoginServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserLoginServiceImpl userLoginServiceImpl;
    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * @return 返回的JSON数据
     */
    @GetMapping("")
    public Map<String, Object> select() {

        //当前登录的用户
        MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        Integer userId = userDetails.getMyUserId();
        UserInfo userInfo;
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andUserIdEqualTo(userId);
        Map<String, Object> map = new HashMap<>();


        //返回查询条数
        try {
            userInfo = userInfoService.selectByExample(userInfoExample).get(0);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }

        //封装JSON
        map.put("code", 200);
        map.put("msg", "请求成功");
        map.put("data", userInfo);
        return map;
    }



    /**
     * 更新用户信息
     *
     * @param userInfoDto 用户信息
     * @param errors      检查之后返回的错误数据
     * @return code为200时为插入成功，其它情况为更新失败
     */
    @PutMapping("")
    public Map<String, Object> update(@Valid @RequestBody(required = false) UserInfoDto userInfoDto, BindingResult errors) {

        //当前登录的用户
        MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        Integer userId = userDetails.getMyUserId();
        UserInfo userInfo = new UserInfo();
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andUserIdEqualTo(userId);
        Map<String, Object> map = new HashMap<>();


        //检查错误，封装错误信息
        if (errors.getErrorCount() > 0) {
            map.put("code", 500);
            map.put("msg", errors.getAllErrors().get(0).getDefaultMessage());
            return map;
        }

        //执行更新操作
        try {
            userInfo.setDisplayName(userInfoDto.getDisplayName());
            userInfo.setUserId(userId);
            userInfo.setEmail(userInfoDto.getEmail());
            userInfo.setPhone(userInfoDto.getPhone());
            userInfoService.updateByExampleSelective(userInfo, userInfoExample);

        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "更新失败");
            return map;
        }

        map.put("code", 200);
        map.put("msg", "请求成功");
        return map;
    }



    /**
     * 修改账户密码
     *
     * @param passwordDto 密码信息
     * @return code为200时为更改密码成功，其它情况为更改失败
     */
    @PutMapping("/password")
    public Map<String, Object> update(@Valid @RequestBody(required = false) PasswordDto passwordDto, BindingResult errors) {

        //当前登录的用户
        MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        Integer userId = userDetails.getMyUserId();
        Users users = new Users();
        Map<String, Object> map = new HashMap<>();


        if (!passwordDto.getNewPassword().equals(passwordDto.getConfirmPassword())) {
            map.put("code", 500);
            map.put("msg", "两次密码不同");
            return map;
        }

        //检查错误，封装错误信息
        if (errors.getErrorCount() > 0) {
            map.put("code", 500);
            map.put("msg", errors.getAllErrors().get(0).getDefaultMessage());
            return map;
        }

        //检查旧密码
        try {
            UserLoginEntity userLogin = userLoginServiceImpl.getUserLoginByUserId(userId);
            System.out.println("数据库" + userLogin.getPassword());
            System.out.println("表单" + passwordDto.getOldPassword());
            if (!passwordEncoder.matches(passwordDto.getOldPassword(), userLogin.getPassword())) {
                map.put("code", 500);
                map.put("msg", "旧密码错误");
                return map;
            }

        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "用户认证信息过期，请重新登陆");
            return map;
        }

        //执行更改密码操作
        try {
            String encodePassword = passwordEncoder.encode(passwordDto.getNewPassword());
            users.setUserId(userId);
            users.setPassword(encodePassword);
            usersService.updateByPrimaryKeySelective(users);

        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "更新失败");
            return map;
        }

        map.put("code", 200);
        map.put("msg", "请求成功");
        return map;
    }

}
