package com.hdc.controller.info;

import com.hdc.entity.SystemBaseConfig;
import com.hdc.entity.SystemConfig;
import com.hdc.entity.TeacherTitle;
import com.hdc.entity.TeacherTitleExample;
import com.hdc.service.AuthoritiesService;
import com.hdc.service.SystemConfigService;
import com.hdc.service.TeacherTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/info")
public class InfoController {
	
	@Autowired
	private TeacherTitleService teacherTitleService;

	@Autowired
	private SystemConfigService systemConfigService;
	
	@GetMapping("/teacherTitle")
	public Map<String, Object> getTeacherTitleList() {

		List<TeacherTitle> list;
		TeacherTitleExample example = new TeacherTitleExample();
		Map<String, Object> map = new HashMap<>();

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
		map.put("data", list);
		return map;
	}

	/**
	 * 获取系统设置信息
	 *
	 * @return 返回的JSON数据
	 */
	@GetMapping("/systemConfig")
	public Map<String, Object> select() {

		SystemBaseConfig systemConfig;
		Map<String, Object> map = new HashMap<>();


		//返回查询条数
		try {
			systemConfig = systemConfigService.getSystemBaseConfig();
		} catch (Exception e) {
			map.put("code", 500);
			map.put("msg", "服务器繁忙");
			return map;
		}

		//封装JSON
		map.put("code", 200);
		map.put("msg", "请求成功");
		map.put("data", systemConfig);
		return map;
	}

	/**
	 * 获取服务器时间
	 *
	 * @return 返回的JSON数据
	 */
	@GetMapping("/serverTime")
	public Map<String, Object> getServerTime() {

		SystemBaseConfig systemConfig;
		Map<String, Object> map = new HashMap<>();



		//封装JSON
		map.put("code", 200);
		map.put("msg", "请求成功");
		map.put("data", new Date());
		return map;
	}
}
