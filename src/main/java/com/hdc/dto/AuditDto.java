package com.hdc.dto;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author
 */
public class AuditDto implements Serializable {

    /**
     * 学院ID
     */
    private Integer auditId;
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户ID
     */
    private Integer collegeId;

    /**
     * 学院名称
     */
    @NotBlank(message = "审核机构名称不能为空！")
    private String auditName;

    /**
     * 学院账号
     */
    @Pattern(regexp = "^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$", message = "用户名格式不正确")
    private String username;

    /**
     * 账号密码
     */
    @Pattern(regexp = "^[\\S]{6,18}$", message = "密码格式不正确")
    private String password;

    /**
     * 账号密码
     */
    private String desc;


    private static final long serialVersionUID = 1L;

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
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

    public String getAuditName() {
        return auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}