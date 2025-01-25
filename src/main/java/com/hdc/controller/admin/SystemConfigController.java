package com.hdc.controller.admin;


import com.hdc.dto.SystemBaseConfigDto;
import com.hdc.entity.*;
import com.hdc.service.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/systemConfig")
public class SystemConfigController {

    @Autowired
    private SystemConfigService systemConfigService;


    /**
     * 获取系统设置信息
     *
     * @return 返回的JSON数据
     */
    @GetMapping("")
    public Map<String, Object> select() {

        SystemBaseConfig systemBaseConfig;
        Map<String, Object> map = new HashMap<>();


        //返回查询条数
        try {
            systemBaseConfig = systemConfigService.getSystemBaseConfig();
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "服务器繁忙");
            return map;
        }

        //封装JSON
        map.put("code", 200);
        map.put("msg", "请求成功");
        map.put("data", systemBaseConfig);
        return map;
    }

    /**
     * 更新系统设置信息
     *
     * @param systemBaseConfigDto 系统设置信息
     * @param errors  检查之后返回的错误数据
     * @return code为200时为插入成功，其它情况为更新失败
     */
    @PutMapping("")
    public Map<String, Object> update(@Valid @RequestBody(required = false) SystemBaseConfigDto systemBaseConfigDto, BindingResult errors) {

        Map<String, Object> map = new HashMap<>();


        //检查错误，封装错误信息
        if (errors.getErrorCount() > 0) {
            map.put("code", 500);
            map.put("msg", errors.getAllErrors().get(0).getDefaultMessage());
            return map;
        }

        //执行更新操作
        try {
            systemConfigService.updateBySystemBaseConfigDto(systemBaseConfigDto);
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "更新失败");
            return map;
        }

        map.put("code", 200);
        map.put("msg", "请求成功");
        return map;
    }

}
