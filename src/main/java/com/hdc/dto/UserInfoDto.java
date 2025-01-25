package com.hdc.dto;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author 
 */
public class UserInfoDto implements Serializable {
    /**
     * 用户信息ID
     */
    private Integer userInfoId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 展示名称
     */
    @NotBlank(message = "昵称不能为空")
    private String displayName;

    /**
     * 头像URL
     */
    private String imgUrl;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    private static final long serialVersionUID = 1L;


    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}