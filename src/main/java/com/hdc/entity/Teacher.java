package com.hdc.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class Teacher implements Serializable {
    /**
     * 教师ID
     */
    private Integer teacherId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 教师名称
     */
    private String teacherName;

    /**
     * 教师工号
     */
    private String employeeId;

    /**
     * 教师职称ID
     */
    private Integer teacherTitleId;

    /**
     * 学院ID
     */
    private Integer collegeId;

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

    public Integer getTeacherTitleId() {
        return teacherTitleId;
    }

    public void setTeacherTitleId(Integer teacherTitleId) {
        this.teacherTitleId = teacherTitleId;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
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
        Teacher other = (Teacher) that;
        return (this.getTeacherId() == null ? other.getTeacherId() == null : this.getTeacherId().equals(other.getTeacherId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getTeacherName() == null ? other.getTeacherName() == null : this.getTeacherName().equals(other.getTeacherName()))
            && (this.getEmployeeId() == null ? other.getEmployeeId() == null : this.getEmployeeId().equals(other.getEmployeeId()))
            && (this.getTeacherTitleId() == null ? other.getTeacherTitleId() == null : this.getTeacherTitleId().equals(other.getTeacherTitleId()))
            && (this.getCollegeId() == null ? other.getCollegeId() == null : this.getCollegeId().equals(other.getCollegeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTeacherId() == null) ? 0 : getTeacherId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getTeacherName() == null) ? 0 : getTeacherName().hashCode());
        result = prime * result + ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
        result = prime * result + ((getTeacherTitleId() == null) ? 0 : getTeacherTitleId().hashCode());
        result = prime * result + ((getCollegeId() == null) ? 0 : getCollegeId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", teacherId=").append(teacherId);
        sb.append(", userId=").append(userId);
        sb.append(", teacherName=").append(teacherName);
        sb.append(", employeeId=").append(employeeId);
        sb.append(", teacherTitleId=").append(teacherTitleId);
        sb.append(", collegeId=").append(collegeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public Teacher(Integer teacherId, Integer userId, String teacherName, String employeeId, Integer teacherTitleId, Integer collegeId) {
        this.teacherId = teacherId;
        this.userId = userId;
        this.teacherName = teacherName;
        this.employeeId = employeeId;
        this.teacherTitleId = teacherTitleId;
        this.collegeId = collegeId;
    }

    public Teacher() {
    }

    public void init() {
    }
}