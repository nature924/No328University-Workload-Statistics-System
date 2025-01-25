package com.hdc.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminView {

    @RequestMapping(value = "/certifiedScore", method = RequestMethod.GET)
    public String certifiedScoreView() {
        return "admin/certifiedScore";
    }

    @RequestMapping(value = "/certifyingScore", method = RequestMethod.GET)
    public String certifyingScoreView() {
        return "admin/certifyingScore";
    }

    @RequestMapping(value = "/changePwd", method = RequestMethod.GET)
    public String changePwdView() {
        return "changePwd";
    }

    @RequestMapping(value = "/gradingStandard", method = RequestMethod.GET)
    public String gradingStandardView() {
        return "admin/gradingStandard";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainView() {
        return "admin/main";
    }

    @RequestMapping(value = "/newsAdd", method = RequestMethod.GET)
    public String newsAddView() {
        return "admin/newsAdd";
    }


    @RequestMapping(value = "/scoreReport", method = RequestMethod.GET)
    public String scoreReportView() {
        return "admin/scoreReport";
    }

    @RequestMapping(value = "/userInfoPage", method = RequestMethod.GET)
    public String userInfoView() {
        return "admin/userInfoPage";
    }

    @RequestMapping(value = "/scoreDeclaration", method = RequestMethod.GET)
    public String scoreDeclarationView() {
        return "admin/scoreDeclaration";
    }

    @RequestMapping(value = "/collegeList", method = RequestMethod.GET)
    public String collegePageView() {
        return "admin/collegeList";
    }

    @RequestMapping(value = "/collegeEdit", method = RequestMethod.GET)
    public String collegeEditView() {
        return "admin/collegeEdit";
    }

    @RequestMapping(value = "/collegeAdd", method = RequestMethod.GET)
    public String collegeAddView() {
        return "admin/collegeAdd";
    }

    @RequestMapping(value = "/teacherTitleList", method = RequestMethod.GET)
    public String teacherTitlePageView() {
        return "admin/teacherTitleList";
    }

    @RequestMapping(value = "/teacherTitleEdit", method = RequestMethod.GET)
    public String teacherTitleEditView() {
        return "admin/teacherTitleEdit";
    }

    @RequestMapping(value = "/teacherTitleAdd", method = RequestMethod.GET)
    public String teacherTitleAddView() {
        return "admin/teacherTitleAdd";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String indexView() {
        return "admin/index";
    }

    @RequestMapping(value = "/systemConfigPage", method = RequestMethod.GET)
    public String systemConfigPageView() {
        return "admin/systemConfigPage";
    }
}
