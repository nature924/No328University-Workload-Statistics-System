package com.hdc.entity;

import java.util.ArrayList;
import java.util.List;

public class GradingStandardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public GradingStandardExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andGradingStandardIdIsNull() {
            addCriterion("grading_standard_id is null");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdIsNotNull() {
            addCriterion("grading_standard_id is not null");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdEqualTo(Integer value) {
            addCriterion("grading_standard_id =", value, "gradingStandardId");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdNotEqualTo(Integer value) {
            addCriterion("grading_standard_id <>", value, "gradingStandardId");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdGreaterThan(Integer value) {
            addCriterion("grading_standard_id >", value, "gradingStandardId");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("grading_standard_id >=", value, "gradingStandardId");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdLessThan(Integer value) {
            addCriterion("grading_standard_id <", value, "gradingStandardId");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdLessThanOrEqualTo(Integer value) {
            addCriterion("grading_standard_id <=", value, "gradingStandardId");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdIn(List<Integer> values) {
            addCriterion("grading_standard_id in", values, "gradingStandardId");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdNotIn(List<Integer> values) {
            addCriterion("grading_standard_id not in", values, "gradingStandardId");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdBetween(Integer value1, Integer value2) {
            addCriterion("grading_standard_id between", value1, value2, "gradingStandardId");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdNotBetween(Integer value1, Integer value2) {
            addCriterion("grading_standard_id not between", value1, value2, "gradingStandardId");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdIsNull() {
            addCriterion("evaluation_index_id is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdIsNotNull() {
            addCriterion("evaluation_index_id is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdEqualTo(Integer value) {
            addCriterion("evaluation_index_id =", value, "evaluationIndexId");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdNotEqualTo(Integer value) {
            addCriterion("evaluation_index_id <>", value, "evaluationIndexId");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdGreaterThan(Integer value) {
            addCriterion("evaluation_index_id >", value, "evaluationIndexId");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluation_index_id >=", value, "evaluationIndexId");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdLessThan(Integer value) {
            addCriterion("evaluation_index_id <", value, "evaluationIndexId");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdLessThanOrEqualTo(Integer value) {
            addCriterion("evaluation_index_id <=", value, "evaluationIndexId");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdIn(List<Integer> values) {
            addCriterion("evaluation_index_id in", values, "evaluationIndexId");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdNotIn(List<Integer> values) {
            addCriterion("evaluation_index_id not in", values, "evaluationIndexId");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdBetween(Integer value1, Integer value2) {
            addCriterion("evaluation_index_id between", value1, value2, "evaluationIndexId");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluation_index_id not between", value1, value2, "evaluationIndexId");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdIsNull() {
            addCriterion("observation_point_id is null");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdIsNotNull() {
            addCriterion("observation_point_id is not null");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdEqualTo(Integer value) {
            addCriterion("observation_point_id =", value, "observationPointId");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdNotEqualTo(Integer value) {
            addCriterion("observation_point_id <>", value, "observationPointId");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdGreaterThan(Integer value) {
            addCriterion("observation_point_id >", value, "observationPointId");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("observation_point_id >=", value, "observationPointId");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdLessThan(Integer value) {
            addCriterion("observation_point_id <", value, "observationPointId");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdLessThanOrEqualTo(Integer value) {
            addCriterion("observation_point_id <=", value, "observationPointId");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdIn(List<Integer> values) {
            addCriterion("observation_point_id in", values, "observationPointId");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdNotIn(List<Integer> values) {
            addCriterion("observation_point_id not in", values, "observationPointId");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdBetween(Integer value1, Integer value2) {
            addCriterion("observation_point_id between", value1, value2, "observationPointId");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdNotBetween(Integer value1, Integer value2) {
            addCriterion("observation_point_id not between", value1, value2, "observationPointId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIsNull() {
            addCriterion("college_id is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIsNotNull() {
            addCriterion("college_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeIdEqualTo(Integer value) {
            addCriterion("college_id =", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotEqualTo(Integer value) {
            addCriterion("college_id <>", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdGreaterThan(Integer value) {
            addCriterion("college_id >", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("college_id >=", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLessThan(Integer value) {
            addCriterion("college_id <", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLessThanOrEqualTo(Integer value) {
            addCriterion("college_id <=", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIn(List<Integer> values) {
            addCriterion("college_id in", values, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotIn(List<Integer> values) {
            addCriterion("college_id not in", values, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdBetween(Integer value1, Integer value2) {
            addCriterion("college_id between", value1, value2, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("college_id not between", value1, value2, "collegeId");
            return (Criteria) this;
        }

        public Criteria andAuditIdIsNull() {
            addCriterion("audit_id is null");
            return (Criteria) this;
        }

        public Criteria andAuditIdIsNotNull() {
            addCriterion("audit_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuditIdEqualTo(Integer value) {
            addCriterion("audit_id =", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdNotEqualTo(Integer value) {
            addCriterion("audit_id <>", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdGreaterThan(Integer value) {
            addCriterion("audit_id >", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_id >=", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdLessThan(Integer value) {
            addCriterion("audit_id <", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdLessThanOrEqualTo(Integer value) {
            addCriterion("audit_id <=", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdIn(List<Integer> values) {
            addCriterion("audit_id in", values, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdNotIn(List<Integer> values) {
            addCriterion("audit_id not in", values, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdBetween(Integer value1, Integer value2) {
            addCriterion("audit_id between", value1, value2, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_id not between", value1, value2, "auditId");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andGradingBasisIsNull() {
            addCriterion("grading_basis is null");
            return (Criteria) this;
        }

        public Criteria andGradingBasisIsNotNull() {
            addCriterion("grading_basis is not null");
            return (Criteria) this;
        }

        public Criteria andGradingBasisEqualTo(String value) {
            addCriterion("grading_basis =", value, "gradingBasis");
            return (Criteria) this;
        }

        public Criteria andGradingBasisNotEqualTo(String value) {
            addCriterion("grading_basis <>", value, "gradingBasis");
            return (Criteria) this;
        }

        public Criteria andGradingBasisGreaterThan(String value) {
            addCriterion("grading_basis >", value, "gradingBasis");
            return (Criteria) this;
        }

        public Criteria andGradingBasisGreaterThanOrEqualTo(String value) {
            addCriterion("grading_basis >=", value, "gradingBasis");
            return (Criteria) this;
        }

        public Criteria andGradingBasisLessThan(String value) {
            addCriterion("grading_basis <", value, "gradingBasis");
            return (Criteria) this;
        }

        public Criteria andGradingBasisLessThanOrEqualTo(String value) {
            addCriterion("grading_basis <=", value, "gradingBasis");
            return (Criteria) this;
        }

        public Criteria andGradingBasisLike(String value) {
            addCriterion("grading_basis like", value, "gradingBasis");
            return (Criteria) this;
        }

        public Criteria andGradingBasisNotLike(String value) {
            addCriterion("grading_basis not like", value, "gradingBasis");
            return (Criteria) this;
        }

        public Criteria andGradingBasisIn(List<String> values) {
            addCriterion("grading_basis in", values, "gradingBasis");
            return (Criteria) this;
        }

        public Criteria andGradingBasisNotIn(List<String> values) {
            addCriterion("grading_basis not in", values, "gradingBasis");
            return (Criteria) this;
        }

        public Criteria andGradingBasisBetween(String value1, String value2) {
            addCriterion("grading_basis between", value1, value2, "gradingBasis");
            return (Criteria) this;
        }

        public Criteria andGradingBasisNotBetween(String value1, String value2) {
            addCriterion("grading_basis not between", value1, value2, "gradingBasis");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andSemesterIsNull() {
            addCriterion("semester is null");
            return (Criteria) this;
        }

        public Criteria andSemesterIsNotNull() {
            addCriterion("semester is not null");
            return (Criteria) this;
        }

        public Criteria andSemesterEqualTo(Integer value) {
            addCriterion("semester =", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterNotEqualTo(Integer value) {
            addCriterion("semester <>", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterGreaterThan(Integer value) {
            addCriterion("semester >", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterGreaterThanOrEqualTo(Integer value) {
            addCriterion("semester >=", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterLessThan(Integer value) {
            addCriterion("semester <", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterLessThanOrEqualTo(Integer value) {
            addCriterion("semester <=", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterIn(List<Integer> values) {
            addCriterion("semester in", values, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterNotIn(List<Integer> values) {
            addCriterion("semester not in", values, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterBetween(Integer value1, Integer value2) {
            addCriterion("semester between", value1, value2, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterNotBetween(Integer value1, Integer value2) {
            addCriterion("semester not between", value1, value2, "semester");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}