package com.hdc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 
 */
public class OrderTable implements Serializable {
    /**
     * 评分标准ID
     */
    private Integer gradingStandardId;

    /**
     * 评分标准内容
     */
    private String gradingStandardContent;

    /**
     * 观测点ID
     */
    private Integer observationPointId;

    /**
     * 观测点内容
     */
    private String observationPointContent;

    /**
     * 评估指标ID
     */
    private Integer evaluationIndexId;

    /**
     * 评估指标内容
     */
    private String evaluationIndexContent;

    /**
     * 所属学院ID
     */
    private Integer collegeId;

    /**
     * 所属学院名称
     */
    private String collegeName;

    /**
     * 评分依据
     */
    private String gradingBasis;

    /**
     * 备注信息
     */
    private String note;

    /**
     * 所属年份
     */
    private Integer year;

    /**
     * 所属学期
     */
    private Integer semester;

    /**
     * 新业绩申报单ID
     */
    private Long orderId;

    /**
     * 申请人用户ID
     */
    private Integer teacherId;

    /**
     * 教师姓名
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
     * 教师职称名称
     */
    private String teacherTitleName;

    /**
     * 认证机构ID
     */
    private Integer auditId;

    /**
     * 认证机构的名称
     */
    private String auditName;

    /**
     * 自评得分
     */
    private BigDecimal selfReportScore;

    /**
     * 被认证得分
     */
    private BigDecimal certifiedScore;

    /**
     * 申报备注
     */
    private String declarationNote;

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

    private List<OrderFile> orderFileList;

    private static final long serialVersionUID = 1L;

    public Integer getGradingStandardId() {
        return gradingStandardId;
    }

    public void setGradingStandardId(Integer gradingStandardId) {
        this.gradingStandardId = gradingStandardId;
    }

    public String getGradingStandardContent() {
        return gradingStandardContent;
    }

    public void setGradingStandardContent(String gradingStandardContent) {
        this.gradingStandardContent = gradingStandardContent;
    }

    public Integer getObservationPointId() {
        return observationPointId;
    }

    public void setObservationPointId(Integer observationPointId) {
        this.observationPointId = observationPointId;
    }

    public String getObservationPointContent() {
        return observationPointContent;
    }

    public void setObservationPointContent(String observationPointContent) {
        this.observationPointContent = observationPointContent;
    }

    public Integer getEvaluationIndexId() {
        return evaluationIndexId;
    }

    public void setEvaluationIndexId(Integer evaluationIndexId) {
        this.evaluationIndexId = evaluationIndexId;
    }

    public String getEvaluationIndexContent() {
        return evaluationIndexContent;
    }

    public void setEvaluationIndexContent(String evaluationIndexContent) {
        this.evaluationIndexContent = evaluationIndexContent;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getGradingBasis() {
        return gradingBasis;
    }

    public void setGradingBasis(String gradingBasis) {
        this.gradingBasis = gradingBasis;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public String getTeacherTitleName() {
        return teacherTitleName;
    }

    public void setTeacherTitleName(String teacherTitleName) {
        this.teacherTitleName = teacherTitleName;
    }

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    public String getAuditName() {
        return auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName;
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

    public String getDeclarationNote() {
        return declarationNote;
    }

    public void setDeclarationNote(String declarationNote) {
        this.declarationNote = declarationNote;
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
        OrderTable other = (OrderTable) that;
        return (this.getGradingStandardId() == null ? other.getGradingStandardId() == null : this.getGradingStandardId().equals(other.getGradingStandardId()))
            && (this.getGradingStandardContent() == null ? other.getGradingStandardContent() == null : this.getGradingStandardContent().equals(other.getGradingStandardContent()))
            && (this.getObservationPointId() == null ? other.getObservationPointId() == null : this.getObservationPointId().equals(other.getObservationPointId()))
            && (this.getObservationPointContent() == null ? other.getObservationPointContent() == null : this.getObservationPointContent().equals(other.getObservationPointContent()))
            && (this.getEvaluationIndexId() == null ? other.getEvaluationIndexId() == null : this.getEvaluationIndexId().equals(other.getEvaluationIndexId()))
            && (this.getEvaluationIndexContent() == null ? other.getEvaluationIndexContent() == null : this.getEvaluationIndexContent().equals(other.getEvaluationIndexContent()))
            && (this.getCollegeId() == null ? other.getCollegeId() == null : this.getCollegeId().equals(other.getCollegeId()))
            && (this.getCollegeName() == null ? other.getCollegeName() == null : this.getCollegeName().equals(other.getCollegeName()))
            && (this.getGradingBasis() == null ? other.getGradingBasis() == null : this.getGradingBasis().equals(other.getGradingBasis()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getSemester() == null ? other.getSemester() == null : this.getSemester().equals(other.getSemester()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getTeacherId() == null ? other.getTeacherId() == null : this.getTeacherId().equals(other.getTeacherId()))
            && (this.getTeacherName() == null ? other.getTeacherName() == null : this.getTeacherName().equals(other.getTeacherName()))
            && (this.getEmployeeId() == null ? other.getEmployeeId() == null : this.getEmployeeId().equals(other.getEmployeeId()))
            && (this.getTeacherTitleId() == null ? other.getTeacherTitleId() == null : this.getTeacherTitleId().equals(other.getTeacherTitleId()))
            && (this.getTeacherTitleName() == null ? other.getTeacherTitleName() == null : this.getTeacherTitleName().equals(other.getTeacherTitleName()))
            && (this.getAuditId() == null ? other.getAuditId() == null : this.getAuditId().equals(other.getAuditId()))
            && (this.getAuditName() == null ? other.getAuditName() == null : this.getAuditName().equals(other.getAuditName()))
            && (this.getSelfReportScore() == null ? other.getSelfReportScore() == null : this.getSelfReportScore().equals(other.getSelfReportScore()))
            && (this.getCertifiedScore() == null ? other.getCertifiedScore() == null : this.getCertifiedScore().equals(other.getCertifiedScore()))
            && (this.getDeclarationNote() == null ? other.getDeclarationNote() == null : this.getDeclarationNote().equals(other.getDeclarationNote()))
            && (this.getCertifiedNote() == null ? other.getCertifiedNote() == null : this.getCertifiedNote().equals(other.getCertifiedNote()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getCertifiedTime() == null ? other.getCertifiedTime() == null : this.getCertifiedTime().equals(other.getCertifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGradingStandardId() == null) ? 0 : getGradingStandardId().hashCode());
        result = prime * result + ((getGradingStandardContent() == null) ? 0 : getGradingStandardContent().hashCode());
        result = prime * result + ((getObservationPointId() == null) ? 0 : getObservationPointId().hashCode());
        result = prime * result + ((getObservationPointContent() == null) ? 0 : getObservationPointContent().hashCode());
        result = prime * result + ((getEvaluationIndexId() == null) ? 0 : getEvaluationIndexId().hashCode());
        result = prime * result + ((getEvaluationIndexContent() == null) ? 0 : getEvaluationIndexContent().hashCode());
        result = prime * result + ((getCollegeId() == null) ? 0 : getCollegeId().hashCode());
        result = prime * result + ((getCollegeName() == null) ? 0 : getCollegeName().hashCode());
        result = prime * result + ((getGradingBasis() == null) ? 0 : getGradingBasis().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getSemester() == null) ? 0 : getSemester().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getTeacherId() == null) ? 0 : getTeacherId().hashCode());
        result = prime * result + ((getTeacherName() == null) ? 0 : getTeacherName().hashCode());
        result = prime * result + ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
        result = prime * result + ((getTeacherTitleId() == null) ? 0 : getTeacherTitleId().hashCode());
        result = prime * result + ((getTeacherTitleName() == null) ? 0 : getTeacherTitleName().hashCode());
        result = prime * result + ((getAuditId() == null) ? 0 : getAuditId().hashCode());
        result = prime * result + ((getAuditName() == null) ? 0 : getAuditName().hashCode());
        result = prime * result + ((getSelfReportScore() == null) ? 0 : getSelfReportScore().hashCode());
        result = prime * result + ((getCertifiedScore() == null) ? 0 : getCertifiedScore().hashCode());
        result = prime * result + ((getDeclarationNote() == null) ? 0 : getDeclarationNote().hashCode());
        result = prime * result + ((getCertifiedNote() == null) ? 0 : getCertifiedNote().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getCertifiedTime() == null) ? 0 : getCertifiedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gradingStandardId=").append(gradingStandardId);
        sb.append(", gradingStandardContent=").append(gradingStandardContent);
        sb.append(", observationPointId=").append(observationPointId);
        sb.append(", observationPointContent=").append(observationPointContent);
        sb.append(", evaluationIndexId=").append(evaluationIndexId);
        sb.append(", evaluationIndexContent=").append(evaluationIndexContent);
        sb.append(", collegeId=").append(collegeId);
        sb.append(", collegeName=").append(collegeName);
        sb.append(", gradingBasis=").append(gradingBasis);
        sb.append(", note=").append(note);
        sb.append(", year=").append(year);
        sb.append(", semester=").append(semester);
        sb.append(", orderId=").append(orderId);
        sb.append(", teacherId=").append(teacherId);
        sb.append(", teacherName=").append(teacherName);
        sb.append(", employeeId=").append(employeeId);
        sb.append(", teacherTitleId=").append(teacherTitleId);
        sb.append(", teacherTitleName=").append(teacherTitleName);
        sb.append(", auditId=").append(auditId);
        sb.append(", auditName=").append(auditName);
        sb.append(", selfReportScore=").append(selfReportScore);
        sb.append(", certifiedScore=").append(certifiedScore);
        sb.append(", declarationNote=").append(declarationNote);
        sb.append(", certifiedNote=").append(certifiedNote);
        sb.append(", status=").append(status);
        sb.append(", addTime=").append(addTime);
        sb.append(", certifiedTime=").append(certifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public List<OrderFile> getOrderFileList() {
        return orderFileList;
    }

    public void setOrderFileList(List<OrderFile> orderFileList) {
        this.orderFileList = orderFileList;
    }
}