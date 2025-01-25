package com.hdc.controller.college;


import com.google.common.base.CaseFormat;
import com.hdc.dto.GradingStandardDto;
import com.hdc.entity.*;
import com.hdc.security.MyUser;
import com.hdc.service.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/college/gradingStandard")
public class GradingStandardController {

    @Autowired
    private EvaluationIndexService evaluationIndexService;

    @Autowired
    private ObservationPointService observationPointService;

    @Autowired
    private GradingStandardService gradingStandardService;

    @Autowired
    private AuditService auditService;

    @Autowired
    private SystemConfigService systemConfigService;

    @Autowired
    private CollegeService collegeService;

    /**
     * 获取取评分标准信息
     *
     * @param page    查询条件
     * @param content 评分标准名称
     * @return 返回的JSON数据
     */
    @GetMapping("")
    public Map<String, Object> selectAll(Page page, String content, Integer evaluationIndexId, Integer observationPointId, Integer auditId) {

        long count = 0;
        List<GradingStandard> list;
        GradingStandardExample example = new GradingStandardExample();
        GradingStandardExample.Criteria criteria = example.createCriteria();
        Map<String, Object> map = new HashMap<>();
        SystemBaseConfig systemConfig;

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
        if (StringUtils.isNotBlank(content)) {
            criteria.andContentLike("%" + content + "%");
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
        if (auditId != null && auditId > 0) {
            criteria.andAuditIdEqualTo(auditId);
        }

        try {
            systemConfig = systemConfigService.getSystemBaseConfig();
            criteria.andYearEqualTo(systemConfig.getSystemYear());
            criteria.andSemesterEqualTo(systemConfig.getSystemSemester());
            criteria.andCollegeIdEqualTo(collegeId);
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
     * 检查评分标准名称是否存在
     *
     * @param gradingStandardContent 评分标准内容
     * @param gradingStandardId      如果存在，则在检查的时候排除本身
     * @return code为200时为不存在，其余为存在重复
     */
    @GetMapping("/testGradingStandardContent")
    public Map<String, Object> testGradingStandardName(String gradingStandardContent, Integer gradingStandardId) {


        long count = 0;
        GradingStandardExample example = new GradingStandardExample();
        GradingStandardExample.Criteria criteria = example.createCriteria();
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
        if (StringUtils.isNotBlank(gradingStandardContent)) {
            criteria.andContentEqualTo(gradingStandardContent);
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
        if (gradingStandardId != null && gradingStandardId > 0) {
            criteria.andGradingStandardIdNotEqualTo(gradingStandardId);
        }

        //返回查询条数
        try {
            count = gradingStandardService.countByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }

        if (count > 0) {
            map.put("code", 300);
            map.put("msg", "评分标准名已经存在，请检查后重试");
            return map;
        }

        //封装JSON
        map.put("code", 200);
        map.put("msg", "请求成功");
        return map;
    }

    /**
     * 插入一个评分标准账号
     *
     * @param gradingStandardDto 评分标准信息
     * @param errors             检查之后返回的错误数据
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PostMapping("")
    public Map<String, Object> insert(@Valid @RequestBody(required = false) GradingStandardDto gradingStandardDto, BindingResult errors) {


        GradingStandard gradingStandard = new GradingStandard();
        Map<String, Object> map = new HashMap<>();
        String gradingStandardContent;
        SystemBaseConfig systemConfig;

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
            systemConfig = systemConfigService.getSystemBaseConfig();

            gradingStandard.setContent(gradingStandardDto.getContent());
            gradingStandard.setCollegeId(collegeId);
            gradingStandard.setAuditId(gradingStandardDto.getAuditId());
            gradingStandard.setObservationPointId(gradingStandardDto.getObservationPointId());
            gradingStandard.setNote(gradingStandardDto.getNote());
            gradingStandard.setGradingBasis(gradingStandardDto.getGradingBasis());
            gradingStandard.setEvaluationIndexId(gradingStandardDto.getEvaluationIndexId());
            gradingStandard.setYear(systemConfig.getSystemYear());
            gradingStandard.setSemester(systemConfig.getSystemSemester());

        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        /*//检查用户名和评分标准名称是否被占用
        try {
            Map<String, Object> testGradingStandardNameMap = testGradingStandardName(gradingStandardContent, null);
            if (200 != (Integer) testGradingStandardNameMap.get("code")) {
                return testGradingStandardNameMap;
            }
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }*/

        //执行插入操作
        try {
            gradingStandardService.insert(gradingStandard);
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
     * 批量插入评分标准
     *
     * @param declarationTableList 评分标准列表
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PostMapping("/excel")
    public Map<String, Object> excelInsert(@RequestBody(required = false) List<DeclarationTable> declarationTableList) {

        Map<String, Object> map = new HashMap<>();
        List<GradingStandard> gradingStandardList = new ArrayList<>();
        SystemBaseConfig systemConfig;

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

        //赋值
        try {
            systemConfig = systemConfigService.getSystemBaseConfig();
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //获取一级分类内容,ID对应的hashMap键值对
        Map<String, Integer> evaluationIndexMap = new HashMap<>();
        EvaluationIndexExample evaluationIndexExample = new EvaluationIndexExample();
        EvaluationIndexExample.Criteria evaluationIndexCriteria = evaluationIndexExample.createCriteria();
        evaluationIndexCriteria.andYearEqualTo(systemConfig.getSystemYear());
        evaluationIndexCriteria.andSemesterEqualTo(systemConfig.getSystemSemester());
        evaluationIndexCriteria.andCollegeIdEqualTo(collegeId);

        List<EvaluationIndex> evaluationIndexList = evaluationIndexService.selectByExample(evaluationIndexExample);

        for (EvaluationIndex evaluationIndex : evaluationIndexList
        ) {
            evaluationIndexMap.put(evaluationIndex.getContent(), evaluationIndex.getEvaluationIndexId());
        }

        //获取二级分类内容,ID对应的hashMap键值对
        Map<String, ObservationPoint> observationPointMap = new HashMap<>();
        ObservationPointExample observationPointExample = new ObservationPointExample();
        ObservationPointExample.Criteria observationPointCriteria = observationPointExample.createCriteria();
        observationPointCriteria.andYearEqualTo(systemConfig.getSystemYear());
        observationPointCriteria.andSemesterEqualTo(systemConfig.getSystemSemester());
        observationPointCriteria.andCollegeIdEqualTo(collegeId);

        List<ObservationPoint> observationPointList = observationPointService.selectByExample(observationPointExample);

        for (ObservationPoint observationPoint : observationPointList
        ) {
            observationPointMap.put(observationPoint.getContent(), observationPoint);
        }

        //获取审核机构,ID对应的hashMap键值对
        Map<String, Integer> auditMap = new HashMap<>();
        AuditExample auditExample = new AuditExample();
        AuditExample.Criteria auditCriteria = auditExample.createCriteria();
        auditCriteria.andCollegeIdEqualTo(collegeId);

        List<Audit> auditList = auditService.selectByExample(auditExample);

        for (Audit audit : auditList
        ) {
            auditMap.put(audit.getAuditName(), audit.getAuditId());
            System.out.println(audit.getAuditName() + " : " + audit.getAuditId());
        }


//      设置导入项的学院、年份、学期,并转换为observationPoint列表
        String evaluationIndexContent, observationPointContent, gradingStandardContent, auditName, grading_basis, note;
        Integer inputEvaluationIndexId, QueryEvaluationIndexId, observationPointId, auditId, semester, year;
        int declarationTableListCount = 0;
        for (DeclarationTable declarationTable : declarationTableList
        ) {

            declarationTableListCount++;
            GradingStandard gradingStandard = new GradingStandard();
            ObservationPoint observationPoint;
            evaluationIndexContent = declarationTable.getEvaluationIndexContent();
            inputEvaluationIndexId = evaluationIndexMap.get(evaluationIndexContent);
            observationPointContent = declarationTable.getObservationPointContent();
            observationPoint = observationPointMap.get(observationPointContent);

            if (observationPoint == null) {
                map.put("code", 500);
                map.put("msg", "第" + declarationTableListCount + "行观测点不存在，请检查后重试！");
                return map;
            }

            observationPointId = observationPoint.getObservationPointId();
            QueryEvaluationIndexId = observationPoint.getEvaluationIndexId();
            auditName = declarationTable.getAuditName();
            auditId = auditMap.get(auditName);

            System.out.println(auditName + " 2: " + auditId);

            gradingStandardContent = declarationTable.getGradingStandardContent();
            grading_basis = declarationTable.getGradingBasis();
            note = declarationTable.getNote();
            semester = systemConfig.getSystemSemester();
            year = systemConfig.getSystemYear();

            if (!StringUtils.isNotBlank(evaluationIndexContent)) {
                map.put("code", 500);
                map.put("msg", "第" + declarationTableListCount + "行评估指标数据为空，请检查后重试！");
                return map;
            }

            if (inputEvaluationIndexId == null || inputEvaluationIndexId <= 0) {
                map.put("code", 500);
                map.put("msg", "第" + declarationTableListCount + "行评估指标不存在，请检查后重试！");
                return map;
            }

            if (inputEvaluationIndexId != QueryEvaluationIndexId) {
                map.put("code", 500);
                map.put("msg", "第" + declarationTableListCount + "行评估指标与主要观测点不匹配，请检查后重试！");
                return map;
            }

            if (!StringUtils.isNotBlank(observationPointContent)) {
                map.put("code", 500);
                map.put("msg", "第" + declarationTableListCount + "行观测点数据为空，请检查后重试！");
                return map;
            }

            if (observationPointId == null || observationPointId <= 0) {
                map.put("code", 500);
                map.put("msg", "第" + declarationTableListCount + "行观测点不存在，请检查后重试！");
                return map;
            }

            if (!StringUtils.isNotBlank(auditName)) {
                map.put("code", 500);
                map.put("msg", "第" + declarationTableListCount + "行审核机构为空，请检查后重试！");
                return map;
            }

            if (auditId == null || auditId <= 0) {
                map.put("code", 500);
                map.put("msg", "第" + declarationTableListCount + "行审核机构不存在，请检查后重试！");
                return map;
            }

            if (!StringUtils.isNotBlank(gradingStandardContent)) {
                map.put("code", 500);
                map.put("msg", "第" + declarationTableListCount + "行评分标准数据为空，请检查后重试！");
                return map;
            }

            if (semester == null || semester <= 0) {
                map.put("code", 500);
                map.put("msg", "第" + declarationTableListCount + "学期信息错误，请联系总管理员！");
                return map;
            }

            if (year == null || year <= 0) {
                map.put("code", 500);
                map.put("msg", "第" + declarationTableListCount + "学年信息错误，请联系总管理员！");
                return map;
            }

            gradingStandard.setEvaluationIndexId(QueryEvaluationIndexId);
            gradingStandard.setObservationPointId(observationPointId);
            gradingStandard.setContent(observationPointContent);
            gradingStandard.setAuditId(auditId);
            gradingStandard.setCollegeId(collegeId);
            gradingStandard.setSemester(semester);
            gradingStandard.setYear(year);
            gradingStandard.setGradingBasis(grading_basis);
            gradingStandard.setNote(note);


            gradingStandardList.add(gradingStandard);
        }

        try {
            gradingStandardService.batchInsertGradingStandard(gradingStandardList);
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
     * 更新评分标准信息
     *
     * @param gradingStandardDto 评分标准信息
     * @param errors             检查之后返回的错误数据
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PutMapping("")
    public Map<String, Object> update(@Valid @RequestBody(required = false) GradingStandardDto gradingStandardDto, BindingResult errors) {
        SystemBaseConfig systemConfig;

        GradingStandard gradingStandard = new GradingStandard();
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


        //检查错误，封装错误信息
        if (errors.getErrorCount() > 0) {
            map.put("code", 500);
            map.put("msg", errors.getAllErrors().get(0).getDefaultMessage());
            return map;
        }

        //赋值
        try {
            systemConfig = systemConfigService.getSystemBaseConfig();

            gradingStandard.setGradingStandardId(gradingStandardDto.getGradingStandardId());
            gradingStandard.setContent(gradingStandardDto.getContent());
            gradingStandard.setCollegeId(collegeId);
            gradingStandard.setAuditId(gradingStandardDto.getAuditId());
            gradingStandard.setObservationPointId(gradingStandardDto.getObservationPointId());
            gradingStandard.setNote(gradingStandardDto.getNote());
            gradingStandard.setGradingBasis(gradingStandardDto.getGradingBasis());
            gradingStandard.setEvaluationIndexId(gradingStandardDto.getEvaluationIndexId());
            gradingStandard.setYear(systemConfig.getSystemYear());
            gradingStandard.setSemester(systemConfig.getSystemSemester());

        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

       /* //检查评分标准名称是否被占用
        try {
            Map<String, Object> testGradingStandardNameMap = testGradingStandardName(gradingStandardName, gradingStandardId);
            if (200 != (Integer) testGradingStandardNameMap.get("code")) {
                return testGradingStandardNameMap;
            }
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }*/

        //执行更新操作
        try {
            gradingStandardService.updateByPrimaryKeySelective(gradingStandard);
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
     * 删除评分标准
     *
     * @param gradingStandardIdList 要删除的评分标准ID列表
     * @return code为200时为删除成功，其它情况为插入失败
     */
    @DeleteMapping("")
    public Map<String, Object> delete(@RequestBody(required = false) List<Integer> gradingStandardIdList) {

        Map<String, Object> map = new HashMap<>();
        GradingStandardExample example = new GradingStandardExample();
        example.createCriteria().andGradingStandardIdIn(gradingStandardIdList);
        //检查传入信息
        if (gradingStandardIdList == null || gradingStandardIdList.size() <= 0) {
            map.put("code", 500);
            map.put("msg", "信息不能为空");
            return map;
        }

        //执行删除操作
        try {

            gradingStandardService.deleteByExample(example);
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
