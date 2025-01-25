package com.hdc.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

/**
 * @author 
 */
public class GradingStandardDto implements Serializable {


    /**
     * 评分标准ID
     */
    private Integer gradingStandardId;

    /**
     * 评估指标ID
     */
    @Range(min=0,message = "评估指标ID参数错误")
    private Integer evaluationIndexId;

    /**
     * 观测点ID
     */
    @Range(min=0,message = "观测点ID参数错误")
    private Integer observationPointId;

    /**
     * 创建评分标准的学院ID
     */
    private Integer collegeId;

    /**
     * 分配的审核处Id
     */
    @Range(min=0,message = "审核处Id参数错误")
    private Integer auditId;

    /**
     * 评分标准内容
     */
    @NotBlank(message = "评分标准内容不能为空")
    private String content;

    /**
     * 评分依据
     */
    @NotBlank(message = "评分依据内容不能为空")
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

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }
}