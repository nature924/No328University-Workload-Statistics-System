package com.hdc.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class ObservationPoint implements Serializable {
    /**
     * 观测点ID
     */
    private Integer observationPointId;

    /**
     * 评估指标ID
     */
    private Integer evaluationIndexId;

    /**
     * 观测点内容
     */
    private String content;

    /**
     * 创建观察点的学院ID
     */
    private Integer collegeId;

    /**
     * 所属年份
     */
    private Integer year;

    /**
     * 所属学期
     */
    private Integer semester;

    private static final long serialVersionUID = 1L;

    public Integer getObservationPointId() {
        return observationPointId;
    }

    public void setObservationPointId(Integer observationPointId) {
        this.observationPointId = observationPointId;
    }

    public Integer getEvaluationIndexId() {
        return evaluationIndexId;
    }

    public void setEvaluationIndexId(Integer evaluationIndexId) {
        this.evaluationIndexId = evaluationIndexId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
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
        ObservationPoint other = (ObservationPoint) that;
        return (this.getObservationPointId() == null ? other.getObservationPointId() == null : this.getObservationPointId().equals(other.getObservationPointId()))
            && (this.getEvaluationIndexId() == null ? other.getEvaluationIndexId() == null : this.getEvaluationIndexId().equals(other.getEvaluationIndexId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getCollegeId() == null ? other.getCollegeId() == null : this.getCollegeId().equals(other.getCollegeId()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getSemester() == null ? other.getSemester() == null : this.getSemester().equals(other.getSemester()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getObservationPointId() == null) ? 0 : getObservationPointId().hashCode());
        result = prime * result + ((getEvaluationIndexId() == null) ? 0 : getEvaluationIndexId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getCollegeId() == null) ? 0 : getCollegeId().hashCode());
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
        sb.append(", observationPointId=").append(observationPointId);
        sb.append(", evaluationIndexId=").append(evaluationIndexId);
        sb.append(", content=").append(content);
        sb.append(", collegeId=").append(collegeId);
        sb.append(", year=").append(year);
        sb.append(", semester=").append(semester);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}