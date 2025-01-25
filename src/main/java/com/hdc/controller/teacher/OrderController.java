package com.hdc.controller.teacher;


import com.google.common.base.CaseFormat;
import com.hdc.dto.OrderDto;
import com.hdc.entity.*;
import com.hdc.security.MyUser;
import com.hdc.service.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderTableService orderTableService;

    @Autowired
    private SystemConfigService systemConfigService;

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private OrderFileService orderFileService;

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
    public Map<String, Object> selectAll(Page page, Byte status,Integer evaluationIndexId, Integer observationPointId,Integer auditId) {

        //获取登录的用户ID
        MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());
        Teacher teacher = teacherService.selectByExample(teacherExample).get(0);
        Integer collegeId =teacher.getCollegeId();
        Integer teacherId =teacher.getTeacherId();

        long count = 0;
        List<OrderTable> list;
        OrderTableExample example = new OrderTableExample();
        OrderTableExample.Criteria criteria = example.createCriteria();
        Map<String, Object> map = new HashMap<>();
        SystemBaseConfig systemConfig;

        //添加查询条件
        if (status!= null) {
            criteria.andStatusEqualTo(status);
        }


        //添加查询条件
        if (observationPointId!= null &&observationPointId>0) {
            criteria.andObservationPointIdEqualTo(observationPointId);
        }
        //添加查询条件
        if (evaluationIndexId!= null &&evaluationIndexId>0) {
            criteria.andEvaluationIndexIdEqualTo(evaluationIndexId);
        }
        //添加查询条件
        if (auditId!= null &&auditId>0) {
            criteria.andAuditIdEqualTo(auditId);
        }


        try {
            systemConfig = systemConfigService.getSystemBaseConfig();
            criteria.andYearEqualTo(systemConfig.getSystemYear());
            criteria.andSemesterEqualTo(systemConfig.getSystemSemester());
            criteria.andCollegeIdEqualTo(collegeId);
            criteria.andTeacherIdEqualTo(teacherId);
        }catch (Exception e) {
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
     * 检查申请单名称是否存在
     *
     * @param orderContent 申请单内容
     * @param orderId 如果存在，则在检查的时候排除本身
     * @return code为200时为不存在，其余为存在重复
     *//*
    @GetMapping("/testOrderContent")
    public Map<String, Object> testOrderName(String orderContent, Integer orderId) {



        long count = 0;
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
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
        if (StringUtils.isNotBlank(orderContent)) {
            criteria.andContentEqualTo(orderContent);
        } else {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //添加查询条件
        if (collegeId != null && collegeId > 0) {
            criteria.andCollegeIdEqualTo(collegeId);
        } else {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //更新检查重复时除去数据本身
        if (orderId != null && orderId > 0) {
            criteria.andOrderIdNotEqualTo(orderId);
        }

        //返回查询条数
        try {
            count = orderService.countByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }

        if (count > 0) {
            map.put("code", 300);
            map.put("msg", "申请单名已经存在，请检查后重试");
            return map;
        }

        //封装JSON
        map.put("code", 200);
        map.put("msg", "请求成功");
        return map;
    }
*/

    /**
     * 插入一个申请单
     *
     * @param orderDto 申请单信息
     * @param errors   检查之后返回的错误数据
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PostMapping("")
    public Map<String, Object> insert(@Valid @RequestBody(required = false) OrderDto orderDto, BindingResult errors) {


        Order order = new Order();
        Map<String, Object> map = new HashMap<>();
        String orderContent;
        SystemBaseConfig systemConfig;


        Integer collegeId, teacherId;
        //获取登录的用户ID
        try {
            //获取登录的用户ID
            MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            TeacherTableExample teacherTableExample = new TeacherTableExample();
            teacherTableExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());

            TeacherTable teacherTable = teacherService.selectAllByExample(teacherTableExample).get(0);
            collegeId = teacherTable.getCollegeId();
            teacherId = teacherTable.getTeacherId();
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
            systemConfig = systemConfigService.getSystemBaseConfig();

            order.setAuditId(orderDto.getAuditId());
            order.setAddTime(new Date());
            order.setCertifiedNote(null);
            order.setCertifiedTime(null);
            order.setCertifiedScore(null);
            order.setDeclarationNote(orderDto.getDeclarationNote());
            order.setGradingStandardId(orderDto.getGradingStandardId());
            order.setSelfReportScore(orderDto.getSelfReportScore());
            order.setStatus((byte) 1);
            order.setTeacherId(teacherId);
            order.setYear(systemConfig.getSystemYear());
            order.setSemester(systemConfig.getSystemSemester());


        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //执行插入操作
        try {
            orderService.insertSelective(order);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", e.getMessage());
            return map;
        }

        if(orderDto.getOrderFileIdList()!=null&&orderDto.getOrderFileIdList().size()>0){
            List<Long> orderFileIdList = orderDto.getOrderFileIdList();
            OrderFile orderFile = new OrderFile();
            OrderFileExample orderFileExample = new OrderFileExample();
            orderFileExample.createCriteria().andOrderFileIdIn(orderFileIdList);
            orderFile.setOrderId(order.getOrderId());

            try {
                orderFileService.updateByExampleSelective(orderFile, orderFileExample);
            } catch (Exception e) {
                map.put("code", 500);
                map.put("msg", e.getMessage());
                return map;
            }
        }


        map.put("code", 200);
        map.put("msg", "请求成功");
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

        Integer collegeId, teacherId;
        //获取登录的用户ID
        try {
            //获取登录的用户ID
            MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            TeacherTableExample teacherTableExample = new TeacherTableExample();
            teacherTableExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());

            TeacherTable teacherTable = teacherService.selectAllByExample(teacherTableExample).get(0);
            collegeId = teacherTable.getCollegeId();
            teacherId = teacherTable.getTeacherId();
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
            order.setAddTime(new Date());
            order.setStatus((byte) 1);
            order.setDeclarationNote(orderDto.getDeclarationNote());
            order.setSelfReportScore(orderDto.getSelfReportScore());

        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }


        //执行更新操作
        try {
            orderService.updateByPrimaryKeySelective(order);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", e.getMessage());
            return map;
        }

        List<Long> OrderFileIdList = orderDto.getOrderFileIdList();
        if (OrderFileIdList != null && OrderFileIdList.size()>0) {

            //初始化本审核单订文件对照表
            OrderFile orderFileClean = new OrderFile();
            OrderFileExample orderFileExampleClean = new OrderFileExample();
            orderFileExampleClean.createCriteria().andOrderIdEqualTo(order.getOrderId());
            orderFileClean.setOrderId((long) 0);
            try {
                orderFileService.updateByExampleSelective(orderFileClean, orderFileExampleClean);
            } catch (Exception e) {
                map.put("code", 500);
                map.put("msg", e.getMessage());
                return map;
            }

            //更新审核单订文件对照表
            OrderFile orderFile = new OrderFile();
            OrderFileExample orderFileExample = new OrderFileExample();
            orderFileExample.createCriteria().andOrderFileIdIn(OrderFileIdList);
            orderFile.setOrderId(order.getOrderId());
            try {
                orderFileService.updateByExampleSelective(orderFile, orderFileExample);
            } catch (Exception e) {
                map.put("code", 500);
                map.put("msg", e.getMessage());
                return map;
            }

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
     */
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
    }
}
