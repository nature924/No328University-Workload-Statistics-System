package com.hdc.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 
 */
public class OrderDto implements Serializable {

    /**
     * 新业绩申报单ID
     */
    private Long orderId;

    /**
     * 申请人教师ID
     */
    private Integer teacherId;

    /**
     * 观测点的评分标准ID
     */
    private Integer gradingStandardId;

    /**
     * 认证机构ID
     */
    private Integer auditId;

    /**
     * 申报备注
     */
    private String declarationNote;

    /**
     * 自评得分
     */

    @DecimalMin(value= "0" ,message = "自评得分必须为正数")
    @Digits(integer = 5, fraction = 2,message = "自评得分必须为保留两位小数的正数")
    private BigDecimal selfReportScore;

    /**
     * 被认证得分
     */
    private BigDecimal certifiedScore;

    /**
     * 认证备注
     */
    private String certifiedNote;

    /**
     * 申报单状态：-1异常，0未申报，1新申报待认证，2已认证，3退回，4评分周期结束
     */
    private Byte status;

    /**
     * 申报时间
     */
    private Date addTime;

    /**
     * 被认证时间
     */
    private Date certifiedTime;

    /**
     * 所属年份
     */
    private Integer year;

    /**
     * 所属学期
     */
    private Integer semester;

    private List<Long> orderFileIdList;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getGradingStandardId() {
        return gradingStandardId;
    }

    public void setGradingStandardId(Integer gradingStandardId) {
        this.gradingStandardId = gradingStandardId;
    }

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    public String getDeclarationNote() {
        return declarationNote;
    }

    public void setDeclarationNote(String declarationNote) {
        this.declarationNote = declarationNote;
    }

    public BigDecimal getSelfReportScore() {
        return selfReportScore;
    }

    public void setSelfReportScore(BigDecimal selfReportScore) {
        this.selfReportScore = selfReportScore;
    }

    public BigDecimal getCertifiedScore() {
        return certifiedScore;
    }

    public void setCertifiedScore(BigDecimal certifiedScore) {
        this.certifiedScore = certifiedScore;
    }

    public String getCertifiedNote() {
        return certifiedNote;
    }

    public void setCertifiedNote(String certifiedNote) {
        this.certifiedNote = certifiedNote;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getCertifiedTime() {
        return certifiedTime;
    }

    public void setCertifiedTime(Date certifiedTime) {
        this.certifiedTime = certifiedTime;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public List<Long> getOrderFileIdList() {
        return orderFileIdList;
    }

    public void setOrderFileIdList(List<Long> orderFileIdList) {
        this.orderFileIdList = orderFileIdList;
    }
}