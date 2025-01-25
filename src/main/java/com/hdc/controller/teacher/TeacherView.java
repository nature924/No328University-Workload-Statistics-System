package com.hdc.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/teacher")
public class TeacherView {

	@RequestMapping(value = "/certifyingDeclaration", method = RequestMethod.GET)
	public String certifyingDeclarationView() {
		return "teacher/certifyingDeclaration";
	}

	@RequestMapping(value = "/certifyingDeclarationEdit", method = RequestMethod.GET)
	public String certifyingDeclarationEditView() {
		return "teacher/certifyingDeclarationEdit";
	}

	@RequestMapping(value = "/certifiedDeclaration", method = RequestMethod.GET)
	public String certifiedDeclarationView() {
		return "teacher/certifiedDeclaration";
	}

	@RequestMapping(value = "/certifiedDeclarationLook", method = RequestMethod.GET)
	public String certifiedDeclarationLookView() {
		return "teacher/certifiedDeclarationLook";
	}

	@RequestMapping(value = "/returnDeclaration", method = RequestMethod.GET)
	public String returnDeclarationView() {
		return "teacher/returnDeclaration";
	}

	@RequestMapping(value = "/returnDeclarationEdit", method = RequestMethod.GET)
	public String returnDeclarationEditView() {
		return "teacher/returnDeclarationEdit";
	}
	
	@RequestMapping(value = "/changePwd", method = RequestMethod.GET)
	public String changePwdView() {
		return "changePwd";
	}
	
	@RequestMapping(value = "/gradingStandard", method = RequestMethod.GET)
	public String gradingStandardView() {
		return "teacher/gradingStandard";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainView() {
		return "teacher/main";
	}
	
	@RequestMapping(value = "/newsAdd", method = RequestMethod.GET)
	public String newsAddView() {
		return "teacher/newsAdd";
	}
	
	
	
	@RequestMapping(value = "/scoreReport", method = RequestMethod.GET)
	public String scoreReportView() {
		return "teacher/scoreReport";
	}
	
	@RequestMapping(value = "/userInfoPage", method = RequestMethod.GET)
	public String userInfoView() {
		return "teacher/userInfoPage";
	}
	
	@RequestMapping(value = "/scoreDeclaration", method = RequestMethod.GET)
	public String scoreDeclarationView() {
		return "teacher/certifyingDeclaration";
	}

	@RequestMapping(value = "/scoreReportLook", method = RequestMethod.GET)
	public String scoreReportLookView() {
		return "teacher/scoreReportLook";
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String indexView() {
		return "teacher/index";
	}

	@RequestMapping(value = "/tableTest", method = RequestMethod.GET)
	public String tableTestView() {
		return "teacher/tableTest";
	}

	@RequestMapping(value = "/tableTest2", method = RequestMethod.GET)
	public String tableTest2View() {
		return "teacher/tableTest2";
	}

	@RequestMapping(value = "/declarationTablePage", method = RequestMethod.GET)
	public String declarationTablePageView() {
		return "teacher/declarationTablePage";
	}

	@RequestMapping(value = "/declarationTableAdd", method = RequestMethod.GET)
	public String declarationTableAddView() {
		return "teacher/declarationTableAdd";
	}

	@RequestMapping(value = "/declarationTableEdit", method = RequestMethod.GET)
	public String declarationTablePageEdit() {
		return "teacher/declarationTableEdit";
	}


	
}
