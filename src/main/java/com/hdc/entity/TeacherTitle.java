package com.hdc.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class TeacherTitle implements Serializable {
    /**
     * 教师职称ID
     */
    private Integer teacherTitleId;

    /**
     * 教师职称名称
     */
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TeacherTitle other = (TeacherTitle) that;
        return (this.getTeacherTitleId() == null ? other.getTeacherTitleId() == null : this.getTeacherTitleId().equals(other.getTeacherTitleId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDesc() == null ? other.getDesc() == null : this.getDesc().equals(other.getDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTeacherTitleId() == null) ? 0 : getTeacherTitleId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDesc() == null) ? 0 : getDesc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", teacherTitleId=").append(teacherTitleId);
        sb.append(", name=").append(name);
        sb.append(", desc=").append(desc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}