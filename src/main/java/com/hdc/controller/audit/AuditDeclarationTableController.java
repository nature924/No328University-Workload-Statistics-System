package com.hdc.controller.audit;


import com.hdc.entity.*;
import com.hdc.security.MyUser;
import com.hdc.service.*;
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
public class AuditDeclarationTableController {

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
     * 获取取评估指标信息
     *
     * @return 返回的JSON数据
     */
    @GetMapping("/evaluationIndex")
    public Map<String, Object> selectAllEvaluationIndex() {

        //获取登录的用户ID
        MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        AuditExample auditExample = new AuditExample();
        auditExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());
        Audit audit = auditService.selectByExample(auditExample).get(0);
        Integer collegeId = audit.getCollegeId();

        long count = 0;
        List<EvaluationIndex> list;
        EvaluationIndexExample example = new EvaluationIndexExample();
        EvaluationIndexExample.Criteria criteria = example.createCriteria();
        Map<String, Object> map = new HashMap<>();
        SystemBaseConfig systemConfig;

        try {
            systemConfig = systemConfigService.getSystemBaseConfig();
            criteria.andYearEqualTo(systemConfig.getSystemYear());
            criteria.andSemesterEqualTo(systemConfig.getSystemSemester());
            criteria.andCollegeIdEqualTo(collegeId);
        }catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //返回查询条数
        try {
            count = evaluationIndexService.countByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //查询数据
        try {
            list = evaluationIndexService.selectByExample(example);
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
     * 获取取主要观测点信息
     *
     * @return 返回的JSON数据
     */
    @GetMapping("/observationPoint")
    public Map<String, Object> selectAllObservationPoint() {

        //获取登录的用户ID
        MyUser userDetails = (MyUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        AuditExample auditExample = new AuditExample();
        auditExample.createCriteria().andUserIdEqualTo(userDetails.getMyUserId());
        Audit audit = auditService.selectByExample(auditExample).get(0);
        Integer collegeId = audit.getCollegeId();

        long count = 0;
        List<ObservationPoint> list;
        ObservationPointExample example = new ObservationPointExample();
        ObservationPointExample.Criteria criteria = example.createCriteria();
        Map<String, Object> map = new HashMap<>();
        SystemBaseConfig systemConfig;


        try {
            systemConfig = systemConfigService.getSystemBaseConfig();
            criteria.andYearEqualTo(systemConfig.getSystemYear());
            criteria.andSemesterEqualTo(systemConfig.getSystemSemester());
            criteria.andCollegeIdEqualTo(collegeId);
            example.setOrderByClause("evaluation_index_id asc,observation_point_id asc");
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //返回查询条数
        try {
            count = observationPointService.countByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //查询数据
        try {
            list = observationPointService.selectByExample(example);
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
     * 获取取主要观测点信息
     *
     * @return 返回的JSON数据
     */
    @GetMapping("/gradingStandard")
    public Map<String, Object> selectAllGradingStandard() {

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
        List<GradingStandard> list;
        GradingStandardExample example = new GradingStandardExample();
        GradingStandardExample.Criteria criteria = example.createCriteria();
        Map<String, Object> map = new HashMap<>();
        SystemBaseConfig systemConfig;


        try {
            systemConfig = systemConfigService.getSystemBaseConfig();
            criteria.andYearEqualTo(systemConfig.getSystemYear());
            criteria.andSemesterEqualTo(systemConfig.getSystemSemester());
            criteria.andAuditIdEqualTo(auditId);
            criteria.andCollegeIdEqualTo(collegeId);
            example.setOrderByClause("evaluation_index_id asc,observation_point_id asc,grading_standard_id asc");
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //返回查询条数
        try {
            count = gradingStandardService.countByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //查询数据
        try {
            list = gradingStandardService.selectByExample(example);
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
     * 获取取主要观测点信息
     *
     * @return 返回的JSON数据
     */
    @GetMapping("/college/gradingStandard")
    public Map<String, Object> selectCollegeGradingStandard() {

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
        List<GradingStandard> list;
        GradingStandardExample example = new GradingStandardExample();
        GradingStandardExample.Criteria criteria = example.createCriteria();
        Map<String, Object> map = new HashMap<>();
        SystemBaseConfig systemConfig;


        try {
            systemConfig = systemConfigService.getSystemBaseConfig();
            criteria.andYearEqualTo(systemConfig.getSystemYear());
            criteria.andSemesterEqualTo(systemConfig.getSystemSemester());
            criteria.andCollegeIdEqualTo(collegeId);
            example.setOrderByClause("evaluation_index_id asc,observation_point_id asc,grading_standard_id asc");
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //返回查询条数
        try {
            count = gradingStandardService.countByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //查询数据
        try {
            list = gradingStandardService.selectByExample(example);
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
}
