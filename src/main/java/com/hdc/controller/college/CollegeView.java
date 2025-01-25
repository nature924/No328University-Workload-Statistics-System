package com.hdc.controller.college;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/college")
public class CollegeView {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String indexView() {
        return "college/index";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainView() {
        return "college/main";
    }

    @RequestMapping(value = "/userInfoPage", method = RequestMethod.GET)
    public String userInfoPageView() {
        return "/college/userInfoPage";
    }

    @RequestMapping(value = "/changePwd", method = RequestMethod.GET)
    public String changePwdView() {
        return "changePwd";
    }

    @RequestMapping(value = "/auditList", method = RequestMethod.GET)
    public String auditListView() {
        return "college/auditList";
    }

    @RequestMapping(value = "/auditAdd", method = RequestMethod.GET)
    public String auditAddView() {
        return "college/auditAdd";
    }

    @RequestMapping(value = "/auditEdit", method = RequestMethod.GET)
    public String auditEditView() {
        return "college/auditEdit";
    }

    @RequestMapping(value = "/teacherList", method = RequestMethod.GET)
    public String teacherListView() {
        return "college/teacherList";
    }

    @RequestMapping(value = "/teacherAdd", method = RequestMethod.GET)
    public String teacherAddView() {
        return "college/teacherAdd";
    }

    @RequestMapping(value = "/teacherEdit", method = RequestMethod.GET)
    public String teacherEditView() {
        return "college/teacherEdit";
    }

    @RequestMapping(value = "/evaluationIndexList", method = RequestMethod.GET)
    public String evaluationIndexListView() {
        return "college/evaluationIndexList";
    }

    @RequestMapping(value = "/evaluationIndexAdd", method = RequestMethod.GET)
    public String evaluationIndexAddView() {
        return "college/evaluationIndexAdd";
    }

    @RequestMapping(value = "/evaluationIndexEdit", method = RequestMethod.GET)
    public String evaluationIndexEditView() {
        return "college/evaluationIndexEdit";
    }

    @RequestMapping(value = "/observationPointList", method = RequestMethod.GET)
    public String observationPointListView() {
        return "college/observationPointList";
    }

    @RequestMapping(value = "/observationPointAdd", method = RequestMethod.GET)
    public String observationPointAddView() {
        return "college/observationPointAdd";
    }
    @RequestMapping(value = "/observationPointEdit", method = RequestMethod.GET)
    public String observationPointEditView() {
        return "college/observationPointEdit";
    }

    @RequestMapping(value = "/gradingStandardList", method = RequestMethod.GET)
    public String gradingStandardListView() {
        return "college/gradingStandardList";
    }

    @RequestMapping(value = "/gradingStandardAdd", method = RequestMethod.GET)
    public String gradingStandardAddView() {
        return "college/gradingStandardAdd";
    }

    @RequestMapping(value = "/gradingStandardEdit", method = RequestMethod.GET)
    public String gradingStandardEditView() {
        return "college/gradingStandardEdit";
    }


}
