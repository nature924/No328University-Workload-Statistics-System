package com.hdc.controller.college;


import com.google.common.base.CaseFormat;
import com.hdc.dto.ObservationPointDto;
import com.hdc.entity.*;
import com.hdc.security.MyUser;
import com.hdc.service.CollegeService;
import com.hdc.service.EvaluationIndexService;
import com.hdc.service.ObservationPointService;
import com.hdc.service.SystemConfigService;
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
@RequestMapping("/college/observationPoint")
public class ObservationPointController {

    @Autowired
    private ObservationPointService observationPointService;

    @Autowired
    private EvaluationIndexService evaluationIndexService;

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private SystemConfigService systemConfigService;

    /**
     * 获取取主要观测点信息
     *
     * @param page        查询条件
     * @param content 主要观测点名称
     * @return 返回的JSON数据
     */
    @GetMapping("")
    public Map<String, Object> selectAll(Page page, String content, Integer evaluationIndexId) {


        long count = 0;
        List<ObservationPoint> list;
        ObservationPointExample example = new ObservationPointExample();
        ObservationPointExample.Criteria criteria = example.createCriteria();
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
            collegeId =collegeService.selectByExample(collegeExample).get(0).getCollegeId();
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
        if (evaluationIndexId!= null &&evaluationIndexId>0) {
            criteria.andEvaluationIndexIdEqualTo(evaluationIndexId);
        }

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
            count = observationPointService.countByExample(example);
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
     * 检查主要观测点名称是否存在
     *
     * @param observationPointContent 主要观测点内容
     * @param observationPointId 如果存在，则在检查的时候排除本身
     * @return code为200时为不存在，其余为存在重复
     */
    @GetMapping("/testObservationPointContent")
    public Map<String, Object> testObservationPointName(String observationPointContent, Integer observationPointId) {


        long count = 0;
        ObservationPointExample example = new ObservationPointExample();
        ObservationPointExample.Criteria criteria = example.createCriteria();
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
        if (StringUtils.isNotBlank(observationPointContent)) {
            criteria.andContentEqualTo(observationPointContent);
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
        if (observationPointId != null && observationPointId > 0) {
            criteria.andObservationPointIdNotEqualTo(observationPointId);
        }

        //返回查询条数
        try {
            count = observationPointService.countByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }

        if (count > 0) {
            map.put("code", 300);
            map.put("msg", "主要观测点名已经存在，请检查后重试");
            return map;
        }

        //封装JSON
        map.put("code", 200);
        map.put("msg", "请求成功");
        return map;
    }

    /**
     * 插入一个主要观测点账号
     *
     * @param observationPointDto 主要观测点信息
     * @param errors  检查之后返回的错误数据
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PostMapping("")
    public Map<String, Object> insert(@Valid @RequestBody(required = false) ObservationPointDto observationPointDto, BindingResult errors) {


        ObservationPoint observationPoint = new ObservationPoint();
        Map<String, Object> map = new HashMap<>();
        String observationPointContent;
        SystemBaseConfig systemConfig;

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
            systemConfig = systemConfigService.getSystemBaseConfig();
            observationPointContent = observationPointDto.getContent();

            observationPoint.setContent(observationPointContent);
            observationPoint.setCollegeId(collegeId);
            observationPoint.setEvaluationIndexId(observationPointDto.getEvaluationIndexId());
            observationPoint.setYear(systemConfig.getSystemYear());
            observationPoint.setSemester(systemConfig.getSystemSemester());

        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        /*//检查用户名和主要观测点名称是否被占用
        try {
            Map<String, Object> testObservationPointNameMap = testObservationPointName(observationPointContent, null);
            if (200 != (Integer) testObservationPointNameMap.get("code")) {
                return testObservationPointNameMap;
            }
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }*/

        //执行插入操作
        try {
            observationPointService.insert(observationPoint);
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
     * 批量插入观测点
     *
     * @param observationPointDtoList 观测点列表
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PostMapping("/excel")
    public Map<String, Object> excelInsert(@RequestBody(required = false) List<ObservationPointDto> observationPointDtoList) {

        Map<String, Object> map = new HashMap<>();
        List<ObservationPoint> observationPointList = new ArrayList<>();
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
        Map<String,Integer> evaluationIndexMap = new HashMap<>();
        EvaluationIndexExample evaluationIndexExample = new EvaluationIndexExample();
        EvaluationIndexExample.Criteria criteria = evaluationIndexExample.createCriteria();
        criteria.andYearEqualTo(systemConfig.getSystemYear());
        criteria.andSemesterEqualTo(systemConfig.getSystemSemester());
        criteria.andCollegeIdEqualTo(collegeId);

        List<EvaluationIndex> evaluationIndexList = evaluationIndexService.selectByExample(evaluationIndexExample);

        for (EvaluationIndex evaluationIndex: evaluationIndexList
             ) {
            evaluationIndexMap.put(evaluationIndex.getContent(), evaluationIndex.getEvaluationIndexId());
        }


//      设置导入项的学院、年份、学期,并转换为observationPoint列表
        String evaluationIndexName, observationPointContent;
        Integer evaluationIndexId, semester , year;
        int observationPointDtoListCount=0;
        for (ObservationPointDto observationPointDto : observationPointDtoList
        ) {

            observationPointDtoListCount++;
            ObservationPoint observationPoint = new ObservationPoint();

            evaluationIndexName = observationPointDto.getEvaluationIndexName();
            evaluationIndexId = evaluationIndexMap.get(evaluationIndexName);
            observationPointContent = observationPointDto.getContent();
            semester = systemConfig.getSystemSemester();
            year = systemConfig.getSystemYear();

            if (!StringUtils.isNotBlank(evaluationIndexName)) {
                map.put("code", 500);
                map.put("msg", "第" + observationPointDtoListCount + "行评估指标数据为空，请检查后重试！");
                return map;
            }

            if (evaluationIndexId == null || evaluationIndexId<=0) {
                map.put("code", 500);
                map.put("msg", "第" + observationPointDtoListCount + "行评估指标不存在，请检查后重试！");
                return map;
            }

            if (!StringUtils.isNotBlank(observationPointContent)) {
                map.put("code", 500);
                map.put("msg", "第" + observationPointDtoListCount + "行观测点数据为空，请检查后重试！");
                return map;
            }

            if (semester == null || semester<=0) {
                map.put("code", 500);
                map.put("msg", "第" + observationPointDtoListCount + "学期信息错误，请联系总管理员！");
                return map;
            }

            if (year == null || year<=0) {
                map.put("code", 500);
                map.put("msg", "第" + observationPointDtoListCount + "学年信息错误，请联系总管理员！");
                return map;
            }

            observationPoint.setEvaluationIndexId(evaluationIndexId);
            observationPoint.setCollegeId(collegeId);
            observationPoint.setSemester(semester);
            observationPoint.setYear(year);
            observationPoint.setContent(observationPointContent);

            observationPointList.add(observationPoint);
        }

        try {
            observationPointService.batchInsertObservationPoint(observationPointList);
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
     * 更新主要观测点信息
     *
     * @param observationPointDto 主要观测点信息
     * @param errors  检查之后返回的错误数据
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PutMapping("")
    public Map<String, Object> update(@Valid @RequestBody(required = false) ObservationPointDto observationPointDto, BindingResult errors) {
        String observationPointContent;
        SystemBaseConfig systemConfig;

        ObservationPoint observationPoint = new ObservationPoint();
        Map<String, Object> map = new HashMap<>();
        Integer observationPointId;
        String observationPointName,desc;

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
            systemConfig = systemConfigService.getSystemBaseConfig();
            observationPointContent = observationPointDto.getContent();

            observationPoint.setObservationPointId(observationPointDto.getObservationPointId());
            observationPoint.setContent(observationPointContent);
            observationPoint.setCollegeId(collegeId);
            observationPoint.setEvaluationIndexId(observationPointDto.getEvaluationIndexId());
            observationPoint.setYear(systemConfig.getSystemYear());
            observationPoint.setSemester(systemConfig.getSystemSemester());

        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

       /* //检查主要观测点名称是否被占用
        try {
            Map<String, Object> testObservationPointNameMap = testObservationPointName(observationPointName, observationPointId);
            if (200 != (Integer) testObservationPointNameMap.get("code")) {
                return testObservationPointNameMap;
            }
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }*/

        //执行更新操作
        try {
            observationPointService.updateByPrimaryKeySelective(observationPoint);
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
     * 删除主要观测点
     *
     * @param observationPointIdList 要删除的主要观测点ID列表
     * @return code为200时为删除成功，其它情况为插入失败
     */
    @DeleteMapping("")
    public Map<String, Object> delete(@RequestBody(required = false) List<Integer> observationPointIdList) {

        Map<String, Object> map = new HashMap<>();
        ObservationPointExample example = new ObservationPointExample();
        example.createCriteria().andObservationPointIdIn(observationPointIdList);
        //检查传入信息
        if (observationPointIdList == null || observationPointIdList.size() <= 0) {
            map.put("code", 500);
            map.put("msg", "信息不能为空");
            return map;
        }

        //执行删除操作
        try {

            observationPointService.deleteByExample(example);
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
