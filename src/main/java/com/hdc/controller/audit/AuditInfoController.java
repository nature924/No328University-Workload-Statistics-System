package com.hdc.controller.audit;

import com.hdc.entity.*;
import com.hdc.security.MyUser;
import com.hdc.service.AuditService;
import com.hdc.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/audit")
public class AuditInfoController {

    @Autowired
    private AuditService auditService;
    /**
     * @return 返回的当前登陆的审核处信息
     */
    @GetMapping("/info")
    public Map<String, Object> selectTeacherInfo() {


        long count = 0;
        List<AuditTable> list;
        AuditTable auditTable;
        AuditTableExample example = new AuditTableExample();
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
            list = auditService.selectAllByExample(example);
            auditTable =list.get(0);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //封装JSON
        map.put("code", 200);
        map.put("msg", "请求成功");
        map.put("count", count);
        map.put("data", auditTable);
        return map;
    }

    /**
     * 获取取审核处信息
     *
     * @return 返回的JSON数据
     */
    @GetMapping("/all")
    public Map<String, Object> selectAllAudit() {

        //获取登录的用户ID
        MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        AuditExample auditExample = new AuditExample();
        auditExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());
        Integer collegeId =auditService.selectByExample(auditExample).get(0).getCollegeId();

        long count = 0;
        List<Audit> list;
        AuditExample example = new AuditExample();
        AuditExample.Criteria criteria = example.createCriteria();
        Map<String, Object> map = new HashMap<>();

        criteria.andCollegeIdEqualTo(collegeId);



        //查询数据
        try {
            list = auditService.selectByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //封装JSON
        map.put("code", 200);
        map.put("msg", "请求成功");
        map.put("data", list);
        return map;
    }
}

