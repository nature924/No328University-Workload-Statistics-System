package com.hdc.dto;

import com.hdc.entity.TeacherTitle;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author 
 */
public class TeacherTitleDto implements Serializable {
    /**
     * 教师职称ID
     */
    private Integer teacherTitleId;

    /**
     * 教师职称名称
     */
    @NotBlank(message = "教师职称不能为空")
    private String name;

    /**
     * 教师职称描述
     */
    private String desc;

    private static final long serialVersionUID = 1L;

    public Integer getTeacherTitleId() {
        return teacherTitleId;
    }

    public void setTeacherTitleId(Integer teacherTitleId) {
        this.teacherTitleId = teacherTitleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}