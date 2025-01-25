package com.hdc.controller.admin;


import com.google.common.base.CaseFormat;
import com.hdc.entity.Page;
import com.hdc.entity.TeacherTitle;
import com.hdc.entity.TeacherTitleExample;
import com.hdc.service.TeacherTitleService;
import com.hdc.dto.TeacherTitleDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/teacherTitle")
public class TeacherTitleController {

    @Autowired
    private TeacherTitleService teacherTitleService;

    /**
     * 获取取教师职称信息
     *
     * @param page        查询条件
     * @param teacherTitleName 教师职称名称
     * @return 返回的JSON数据
     */
    @GetMapping("")
    public Map<String, Object> selectAll(Page page, String teacherTitleName) {

        long count = 0;
        List<TeacherTitle> list;
        TeacherTitleExample example = new TeacherTitleExample();
        Map<String, Object> map = new HashMap<>();

        //添加查询条件
        if (StringUtils.isNotBlank(teacherTitleName)) {
            example.createCriteria().andNameLike("%" + teacherTitleName + "%");
        }

        //返回查询条数
        try {
            count = teacherTitleService.countByExample(example);
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
            list = teacherTitleService.selectByExample(example);
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
     * 检查教师职称名称是否存在
     *
     * @param teacherTitleName 教师职称名称
     * @param teacherTitleId 如果存在，则在检查的时候排除本身
     * @return code为200时为不存在，其余为存在重复
     */
    @GetMapping("/testTeacherTitleName")
    public Map<String, Object> testTeacherTitleName(String teacherTitleName, Integer teacherTitleId) {

        long count = 0;
        TeacherTitleExample example = new TeacherTitleExample();
        TeacherTitleExample.Criteria criteria = example.createCriteria();
        Map<String, Object> map = new HashMap<>();

        //添加查询条件
        if (StringUtils.isNotBlank(teacherTitleName)) {
            criteria.andNameEqualTo(teacherTitleName);
        } else {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //更新检查重复时除去数据本身
        if (teacherTitleId != null && teacherTitleId > 0) {
            criteria.andTeacherTitleIdNotEqualTo(teacherTitleId);
        }

        //返回查询条数
        try {
            count = teacherTitleService.countByExample(example);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }

        if (count > 0) {
            map.put("code", 300);
            map.put("msg", "教师职称名已经存在，请检查后重试");
            return map;
        }

        //封装JSON
        map.put("code", 200);
        map.put("msg", "请求成功");
        return map;
    }

    /**
     * 插入一个教师职称账号
     *
     * @param teacherTitleDto 教师职称信息
     * @param errors  检查之后返回的错误数据
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PostMapping("")
    public Map<String, Object> insert(@Valid @RequestBody(required = false) TeacherTitleDto teacherTitleDto, BindingResult errors) {

        TeacherTitle teacherTitle = new TeacherTitle();
        Map<String, Object> map = new HashMap<>();
        String teacherTitleName, desc;

        //检查错误，封装错误信息
        if (errors.getErrorCount() > 0) {
            map.put("code", 500);
            map.put("msg", errors.getAllErrors().get(0).getDefaultMessage());
            return map;
        }

        //赋值
        try {
            teacherTitleName = teacherTitleDto.getName();
            desc= teacherTitleDto.getDesc();
            teacherTitle.setName(teacherTitleName);
            teacherTitle.setDesc(desc);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //检查用户名和教师职称名称是否被占用
        try {
            Map<String, Object> testTeacherTitleNameMap = testTeacherTitleName(teacherTitleName, null);
            if (200 != (Integer) testTeacherTitleNameMap.get("code")) {
                return testTeacherTitleNameMap;
            }
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }

        //执行插入操作
        try {
            teacherTitleService.insert(teacherTitle);
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
     * 更新教师职称信息
     *
     * @param teacherTitleDto 教师职称信息
     * @param errors  检查之后返回的错误数据
     * @return code为200时为插入成功，其它情况为插入失败
     */
    @PutMapping("")
    public Map<String, Object> update(@Valid @RequestBody(required = false) TeacherTitleDto teacherTitleDto, BindingResult errors) {

        TeacherTitle teacherTitle = new TeacherTitle();
        Map<String, Object> map = new HashMap<>();
        Integer teacherTitleId;
        String teacherTitleName,desc;

        //检查错误，封装错误信息
        if (errors.getErrorCount() > 0) {
            map.put("code", 500);
            map.put("msg", errors.getAllErrors().get(0).getDefaultMessage());
            return map;
        }

        //赋值
        try {
            teacherTitleId = teacherTitleDto.getTeacherTitleId();
            teacherTitleName = teacherTitleDto.getName();
            desc= teacherTitleDto.getDesc();

            teacherTitle.setTeacherTitleId(teacherTitleDto.getTeacherTitleId());
            teacherTitle.setName(teacherTitleName);
            teacherTitle.setDesc(desc);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "数据格式错误");
            return map;
        }

        //检查教师职称名称是否被占用
        try {
            Map<String, Object> testTeacherTitleNameMap = testTeacherTitleName(teacherTitleName, teacherTitleId);
            if (200 != (Integer) testTeacherTitleNameMap.get("code")) {
                return testTeacherTitleNameMap;
            }
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }

        //执行更新操作
        try {
            teacherTitleService.updateByPrimaryKey(teacherTitle);
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
     * 删除教师职称
     *
     * @param teacherTitleIdList 要删除的教师职称ID列表
     * @return code为200时为删除成功，其它情况为插入失败
     */
    @DeleteMapping("")
    public Map<String, Object> delete(@RequestBody(required = false) List<Integer> teacherTitleIdList) {

        Map<String, Object> map = new HashMap<>();
        TeacherTitleExample example = new TeacherTitleExample();
        example.createCriteria().andTeacherTitleIdIn(teacherTitleIdList);
        //检查传入信息
        if (teacherTitleIdList == null || teacherTitleIdList.size() <= 0) {
            map.put("code", 500);
            map.put("msg", "信息不能为空");
            return map;
        }

        //执行删除操作
        try {

            teacherTitleService.deleteByExample(example);
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
