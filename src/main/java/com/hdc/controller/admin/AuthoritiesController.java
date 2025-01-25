package com.hdc.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdc.service.AuthoritiesService;

@RestController
@RequestMapping("/admin")
public class AuthoritiesController {
	
	@Autowired
	private AuthoritiesService AuthoritiesService;
	
	@GetMapping("/authorities")
	public Map<String, Object> getAuthoritiesList() {
		Map<String, Object> map = new HashMap<>();
	
		
		map.put("success", true);
		map.put("data", AuthoritiesService.getAuthoritiesList());
		return map;
	}	
}
