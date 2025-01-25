package com.hdc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 
 */
public class Order implements Serializable {
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

    private static final long serialVersionUID = 1L;

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
        Order other = (Order) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getTeacherId() == null ? other.getTeacherId() == null : this.getTeacherId().equals(other.getTeacherId()))
            && (this.getGradingStandardId() == null ? other.getGradingStandardId() == null : this.getGradingStandardId().equals(other.getGradingStandardId()))
            && (this.getAuditId() == null ? other.getAuditId() == null : this.getAuditId().equals(other.getAuditId()))
            && (this.getDeclarationNote() == null ? other.getDeclarationNote() == null : this.getDeclarationNote().equals(other.getDeclarationNote()))
            && (this.getSelfReportScore() == null ? other.getSelfReportScore() == null : this.getSelfReportScore().equals(other.getSelfReportScore()))
            && (this.getCertifiedScore() == null ? other.getCertifiedScore() == null : this.getCertifiedScore().equals(other.getCertifiedScore()))
            && (this.getCertifiedNote() == null ? other.getCertifiedNote() == null : this.getCertifiedNote().equals(other.getCertifiedNote()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getCertifiedTime() == null ? other.getCertifiedTime() == null : this.getCertifiedTime().equals(other.getCertifiedTime()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getSemester() == null ? other.getSemester() == null : this.getSemester().equals(other.getSemester()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getTeacherId() == null) ? 0 : getTeacherId().hashCode());
        result = prime * result + ((getGradingStandardId() == null) ? 0 : getGradingStandardId().hashCode());
        result = prime * result + ((getAuditId() == null) ? 0 : getAuditId().hashCode());
        result = prime * result + ((getDeclarationNote() == null) ? 0 : getDeclarationNote().hashCode());
        result = prime * result + ((getSelfReportScore() == null) ? 0 : getSelfReportScore().hashCode());
        result = prime * result + ((getCertifiedScore() == null) ? 0 : getCertifiedScore().hashCode());
        result = prime * result + ((getCertifiedNote() == null) ? 0 : getCertifiedNote().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getCertifiedTime() == null) ? 0 : getCertifiedTime().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getSemester() == null) ? 0 : getSemester().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", teacherId=").append(teacherId);
        sb.append(", gradingStandardId=").append(gradingStandardId);
        sb.append(", auditId=").append(auditId);
        sb.append(", declarationNote=").append(declarationNote);
        sb.append(", selfReportScore=").append(selfReportScore);
        sb.append(", certifiedScore=").append(certifiedScore);
        sb.append(", certifiedNote=").append(certifiedNote);
        sb.append(", status=").append(status);
        sb.append(", addTime=").append(addTime);
        sb.append(", certifiedTime=").append(certifiedTime);
        sb.append(", year=").append(year);
        sb.append(", semester=").append(semester);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}