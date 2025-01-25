package com.hdc.dto;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author 
 */
public class EvaluationIndexDto implements Serializable {

    /**
     * 评估指标ID
     */
    private Integer evaluationIndexId;

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
}