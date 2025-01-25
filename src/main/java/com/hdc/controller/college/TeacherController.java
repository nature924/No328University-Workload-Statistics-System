package com.hdc.controller.college;


import com.google.common.base.CaseFormat;
import com.hdc.dto.AuditDto;
import com.hdc.dto.CollegeDto;
import com.hdc.dto.TeacherDto;
import com.hdc.entity.*;
import com.hdc.security.MyUser;
import com.hdc.service.AuditService;
import com.hdc.service.CollegeService;
import com.hdc.service.TeacherService;
import com.hdc.service.UsersService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/college/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private UsersService usersService;

    /**
     * 获取取教师信息
     *
     * @param page        查询条件
     * @param teacherName 教师名称
     * @return 返回的JSON数据
     */
    @GetMapping("")
    public Map<String, Object> selectAll(Page page, String teacherName, Integer teacherTitleId) {


        long count = 0;
        List<TeacherTable> list;
        TeacherTableExample example = new TeacherTableExample();
        TeacherTableExample.Criteria criteria = example.createCriteria();
        Map<String, Object> map = new HashMap<>();

        Integer collegeId;
        //获取登录的用户ID
        try {
            MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            CollegeExample collegeExample = new CollegeExample();
            collegeExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());
            collegeId = collegeService.selectByExample(collegeExample).get(0).getCollegeId();
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "学院ID获取失败，请重试");
            return map;
        }

        criteria.andCollegeIdEqualTo(collegeId);

        //添加查询条件
        if (StringUtils.isNotBlank(teacherName)) {
            criteria.andTeacherNameLike("%" + teacherName + "%");
        }

        //添加查询条件
        if (teacherTitleId != null && teacherTitleId > 0) {
            criteria.andTeacherTitleIdEqualTo(teacherTitleId);
        }

        //返回查询条数
        try {
            count = teacherService.tableCountByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "教师count获取失败");
            return map;
        }

        //添加分页和排序条件
        Integer limit = page.getLimit();
        Integer offer = page.getPage();
        String field = page.getField();
        String order = page.getOrder();
        if ((limit != null && limit >= 0) && (offer != null && offer >= 0)) {
            example.setLimit(page.getLimit());
            example.setOffset((page.getPage() - 1) * page.getLimit());
        }
        if (StringUtils.isNotBlank(field) && StringUtils.isNotBlank(order)) {
            field = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, page.getField());
            example.setOrderByClause(field + " " + order);
        }


        //查询数据
        try {
            list = teacherService.selectAllByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "查询失败");
            return map;
        }

        //封装JSON
        map.put("code", 200);
        map.put("msg", "请求成功");
        map.put("count", count);
        map.put("data", list);
        return map;
    }

    /**
     * 检查教师名称是否存在
     *
     * @param teacherName 教师名称
     * @param teacherId   如果存在，则在检查的时候排除本身
     * @return code为200时为不存在，其余为存在重复
     */
    @GetMapping("/testTeacherName")
    public Map<String, Object> testTeacherName(String teacherName, Integer teacherId) {


        long count = 0;
        TeacherTableExample example = new TeacherTableExample();
        TeacherTableExample.Criteria criteria = example.createCriteria();
        Map<String, Object> map = new HashMap<>();

        Integer collegeId;
        //获取登录的用户ID
        try {
            MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            CollegeExample collegeExample = new CollegeExample();
            collegeExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());
            collegeId = collegeService.selectByExample(collegeExample).get(0).getCollegeId();
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //添加查询条件
        if (collegeId != null && collegeId > 0 && StringUtils.isNotBlank(teacherName)) {
            criteria.andCollegeIdEqualTo(collegeId);
            criteria.andTeacherNameEqualTo(teacherName);
        } else {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //更新检查重复时除去数据本身
        if (teacherId != null && teacherId > 0) {
            criteria.andTeacherIdNotEqualTo(teacherId);
        }

        //返回查询条数
        try {
            count = teacherService.tableCountByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }

        if (count > 0) {
            map.put("code", 300);
            map.put("msg", "教师名已经存在，请检查后重试");
            return map;
        }

        //封装JSON
        map.put("code", 200);
        map.put("msg", "请求成功");
        return map;
    }

    /**
     * 检查用户名是否存在
     *
     * @param username 教师名称
     * @return code为200时为不存在，其余为存在重复
     */
    @GetMapping("/testUsername")
    public Map<String, Object> testUsername(String username, Integer teacherId) {


        long count = 0;
        TeacherTableExample example = new TeacherTableExample();
        TeacherTableExample.Criteria criteria = example.createCriteria();
        Map<String, Object> map = new HashMap<>();

        Integer collegeId;
        //获取登录的用户ID
        try {
            MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            CollegeExample collegeExample = new CollegeExample();
            collegeExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());
            collegeId = collegeService.selectByExample(collegeExample).get(0).getCollegeId();
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }


        //添加查询条件
        if (collegeId != null && collegeId > 0 && StringUtils.isNotBlank(username)) {
            criteria.andUsernameEqualTo(username);
        } else {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //更新检查重复时除去数据本身
        if (teacherId != null && teacherId > 0) {
            criteria.andTeacherIdNotEqualTo(teacherId);
        }

        //返回查询条数
        try {
            count = teacherService.tableCountByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }

        if (count > 0) {
            map.put("code", 300);
            map.put("msg", "教师名已经存在，请检查后重试");
            return map;
        }
        //封装JSON
        map.put("code", 200);
        map.put("msg", "请求成功");
        return map;
    }

    /**
     * 检查用户名是否存在
     *
     * @param EmployeeId 教师工号
     * @return code为200时为不存在，其余为存在重复
     */
    @GetMapping("/testEmployeeId")
    public Map<String, Object> testEmployeeId(String EmployeeId, Integer teacherId) {


        long count = 0;
        TeacherTableExample example = new TeacherTableExample();
        TeacherTableExample.Criteria criteria = example.createCriteria();
        Map<String, Object> map = new HashMap<>();

        Integer collegeId;
        //获取登录的用户ID
        try {
            MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            CollegeExample collegeExample = new CollegeExample();
            collegeExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());
            collegeId = collegeService.selectByExample(collegeExample).get(0).getCollegeId();
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }


        //添加查询条件
        if (collegeId != null && collegeId > 0 && StringUtils.isNotBlank(EmployeeId)) {
            criteria.andEmployeeIdEqualTo(EmployeeId);
        } else {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //更新检查重复时除去数据本身
        if (teacherId != null && teacherId > 0) {
            criteria.andTeacherIdNotEqualTo(teacherId);
        }

        //返回查询条数
        try {
            count = teacherService.tableCountByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }

        if (count > 0) {
            map.put("code", 300);
            map.put("msg", "教师工号已经存在，请检查后重试");
            return map;
        }
        //封装JSON
        map.put("code", 200);
        map.put("msg", "请求成功");
        return map;
    }

    /**
     * 插入一个教师账号
     *
     * @param teacher 教师信息
     * @param errors  检查之后返回的错误数据
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PostMapping("")
    public Map<String, Object> insert(@Valid @RequestBody(required = false) TeacherDto teacher, BindingResult errors) {


        TeacherTable teacherTable = new TeacherTable();
        Map<String, Object> map = new HashMap<>();
        String teacherName, username, password, employeeId;
        Integer teacherTitleId;

        Integer collegeId;
        //获取登录的用户ID
        try {
            MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            CollegeExample collegeExample = new CollegeExample();
            collegeExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());
            collegeId = collegeService.selectByExample(collegeExample).get(0).getCollegeId();
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //检查错误，封装错误信息
        if (errors.getErrorCount() > 0) {
            map.put("code", 500);
            map.put("msg", errors.getAllErrors().get(0).getDefaultMessage());
            return map;
        }

        //赋值
        try {
            teacherName = teacher.getTeacherName();
            username = teacher.getUsername();
            password = teacher.getPassword();
            teacherTitleId = teacher.getTeacherTitleId();
            employeeId = teacher.getEmployeeId();

            teacherTable.setCollegeId(collegeId);
            teacherTable.setUsername(username);
            teacherTable.setPassword(password);
            teacherTable.setTeacherName(teacherName);
            teacherTable.setEmployeeId(employeeId);
            teacherTable.setDisplayName(teacherName);
            teacherTable.setTeacherTitleId(teacherTitleId);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //检查用户名和教师名称是否被占用
        try {
            Map<String, Object> testTeacherNameMap = testTeacherName(teacherName, null);
            Map<String, Object> testUsernameMap = testUsername(username, null);
            Map<String, Object> testEmployeeId = testUsername(employeeId, null);

            if (200 != (Integer) testTeacherNameMap.get("code")) {
                return testTeacherNameMap;
            }
            if (200 != (Integer) testUsernameMap.get("code")) {
                return testUsernameMap;
            }
            if (200 != (Integer) testEmployeeId.get("code")) {
                return testUsernameMap;
            }
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }

        //执行插入操作
        try {
            usersService.insertTeacher(teacherTable);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", e.getMessage());
            return map;
        }

        map.put("code", 200);
        map.put("msg", "请求成功");
        return map;
    }

    /**
     * 批量插入教师账号
     *
     * @param teacherList 学院列表
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PostMapping("/excel")
    public Map<String, Object> excelInsert(@RequestBody(required = false) List<TeacherTable> teacherList) {

        Map<String, Object> map = new HashMap<>();

        Integer collegeId;
        //获取登录的用户ID
        try {
            MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            CollegeExample collegeExample = new CollegeExample();
            collegeExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());
            collegeId = collegeService.selectByExample(collegeExample).get(0).getCollegeId();
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

//      将教师列表中的学院ID设置是当前登陆的的学院用户的学院ID
        for (TeacherTable teacher : teacherList
        ) {
            teacher.setCollegeId(collegeId);
        }

        try {
            usersService.batchInsertTeacher(teacherList);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", e.getMessage());
            return map;
        }
        map.put("code", 200);
        map.put("msg", "请求成功");
        return map;
    }


    /**
     * 更新教师信息
     *
     * @param teacher 教师信息
     * @param errors  检查之后返回的错误数据
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PutMapping("")
    public Map<String, Object> update(@Valid @RequestBody(required = false) TeacherDto teacher, BindingResult errors) {


        TeacherTable teacherTable = new TeacherTable();
        Map<String, Object> map = new HashMap<>();
        Integer teacherId, userId, teacherTitleId;
        String teacherName, username, password, employeeId;

        Integer collegeId;
        //获取登录的用户ID
        try {
            MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            CollegeExample collegeExample = new CollegeExample();
            collegeExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());
            collegeId = collegeService.selectByExample(collegeExample).get(0).getCollegeId();
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }


        //检查错误，封装错误信息
        if (errors.getErrorCount() > 0) {
            map.put("code", 500);
            map.put("msg", errors.getAllErrors().get(0).getDefaultMessage());
            return map;
        }

        //赋值
        try {
            teacherId = teacher.getTeacherId();
            userId = teacherService.selectByPrimaryKey(teacherId).getUserId();
            teacherName = teacher.getTeacherName();
            teacherTable.setTeacherName(teacherName);
            username = teacher.getUsername();
            password = teacher.getPassword();
            teacherTitleId = teacher.getTeacherTitleId();
            employeeId = teacher.getEmployeeId();

            teacherTable.setCollegeId(collegeId);
            teacherTable.setUserId(userId);
            teacherTable.setUsername(username);
            teacherTable.setEmployeeId(employeeId);
            teacherTable.setPassword(password);
            teacherTable.setDisplayName(teacherName);
            teacherTable.setTeacherTitleId(teacherTitleId);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //检查用户名和教师名称是否被占用
        try {
            Map<String, Object> testTeacherNameMap = testTeacherName(teacherName, teacherId);
            Map<String, Object> testUsernameMap = testUsername(username, teacherId);
            Map<String, Object> testEmployeeIdMap = testEmployeeId(employeeId, teacherId);
            if (200 != (Integer) testTeacherNameMap.get("code")) {
                return testTeacherNameMap;
            }
            if (200 != (Integer) testUsernameMap.get("code")) {
                return testUsernameMap;
            }
            if (200 != (Integer) testEmployeeIdMap.get("code")) {
                return testUsernameMap;
            }
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }

        //执行更新操作
        try {
            usersService.updateTeacher(teacherTable);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", e.getMessage());
            return map;
        }

        map.put("code", 200);
        map.put("msg", "请求成功");
        return map;
    }

    /**
     * 删除教师
     *
     * @param teacherIdList 要删除的教师ID列表
     * @return code为200时为删除成功，其它情况为插入失败
     */
    @DeleteMapping("")
    public Map<String, Object> delete(@RequestBody(required = false) List<Integer> teacherIdList) {

        Map<String, Object> map = new HashMap<>();


        //检查传入信息
        if (teacherIdList == null || teacherIdList.size() <= 0) {
            map.put("code", 500);
            map.put("msg", "信息不能为空");
            return map;
        }

        //执行删除操作
        try {
            usersService.deleteTeacher(teacherIdList);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", e.getMessage());
            return map;
        }

        map.put("code", 200);
        map.put("msg", "请求成功");
        return map;
    }
}
