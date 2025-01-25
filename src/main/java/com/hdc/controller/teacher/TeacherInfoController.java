package com.hdc.controller.teacher;

import com.hdc.entity.CollegeExample;
import com.hdc.entity.TeacherTable;
import com.hdc.entity.TeacherTableExample;
import com.hdc.security.MyUser;
import com.hdc.service.CollegeService;
import com.hdc.service.TeacherService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
public class TeacherInfoController {

    @Autowired
    private TeacherService teacherService;
    /**
     * @return 返回的当前登陆的教师信息
     */
    @GetMapping("/info")
    public Map<String, Object> selectTeacherInfo() {


        long count = 0;
        List<TeacherTable> list;
        TeacherTable teacherTable;
        TeacherTableExample example = new TeacherTableExample();
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

        //返回查询条数
        try {
            count = teacherService.tableCountByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //查询数据
        try {
            list = teacherService.selectAllByExample(example);
            teacherTable =list.get(0);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //封装JSON
        map.put("code", 200);
        map.put("msg", "请求成功");
        map.put("count", count);
        map.put("data", teacherTable);
        return map;
    }
}

