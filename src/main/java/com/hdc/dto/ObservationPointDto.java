package com.hdc.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

/**
 * @author 
 */
public class ObservationPointDto implements Serializable {


    /**
     * 观测点ID
     */

    private Integer observationPointId;


    /**
     * 评估指标ID
     */
    @Range(min=0,message = "开启系统参数错误")
    private Integer evaluationIndexId;

    /**
     * 评估指标名称
     */
    private String evaluationIndexName;

    @NotBlank(message = "评估指标内容不能为空")
    private String content;


    private static final long serialVersionUID = 1L;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getEvaluationIndexName() {
        return evaluationIndexName;
    }

    public void setEvaluationIndexName(String evaluationIndexName) {
        this.evaluationIndexName = evaluationIndexName;
    }
}