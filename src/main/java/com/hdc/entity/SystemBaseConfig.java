package com.hdc.entity;



import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author 
 */
public class SystemBaseConfig implements Serializable {
    /**
     * 系统配置ID
     */
    private Integer systemConfigId;

    /**
     * 系统是否开启：0关闭，1开启
     */
    private Byte systemOpen;

    /**
     * 系统当前年份
     */
    private Integer systemYear;

    /**
     * 系统当前学期
     */
    private Integer systemSemester;

    private static final long serialVersionUID = 1L;

    public Integer getSystemConfigId() {
        return systemConfigId;
    }

    public void setSystemConfigId(Integer systemConfigId) {
        this.systemConfigId = systemConfigId;
    }

    public Byte getSystemOpen() {
        return systemOpen;
    }

    public void setSystemOpen(Byte systemOpen) {
        this.systemOpen = systemOpen;
    }

    public Integer getSystemYear() {
        return systemYear;
    }

    public void setSystemYear(Integer systemYear) {
        this.systemYear = systemYear;
    }

    public Integer getSystemSemester() {
        return systemSemester;
    }

    public void setSystemSemester(Integer systemSemester) {
        this.systemSemester = systemSemester;
    }

    @Override
    public String toString() {
        return "systemOpen ："+systemOpen+" systemYear ："+systemYear+" systemSemester ："+systemSemester;
    }
}