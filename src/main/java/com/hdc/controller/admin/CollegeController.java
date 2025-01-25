package com.hdc.controller.admin;


import com.google.common.base.CaseFormat;
import com.hdc.dao.CollegeDao;
import com.hdc.dto.CollegeDto;
import com.hdc.entity.*;
import com.hdc.service.CollegeService;
import com.hdc.service.UsersService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/college")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private UsersService usersService;

    /**
     * 获取取学院信息
     *
     * @param page        查询条件
     * @param collegeName 学院名称
     * @return 返回的JSON数据
     */
    @GetMapping("")
    public Map<String, Object> selectAll(Page page, String collegeName) {

        long count = 0;
        List<College> list;
        CollegeExample example = new CollegeExample();
        Map<String, Object> map = new HashMap<>();

        //添加查询条件
        if (StringUtils.isNotBlank(collegeName)) {
            example.createCriteria().andCollegeNameLike("%" + collegeName + "%");
        }

        //返回查询条数
        try {
            count = collegeService.countByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
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
            list = collegeService.selectAllByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
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
     * 检查学院名称是否存在
     *
     * @param collegeName 学院名称
     * @return code为200时为不存在，其余为存在重复
     */
    @GetMapping("/testCollegeName")
    public Map<String, Object> testCollegeName(String collegeName, Integer collegeId) {

        long count = 0;
        CollegeExample example = new CollegeExample();
        CollegeExample.Criteria criteria = example.createCriteria();
        Map<String, Object> map = new HashMap<>();

        //添加查询条件
        if (StringUtils.isNotBlank(collegeName)) {
            criteria.andCollegeNameEqualTo(collegeName);
        } else {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //更新检查重复时除去数据本身
        if (collegeId != null && collegeId > 0) {
            criteria.andCollegeIdNotEqualTo(collegeId);
        }

        //返回查询条数
        try {
            count = collegeService.countByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }

        if (count > 0) {
            map.put("code", 300);
            map.put("msg", "学院名已经存在，请检查后重试");
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
     * @param username 学院名称
     * @return code为200时为不存在，其余为存在重复
     */
    @GetMapping("/testUsername")
    public Map<String, Object> testUsername(String username, Integer collegeId) {

        long count = 0;
        Integer userId = null;
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria usersCriteria = usersExample.createCriteria();
        Map<String, Object> map = new HashMap<>();

        //更新检查重复时除去数据本身
        if (collegeId != null && collegeId > 0) {
            try {
                userId = collegeService.selectUserByCollegeId(collegeId).getUserId();
                usersCriteria.andUserIdNotEqualTo(userId);
            } catch (Exception e) {
                map.put("code", 400);
                map.put("msg", "查询参数有误");
                return map;
            }
        }

        //添加查询条件
        if (StringUtils.isNotBlank(username)) {
            usersCriteria.andUsernameEqualTo(username);
        } else {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //返回查询条数
        try {
            count = usersService.countByExample(usersExample);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }


        if (count > 0) {
            map.put("code", 300);
            map.put("msg", "用户名已经存在，请检查后重试");
            return map;
        }

        //封装JSON
        map.put("code", 200);
        map.put("msg", "请求成功");
        return map;
    }

    /**
     * 插入一个学院账号
     *
     * @param college 学院信息
     * @param errors  检查之后返回的错误数据
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PostMapping("")
    public Map<String, Object> insert(@Valid @RequestBody(required = false) CollegeDto college, BindingResult errors) {

        Users user = new Users();
        UserInfo userInfo = new UserInfo();
        Map<String, Object> map = new HashMap<>();
        String collegeName, username, password;

        //检查错误，封装错误信息
        if (errors.getErrorCount() > 0) {
            map.put("code", 500);
            map.put("msg", errors.getAllErrors().get(0).getDefaultMessage());
            return map;
        }

        //赋值
        try {
            collegeName = college.getCollegeName();
            username = college.getUsername();
            password = college.getPassword();

            user.init();
            userInfo.init();
            user.setUsername(username);
            user.setPassword(password);
            userInfo.setDisplayName(collegeName);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //检查用户名和学院名称是否被占用
        try {
            Map<String, Object> testCollegeNameMap = testCollegeName(collegeName, null);
            Map<String, Object> testUsernameMap = testUsername(username, null);
            if (200 != (Integer) testCollegeNameMap.get("code")) {
                return testCollegeNameMap;
            }
            if (200 != (Integer) testUsernameMap.get("code")) {
                return testUsernameMap;
            }
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }

        //执行插入操作
        try {
            usersService.insertCollege(user, userInfo);
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
     * 批量插入学院账号
     *
     * @param collegeList 学院列表
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PostMapping("/excel")
    public Map<String, Object> excelInsert(@RequestBody(required = false) List<CollegeDto> collegeList) {

        Map<String, Object> map = new HashMap<>();

        try {
            usersService.batchInsertCollege(collegeList);
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
     * 更新学院信息
     *
     * @param college 学院信息
     * @param errors  检查之后返回的错误数据
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PutMapping("")
    public Map<String, Object> update(@Valid @RequestBody(required = false) CollegeDto college, BindingResult errors) {


        Users user = new Users();
        UserInfo userInfo = new UserInfo();
        Map<String, Object> map = new HashMap<>();
        Integer collegeId, userId;
        String collegeName, username, password;

        //检查错误，封装错误信息
        if (errors.getErrorCount() > 0) {
            map.put("code", 500);
            map.put("msg", errors.getAllErrors().get(0).getDefaultMessage());
            return map;
        }

        //赋值
        try {
            collegeId = college.getCollegeId();
            userId = collegeService.selectUserByCollegeId(collegeId).getUserId();
            collegeName = college.getCollegeName();
            username = college.getUsername();
            password = college.getPassword();

            user.setUserId(userId);
            user.setUsername(username);
            user.setPassword(password);
            userInfo.setDisplayName(collegeName);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //检查用户名和学院名称是否被占用
        try {
            Map<String, Object> testCollegeNameMap = testCollegeName(collegeName, collegeId);
            Map<String, Object> testUsernameMap = testUsername(username, collegeId);
            if (200 != (Integer) testCollegeNameMap.get("code")) {
                return testCollegeNameMap;
            }
            if (200 != (Integer) testUsernameMap.get("code")) {
                return testUsernameMap;
            }
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }

        //执行更新操作
        try {
            usersService.updateCollege(user, userInfo);
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
     * 删除学院
     *
     * @param collegeIdList 要删除的学院ID列表
     * @return code为200时为删除成功，其它情况为插入失败
     */
    @DeleteMapping("")
    public Map<String, Object> delete(@RequestBody(required = false) List<Integer> collegeIdList) {

        Map<String, Object> map = new HashMap<>();


        //检查传入信息
        if (collegeIdList == null || collegeIdList.size() <= 0) {
            map.put("code", 500);
            map.put("msg", "信息不能为空");
            return map;
        }

        //执行删除操作
        try {
            usersService.deleteCollege(collegeIdList);
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
