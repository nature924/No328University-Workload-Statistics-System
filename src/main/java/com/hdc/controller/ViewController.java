package com.hdc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class ViewController {


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String LoginView() throws Exception {
		return "selectLogin";
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginPageView() {
		return "login";
	}

	@RequestMapping(value = "/selectLogin", method = RequestMethod.GET)
	public String selectLoginView() {
		return "selectLogin";
	}


}
