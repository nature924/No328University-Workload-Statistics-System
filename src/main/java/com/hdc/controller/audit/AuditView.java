package com.hdc.controller.audit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/audit")
public class AuditView {

	@RequestMapping(value = "/certifyingDeclaration", method = RequestMethod.GET)
	public String certifyingDeclarationView() {
		return "audit/certifyingDeclaration";
	}

	@RequestMapping(value = "/certifyingDeclarationEdit", method = RequestMethod.GET)
	public String certifyingDeclarationEditView() {
		return "audit/certifyingDeclarationEdit";
	}

	@RequestMapping(value = "/certifiedDeclaration", method = RequestMethod.GET)
	public String certifiedDeclarationView() {
		return "audit/certifiedDeclaration";
	}

	@RequestMapping(value = "/certifiedDeclarationLook", method = RequestMethod.GET)
	public String certifiedDeclarationLookView() {
		return "audit/certifiedDeclarationLook";
	}

	@RequestMapping(value = "/certifiedDeclarationEdit", method = RequestMethod.GET)
	public String certifiedDeclarationEditView() {
		return "audit/certifiedDeclarationEdit";
	}

	@RequestMapping(value = "/returnDeclaration", method = RequestMethod.GET)
	public String returnDeclarationView() {
		return "audit/returnDeclaration";
	}

	@RequestMapping(value = "/returnDeclarationLook", method = RequestMethod.GET)
	public String returnDeclarationLookView() {
		return "audit/returnDeclarationLook";
	}

	@RequestMapping(value = "/returnDeclarationEdit", method = RequestMethod.GET)
	public String returnDeclarationEditView() {
		return "audit/returnDeclarationEdit";
	}

	
	@RequestMapping(value = "/certifiedScore", method = RequestMethod.GET)
	public String certifiedScoreView() {
		return "audit/certifiedScore";
	}
	
	@RequestMapping(value = "/certifyingScore", method = RequestMethod.GET)
	public String certifyingScoreView() {
		return "audit/certifyingScore";
	}
	
	@RequestMapping(value = "/changePwd", method = RequestMethod.GET)
	public String changePwdView() {
		return "changePwd";
	}
	
	@RequestMapping(value = "/declarationTablePage", method = RequestMethod.GET)
	public String declarationTablePageView() {
		return "audit/declarationTablePage";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainView() {
		return "audit/main";
	}
	
	@RequestMapping(value = "/newsAdd", method = RequestMethod.GET)
	public String newsAddView() {
		return "audit/newsAdd";
	}
	
	
	
	@RequestMapping(value = "/scoreReport", method = RequestMethod.GET)
	public String scoreReportView() {
		return "audit/scoreReport";
	}
	
	@RequestMapping(value = "/userInfoPage", method = RequestMethod.GET)
	public String userInfoPageView() {
		return "audit/userInfoPage";
	}
	
	@RequestMapping(value = "/scoreDeclaration", method = RequestMethod.GET)
	public String scoreDeclarationView() {
		return "audit/scoreDeclaration";
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String indexView() {
		return "audit/index";
	}
	
}
