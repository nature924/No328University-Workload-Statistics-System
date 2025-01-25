package com.hdc.controller.college;

import com.hdc.entity.*;
import com.hdc.security.MyUser;
import com.hdc.service.AuditService;
import com.hdc.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/college")
public class CollegeInfoController {

    @Autowired
    private CollegeService collegeService;
    /**
     * @return 返回的当前登陆的审核处信息
     */
    @GetMapping("/info")
    public Map<String, Object> selectCollegeInfo() {

        College college;
        CollegeExample example = new CollegeExample();
        Map<String, Object> map = new HashMap<>();

        Integer collegeId;
        //获取登录的用户ID
        try {
            MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            example.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //查询数据
        try {
            college = collegeService.selectByExample(example).get(0);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //封装JSON
        map.put("code", 200);
        map.put("msg", "请求成功");
        map.put("data", college);
        return map;
    }

}

