package com.hdc.dto;



import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author 
 */
public class SystemBaseConfigDto implements Serializable {
    /**
     * 系统配置ID
     */
    private Integer systemConfigId;

    /**
     * 系统是否开启：0关闭，1开启
     */
    @NotNull(message = "开启系统参数不能为空")
    @Range(min=0, max=1,message = "开启系统参数错误")
    private Byte systemOpen;

    /**
     * 系统当前年份
     */
    @NotNull(message = "年份参数不能为空")
    @Range(min=1940, max=2050,message = "年份参数错误")
    private Integer systemYear;

    /**
     * 系统当前学期
     */
    @NotNull(message = "学期参数不能为空")
    @Range(min=1, max=2,message = "学期参数错误")
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


}