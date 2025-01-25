package com.hdc.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class GradingStandard implements Serializable {
    /**
     * 评分标准ID
     */
    private Integer gradingStandardId;

    /**
     * 评估指标ID
     */
    private Integer evaluationIndexId;

    /**
     * 观测点ID
     */
    private Integer observationPointId;

    /**
     * 创建评分标准的学院ID
     */
    private Integer collegeId;

    /**
     * 分配的审核处Id
     */
    private Integer auditId;

    /**
     * 评分标准内容
     */
    private String content;

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

    private static final long serialVersionUID = 1L;

    public Integer getGradingStandardId() {
        return gradingStandardId;
    }

    public void setGradingStandardId(Integer gradingStandardId) {
        this.gradingStandardId = gradingStandardId;
    }

    public Integer getEvaluationIndexId() {
        return evaluationIndexId;
    }

    public void setEvaluationIndexId(Integer evaluationIndexId) {
        this.evaluationIndexId = evaluationIndexId;
    }

    public Integer getObservationPointId() {
        return observationPointId;
    }

    public void setObservationPointId(Integer observationPointId) {
        this.observationPointId = observationPointId;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        GradingStandard other = (GradingStandard) that;
        return (this.getGradingStandardId() == null ? other.getGradingStandardId() == null : this.getGradingStandardId().equals(other.getGradingStandardId()))
            && (this.getEvaluationIndexId() == null ? other.getEvaluationIndexId() == null : this.getEvaluationIndexId().equals(other.getEvaluationIndexId()))
            && (this.getObservationPointId() == null ? other.getObservationPointId() == null : this.getObservationPointId().equals(other.getObservationPointId()))
            && (this.getCollegeId() == null ? other.getCollegeId() == null : this.getCollegeId().equals(other.getCollegeId()))
            && (this.getAuditId() == null ? other.getAuditId() == null : this.getAuditId().equals(other.getAuditId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getGradingBasis() == null ? other.getGradingBasis() == null : this.getGradingBasis().equals(other.getGradingBasis()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getSemester() == null ? other.getSemester() == null : this.getSemester().equals(other.getSemester()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGradingStandardId() == null) ? 0 : getGradingStandardId().hashCode());
        result = prime * result + ((getEvaluationIndexId() == null) ? 0 : getEvaluationIndexId().hashCode());
        result = prime * result + ((getObservationPointId() == null) ? 0 : getObservationPointId().hashCode());
        result = prime * result + ((getCollegeId() == null) ? 0 : getCollegeId().hashCode());
        result = prime * result + ((getAuditId() == null) ? 0 : getAuditId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getGradingBasis() == null) ? 0 : getGradingBasis().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
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
        sb.append(", gradingStandardId=").append(gradingStandardId);
        sb.append(", evaluationIndexId=").append(evaluationIndexId);
        sb.append(", observationPointId=").append(observationPointId);
        sb.append(", collegeId=").append(collegeId);
        sb.append(", auditId=").append(auditId);
        sb.append(", content=").append(content);
        sb.append(", gradingBasis=").append(gradingBasis);
        sb.append(", note=").append(note);
        sb.append(", year=").append(year);
        sb.append(", semester=").append(semester);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}