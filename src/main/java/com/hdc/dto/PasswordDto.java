package com.hdc.dto;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author
 */
public class PasswordDto implements Serializable {


    /**
     * 原密码
     */
    @NotBlank(message = "原密码不能为空")
    private String oldPassword;

    /**
     * 新密码
     */
    @Pattern(regexp = "^[\\S]{6,12}$", message = "密码格式不正确")
    private String newPassword;

    @Pattern(regexp = "^[\\S]{6,12}$", message = "密码格式不正确")
    private String confirmPassword;

    private static final long serialVersionUID = 1L;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}