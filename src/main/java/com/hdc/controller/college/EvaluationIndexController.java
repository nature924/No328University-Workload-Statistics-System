package com.hdc.controller.college;


import com.google.common.base.CaseFormat;
import com.hdc.dto.EvaluationIndexDto;
import com.hdc.entity.*;
import com.hdc.security.MyUser;
import com.hdc.service.CollegeService;
import com.hdc.service.EvaluationIndexService;
import com.hdc.service.SystemConfigService;
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
@RequestMapping("/college/evaluationIndex")
public class EvaluationIndexController {

    @Autowired
    private EvaluationIndexService evaluationIndexService;

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private SystemConfigService systemConfigService;

    /**
     * 获取取评估指标信息
     *
     * @param page        查询条件
     * @param content 评估指标名称
     * @return 返回的JSON数据
     */
    @GetMapping("")
    public Map<String, Object> selectAll(Page page, String content) {



        long count = 0;
        List<EvaluationIndex> list;
        EvaluationIndexExample example = new EvaluationIndexExample();
        EvaluationIndexExample.Criteria criteria = example.createCriteria();
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
     * 检查评估指标名称是否存在
     *
     * @param evaluationIndexContent 评估指标内容
     * @param evaluationIndexId 如果存在，则在检查的时候排除本身
     * @return code为200时为不存在，其余为存在重复
     */
    @GetMapping("/testEvaluationIndexContent")
    public Map<String, Object> testEvaluationIndexName(String evaluationIndexContent, Integer evaluationIndexId) {

        long count = 0;
        EvaluationIndexExample example = new EvaluationIndexExample();
        EvaluationIndexExample.Criteria criteria = example.createCriteria();
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
        if (StringUtils.isNotBlank(evaluationIndexContent)) {
            criteria.andContentEqualTo(evaluationIndexContent);
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
        if (evaluationIndexId != null && evaluationIndexId > 0) {
            criteria.andEvaluationIndexIdNotEqualTo(evaluationIndexId);
        }

        //返回查询条数
        try {
            count = evaluationIndexService.countByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }

        if (count > 0) {
            map.put("code", 300);
            map.put("msg", "评估指标名已经存在，请检查后重试");
            return map;
        }

        //封装JSON
        map.put("code", 200);
        map.put("msg", "请求成功");
        return map;
    }

    /**
     * 插入一个评估指标账号
     *
     * @param evaluationIndexDto 评估指标信息
     * @param errors  检查之后返回的错误数据
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PostMapping("")
    public Map<String, Object> insert(@Valid @RequestBody(required = false) EvaluationIndexDto evaluationIndexDto, BindingResult errors) {


        EvaluationIndex evaluationIndex = new EvaluationIndex();
        Map<String, Object> map = new HashMap<>();
        String evaluationIndexContent;
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
            evaluationIndexContent = evaluationIndexDto.getContent();

            evaluationIndex.setContent(evaluationIndexContent);
            evaluationIndex.setCollegeId(collegeId);
            evaluationIndex.setYear(systemConfig.getSystemYear());
            evaluationIndex.setSemester(systemConfig.getSystemSemester());

        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        /*//检查用户名和评估指标名称是否被占用
        try {
            Map<String, Object> testEvaluationIndexNameMap = testEvaluationIndexName(evaluationIndexContent, null);
            if (200 != (Integer) testEvaluationIndexNameMap.get("code")) {
                return testEvaluationIndexNameMap;
            }
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }*/

        //执行插入操作
        try {
            evaluationIndexService.insert(evaluationIndex);
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
     * 批量插入评估指标
     *
     * @param evaluationIndexList 评估指标列表
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PostMapping("/excel")
    public Map<String, Object> excelInsert(@RequestBody(required = false) List<EvaluationIndex> evaluationIndexList) {

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

        //赋值
        try {
            systemConfig = systemConfigService.getSystemBaseConfig();
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }


//      设置导入项的学院年份学期
        for (EvaluationIndex evaluationIndex : evaluationIndexList
        ) {
            evaluationIndex.setCollegeId(collegeId);
            evaluationIndex.setYear(systemConfig.getSystemYear());
            evaluationIndex.setSemester(systemConfig.getSystemSemester());
        }

        try {
            evaluationIndexService.batchInsertEvaluationIndex(evaluationIndexList);
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
     * 更新评估指标信息
     *
     * @param evaluationIndexDto 评估指标信息
     * @param errors  检查之后返回的错误数据
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PutMapping("")
    public Map<String, Object> update(@Valid @RequestBody(required = false) EvaluationIndexDto evaluationIndexDto, BindingResult errors) {

        String evaluationIndexContent;
        SystemBaseConfig systemConfig;

        EvaluationIndex evaluationIndex = new EvaluationIndex();
        Map<String, Object> map = new HashMap<>();
        Integer evaluationIndexId;
        String evaluationIndexName,desc;

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
            evaluationIndexContent = evaluationIndexDto.getContent();

            evaluationIndex.setEvaluationIndexId(evaluationIndexDto.getEvaluationIndexId());
            evaluationIndex.setContent(evaluationIndexContent);
            evaluationIndex.setCollegeId(collegeId);
            evaluationIndex.setYear(systemConfig.getSystemYear());
            evaluationIndex.setSemester(systemConfig.getSystemSemester());

        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

       /* //检查评估指标名称是否被占用
        try {
            Map<String, Object> testEvaluationIndexNameMap = testEvaluationIndexName(evaluationIndexName, evaluationIndexId);
            if (200 != (Integer) testEvaluationIndexNameMap.get("code")) {
                return testEvaluationIndexNameMap;
            }
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }*/

        //执行更新操作
        try {
            evaluationIndexService.updateByPrimaryKeySelective(evaluationIndex);
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
     * 删除评估指标
     *
     * @param evaluationIndexIdList 要删除的评估指标ID列表
     * @return code为200时为删除成功，其它情况为插入失败
     */
    @DeleteMapping("")
    public Map<String, Object> delete(@RequestBody(required = false) List<Integer> evaluationIndexIdList) {

        Map<String, Object> map = new HashMap<>();
        EvaluationIndexExample example = new EvaluationIndexExample();
        example.createCriteria().andEvaluationIndexIdIn(evaluationIndexIdList);
        //检查传入信息
        if (evaluationIndexIdList == null || evaluationIndexIdList.size() <= 0) {
            map.put("code", 500);
            map.put("msg", "信息不能为空");
            return map;
        }

        //执行删除操作
        try {

            evaluationIndexService.deleteByExample(example);
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
