package com.hdc.controller.college;


import com.google.common.base.CaseFormat;
import com.hdc.dto.AuditDto;
import com.hdc.dto.CollegeDto;
import com.hdc.entity.*;
import com.hdc.security.MyUser;
import com.hdc.service.AuditService;
import com.hdc.service.CollegeService;
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
@RequestMapping("/college/audit")
public class AuditController {

    @Autowired
    private AuditService auditService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private CollegeService collegeService;

    /**
     * 获取取审核处信息
     *
     * @param page        查询条件
     * @param auditName 审核处名称
     * @return 返回的JSON数据
     */
    @GetMapping("")
    public Map<String, Object> selectAll(Page page, String auditName) {



        long count = 0;
        List<AuditTable> list;
        AuditTableExample example = new AuditTableExample();
        AuditTableExample.Criteria criteria = example.createCriteria();
        Map<String, Object> map = new HashMap<>();
        Integer collegeId;
        //获取登录的用户ID
        try {
            MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            CollegeExample collegeExample = new CollegeExample();
            collegeExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());
            collegeId =collegeService.selectByExample(collegeExample).get(0).getCollegeId();
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }


        criteria.andCollegeIdEqualTo(collegeId);
        //添加查询条件
        if (StringUtils.isNotBlank(auditName)) {
            criteria.andAuditNameLike("%" + auditName + "%");
        }

        //返回查询条数
        try {
            count = auditService.tableCountByExample(example);
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
            list = auditService.selectAllByExample(example);
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
     * 检查审核处名称是否存在
     *
     * @param auditName 审核处名称
     * @param auditId 如果存在，则在检查的时候排除本身
     * @return code为200时为不存在，其余为存在重复
     */
    @GetMapping("/testAuditName")
    public Map<String, Object> testAuditName(String auditName, Integer auditId) {

        long count = 0;
        AuditTableExample example = new AuditTableExample();
        AuditTableExample.Criteria criteria = example.createCriteria();
        Map<String, Object> map = new HashMap<>();

        Integer collegeId;
        //获取登录的用户ID
        try {
            MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            CollegeExample collegeExample = new CollegeExample();
            collegeExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());
            collegeId =collegeService.selectByExample(collegeExample).get(0).getCollegeId();
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //添加查询条件
        if (collegeId != null && collegeId > 0&&StringUtils.isNotBlank(auditName)) {
            criteria.andCollegeIdEqualTo(collegeId);
            criteria.andAuditNameEqualTo(auditName);
        } else {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //更新检查重复时除去数据本身
        if (auditId != null && auditId > 0) {
            criteria.andAuditIdNotEqualTo(auditId);
        }

        //返回查询条数
        try {
            count = auditService.tableCountByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }

        if (count > 0) {
            map.put("code", 300);
            map.put("msg", "审核处名已经存在，请检查后重试");
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
     * @param username 审核处名称
     * @return code为200时为不存在，其余为存在重复
     */
    @GetMapping("/testUsername")
    public Map<String, Object> testUsername(String username, Integer auditId) {

        long count = 0;
        AuditTableExample example = new AuditTableExample();
        AuditTableExample.Criteria criteria = example.createCriteria();
        Map<String, Object> map = new HashMap<>();

        Integer collegeId;
        //获取登录的用户ID
        try {
            MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            CollegeExample collegeExample = new CollegeExample();
            collegeExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());
            collegeId =collegeService.selectByExample(collegeExample).get(0).getCollegeId();
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //添加查询条件
        if (collegeId != null && collegeId > 0&&StringUtils.isNotBlank(username)) {
            criteria.andUsernameEqualTo(username);
        } else {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //更新检查重复时除去数据本身
        if (auditId != null && auditId > 0) {
            criteria.andAuditIdNotEqualTo(auditId);
        }

        //返回查询条数
        try {
            count = auditService.tableCountByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }

        if (count > 0) {
            map.put("code", 300);
            map.put("msg", "审核处名已经存在，请检查后重试");
            return map;
        }
        //封装JSON
        map.put("code", 200);
        map.put("msg", "请求成功");
        return map;
    }

    /**
     * 插入一个审核处账号
     *
     * @param audit 审核处信息
     * @param errors  检查之后返回的错误数据
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PostMapping("")
    public Map<String, Object> insert(@Valid @RequestBody(required = false) AuditDto audit, BindingResult errors) {
        AuditTable auditTable = new AuditTable();
        Map<String, Object> map = new HashMap<>();
        String auditName, username, password,desc;

        Integer collegeId;
        //获取登录的用户ID
        try {
            MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            CollegeExample collegeExample = new CollegeExample();
            collegeExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());
            collegeId =collegeService.selectByExample(collegeExample).get(0).getCollegeId();
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
            auditName = audit.getAuditName();
            username = audit.getUsername();
            password = audit.getPassword();
            desc= audit.getDesc();

            auditTable.setCollegeId(collegeId);
            auditTable.setUsername(username);
            auditTable.setPassword(password);
            auditTable.setAuditName(auditName);
            auditTable.setDisplayName(auditName);
            auditTable.setDesc(desc);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //检查用户名和审核处名称是否被占用
        try {
            Map<String, Object> testAuditNameMap = testAuditName(auditName, null);
            Map<String, Object> testUsernameMap = testUsername(username, null);
            if (200 != (Integer) testAuditNameMap.get("code")) {
                return testAuditNameMap;
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
            usersService.insertAudit(auditTable);
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
     * 更新审核处信息
     *
     * @param audit 审核处信息
     * @param errors  检查之后返回的错误数据
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PutMapping("")
    public Map<String, Object> update(@Valid @RequestBody(required = false) AuditDto audit, BindingResult errors) {

        AuditTable auditTable = new AuditTable();
        Map<String, Object> map = new HashMap<>();
        Integer auditId, userId;
        String auditName, username, password,desc;

        Integer collegeId;
        //获取登录的用户ID
        try {
            MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            CollegeExample collegeExample = new CollegeExample();
            collegeExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());
            collegeId =collegeService.selectByExample(collegeExample).get(0).getCollegeId();
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
            auditId = audit.getAuditId();
            userId = auditService.selectByPrimaryKey(auditId).getUserId();
            auditName = audit.getAuditName();
            auditTable.setAuditName(auditName);
            username = audit.getUsername();
            password = audit.getPassword();
            desc= audit.getDesc();

            auditTable.setCollegeId(collegeId);
            auditTable.setUserId(userId);
            auditTable.setUsername(username);
            auditTable.setPassword(password);
            auditTable.setDisplayName(auditName);
            auditTable.setDesc(desc);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //检查用户名和审核处名称是否被占用
        try {
            Map<String, Object> testAuditNameMap = testAuditName(auditName, auditId);
            Map<String, Object> testUsernameMap = testUsername(username, auditId);
            if (200 != (Integer) testAuditNameMap.get("code")) {
                return testAuditNameMap;
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
            usersService.updateAudit(auditTable);
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
     * 删除审核处
     *
     * @param auditIdList 要删除的审核处ID列表
     * @return code为200时为删除成功，其它情况为插入失败
     */
    @DeleteMapping("")
    public Map<String, Object> delete(@RequestBody(required = false) List<Integer> auditIdList) {

        Map<String, Object> map = new HashMap<>();


        //检查传入信息
        if (auditIdList == null || auditIdList.size() <= 0) {
            map.put("code", 500);
            map.put("msg", "信息不能为空");
            return map;
        }

        //执行删除操作
        try {
            usersService.deleteAudit(auditIdList);
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
