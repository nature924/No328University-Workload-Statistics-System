package com.hdc.dto;


import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author
 */
public class CollegeDto implements Serializable {

    /**
     * 学院ID
     */
    private Integer collegeId;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 学院名称
     */
    @NotBlank(message = "学院名称不能为空！")
    private String collegeName;

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


    private static final long serialVersionUID = 1L;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
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

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}