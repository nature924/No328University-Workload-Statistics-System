package com.hdc.controller.audit;


import com.google.common.base.CaseFormat;
import com.hdc.dto.OrderDto;
import com.hdc.entity.Audit;
import com.hdc.entity.AuditExample;
import com.hdc.entity.Order;
import com.hdc.entity.OrderTable;
import com.hdc.entity.OrderTableExample;
import com.hdc.entity.Page;
import com.hdc.entity.SystemBaseConfig;
import com.hdc.entity.SystemConfig;
import com.hdc.security.MyUser;
import com.hdc.service.AuditService;
import com.hdc.service.CollegeService;
import com.hdc.service.EvaluationIndexService;
import com.hdc.service.GradingStandardService;
import com.hdc.service.ObservationPointService;
import com.hdc.service.OrderFileService;
import com.hdc.service.OrderService;
import com.hdc.service.OrderTableService;
import com.hdc.service.SystemConfigService;
import com.hdc.service.TeacherService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@RestController
@RequestMapping("/audit/order")
public class AuditOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderTableService orderTableService;

    @Autowired
    private SystemConfigService systemConfigService;

    private CollegeService collegeService;

    @Autowired
    private AuditService auditService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private OrderFileService orderFileService;

    @Autowired
    private EvaluationIndexService evaluationIndexService;

    @Autowired
    private ObservationPointService observationPointService;

    @Autowired
    private GradingStandardService gradingStandardService;

    /**
     * 获取取申请单信息
     *
     * @param page        查询条件
     * @param content 申请单名称
     * @return 返回的JSON数据
     */
    /**
     * 获取所有申报单信息
     *
     * @return 返回的JSON数据
     */
    @GetMapping("")
    public Map<String, Object> selectAll(Page page, Byte status, Integer evaluationIndexId, Integer observationPointId, Integer gradingStandard, String teacher) {

        //获取登录的用户ID
        MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        AuditExample auditExample = new AuditExample();
        auditExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());
        Audit audit = auditService.selectByExample(auditExample).get(0);
        Integer auditId = audit.getAuditId();
        Integer collegeId = audit.getCollegeId();

        long count = 0;
        List<OrderTable> list;
        OrderTableExample example = new OrderTableExample();
        OrderTableExample.Criteria criteria = example.createCriteria();
        Map<String, Object> map = new HashMap<>();
        SystemBaseConfig systemConfig;

        //添加查询条件
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }


        //添加查询条件
        if (observationPointId != null && observationPointId > 0) {
            criteria.andObservationPointIdEqualTo(observationPointId);
        }
        //添加查询条件
        if (evaluationIndexId != null && evaluationIndexId > 0) {
            criteria.andEvaluationIndexIdEqualTo(evaluationIndexId);
        }
        //添加查询条件
        if (gradingStandard != null && gradingStandard > 0) {
            criteria.andGradingStandardIdEqualTo(gradingStandard);
        }

        if (StringUtils.isNotBlank(teacher)) {

            criteria.andTeacherNameLike("%" + teacher + "%");

        }


        try {
            systemConfig = systemConfigService.getSystemBaseConfig();
            criteria.andYearEqualTo(systemConfig.getSystemYear());
            criteria.andSemesterEqualTo(systemConfig.getSystemSemester());
            criteria.andCollegeIdEqualTo(collegeId);
            criteria.andAuditIdEqualTo(auditId);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }


        //返回查询条数
        try {
            count = orderTableService.countOrderByExample(example);
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
            list = orderTableService.selectOrderByExample(example);
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
     * 更新申请单信息
     *
     * @param orderDto 申请单信息
     * @param errors   检查之后返回的错误数据
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PutMapping("")
    public Map<String, Object> update(@Valid @RequestBody(required = false) OrderDto orderDto, BindingResult errors) {
        SystemConfig systemConfig;

        Order order = new Order();
        Map<String, Object> map = new HashMap<>();

        Integer auditId, teacherId;
        //获取登录的用户ID
        try {
            //获取登录的用户ID
            MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            AuditExample auditExample = new AuditExample();
            auditExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());
            Audit audit = auditService.selectByExample(auditExample).get(0);
            auditId = audit.getAuditId();
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

            order.setOrderId(orderDto.getOrderId());
            order.setCertifiedTime(new Date());
            if (orderDto.getStatus() != null && (orderDto.getStatus() == 2 || orderDto.getStatus() == 3)) {
                order.setStatus(orderDto.getStatus());
            } else {
                map.put("code", 500);
                map.put("msg", "审核单状态错误");
                return map;
            }

            order.setCertifiedNote(orderDto.getCertifiedNote());
            order.setCertifiedScore(orderDto.getCertifiedScore());

        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }
        System.out.println(auditId + " " + orderDto.getAuditId());
        if (auditId != null && auditId == orderDto.getAuditId()) {
            //执行更新操作
            try {
                orderService.updateByPrimaryKeySelective(order);
            } catch (Exception e) {
                map.put("code", 500);
                map.put("msg", e.getMessage());
                return map;
            }
        } else {
            map.put("code", 500);
            map.put("msg", "审核处身份不正确");
            return map;
        }


        map.put("code", 200);
        map.put("msg", "请求成功");
        return map;
    }

    /**
     * 删除申请单
     *
     * @param orderIdList 要删除的申请单ID列表
     * @return code为200时为删除成功，其它情况为插入失败
     *//*
    @DeleteMapping("")
    public Map<String, Object> delete(@RequestBody(required = false) List<Long> orderIdList) {

        Map<String, Object> map = new HashMap<>();
        OrderExample orderexample = new OrderExample();
        OrderFileExample orderFileExample = new OrderFileExample();
        orderexample.createCriteria().andOrderIdIn(orderIdList);
        orderFileExample.createCriteria().andOrderIdIn(orderIdList);
        //检查传入信息
        if (orderIdList == null || orderIdList.size() <= 0) {
            map.put("code", 500);
            map.put("msg", "信息不能为空");
            return map;
        }

        //执行删除操作
        try {

            orderService.deleteByExample(orderexample);
            orderFileService.deleteByExample(orderFileExample);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", e.getMessage());
            return map;
        }

        map.put("code", 200);
        map.put("msg", "请求成功");
        return map;
    }*/


}
