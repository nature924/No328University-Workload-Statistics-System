package com.hdc.dto;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author
 */
public class TeacherDto implements Serializable {

    /**
     * 教师ID
     */
    private Integer teacherId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户教师职称Id
     */
    private Integer teacherTitleId;

    /**
     * 用户教师职称Id
     */
    private Integer teacherTitleName;

    /**
     * 学院ID
     */
    private Integer collegeId;

    /**
     * 教师名称
     */
    @NotBlank(message = "教师名称不能为空！")
    private String teacherName;

    /**
     * 教师账号
     */
    @Pattern(regexp = "^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$", message = "用户名格式不正确")
    private String username;

    /**
     * 账号密码
     */
    @Pattern(regexp = "^[\\S]{6,18}$", message = "密码格式不正确")
    private String password;

    @Pattern(regexp = "^[\\d]{1,10}$", message = "工号格式不正确，应为1到10为数字")
    private String employeeId;




    private static final long serialVersionUID = 1L;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTeacherTitleId() {
        return teacherTitleId;
    }

    public void setTeacherTitleId(Integer teacherTitleId) {
        this.teacherTitleId = teacherTitleId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getTeacherTitleName() {
        return teacherTitleName;
    }

    public void setTeacherTitleName(Integer teacherTitleName) {
        this.teacherTitleName = teacherTitleName;
    }
}