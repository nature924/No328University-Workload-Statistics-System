package com.hdc.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public OrderTableExample() {
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
            addCriterion("grading_standard.grading_standard_id is null");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdIsNotNull() {
            addCriterion("grading_standard.grading_standard_id is not null");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdEqualTo(Integer value) {
            addCriterion("grading_standard.grading_standard_id =", value, "gradingStandardId");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdNotEqualTo(Integer value) {
            addCriterion("grading_standard.grading_standard_id <>", value, "gradingStandardId");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdGreaterThan(Integer value) {
            addCriterion("grading_standard.grading_standard_id >", value, "gradingStandardId");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("grading_standard.grading_standard_id >=", value, "gradingStandardId");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdLessThan(Integer value) {
            addCriterion("grading_standard.grading_standard_id <", value, "gradingStandardId");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdLessThanOrEqualTo(Integer value) {
            addCriterion("grading_standard.grading_standard_id <=", value, "gradingStandardId");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdIn(List<Integer> values) {
            addCriterion("grading_standard.grading_standard_id in", values, "gradingStandardId");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdNotIn(List<Integer> values) {
            addCriterion("grading_standard.grading_standard_id not in", values, "gradingStandardId");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdBetween(Integer value1, Integer value2) {
            addCriterion("grading_standard.grading_standard_id between", value1, value2, "gradingStandardId");
            return (Criteria) this;
        }

        public Criteria andGradingStandardIdNotBetween(Integer value1, Integer value2) {
            addCriterion("grading_standard.grading_standard_id not between", value1, value2, "gradingStandardId");
            return (Criteria) this;
        }

        public Criteria andGradingStandardContentIsNull() {
            addCriterion("grading_standard.grading_standard_content is null");
            return (Criteria) this;
        }

        public Criteria andGradingStandardContentIsNotNull() {
            addCriterion("grading_standard.grading_standard_content is not null");
            return (Criteria) this;
        }

        public Criteria andGradingStandardContentEqualTo(String value) {
            addCriterion("grading_standard.grading_standard_content =", value, "gradingStandardContent");
            return (Criteria) this;
        }

        public Criteria andGradingStandardContentNotEqualTo(String value) {
            addCriterion("grading_standard.grading_standard_content <>", value, "gradingStandardContent");
            return (Criteria) this;
        }

        public Criteria andGradingStandardContentGreaterThan(String value) {
            addCriterion("grading_standard.grading_standard_content >", value, "gradingStandardContent");
            return (Criteria) this;
        }

        public Criteria andGradingStandardContentGreaterThanOrEqualTo(String value) {
            addCriterion("grading_standard.grading_standard_content >=", value, "gradingStandardContent");
            return (Criteria) this;
        }

        public Criteria andGradingStandardContentLessThan(String value) {
            addCriterion("grading_standard.grading_standard_content <", value, "gradingStandardContent");
            return (Criteria) this;
        }

        public Criteria andGradingStandardContentLessThanOrEqualTo(String value) {
            addCriterion("grading_standard.grading_standard_content <=", value, "gradingStandardContent");
            return (Criteria) this;
        }

        public Criteria andGradingStandardContentLike(String value) {
            addCriterion("grading_standard.grading_standard_content like", value, "gradingStandardContent");
            return (Criteria) this;
        }

        public Criteria andGradingStandardContentNotLike(String value) {
            addCriterion("grading_standard.grading_standard_content not like", value, "gradingStandardContent");
            return (Criteria) this;
        }

        public Criteria andGradingStandardContentIn(List<String> values) {
            addCriterion("grading_standard.grading_standard_content in", values, "gradingStandardContent");
            return (Criteria) this;
        }

        public Criteria andGradingStandardContentNotIn(List<String> values) {
            addCriterion("grading_standard.grading_standard_content not in", values, "gradingStandardContent");
            return (Criteria) this;
        }

        public Criteria andGradingStandardContentBetween(String value1, String value2) {
            addCriterion("grading_standard.grading_standard_content between", value1, value2, "gradingStandardContent");
            return (Criteria) this;
        }

        public Criteria andGradingStandardContentNotBetween(String value1, String value2) {
            addCriterion("grading_standard.grading_standard_content not between", value1, value2, "gradingStandardContent");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdIsNull() {
            addCriterion("grading_standard.observation_point_id is null");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdIsNotNull() {
            addCriterion("grading_standard.observation_point_id is not null");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdEqualTo(Integer value) {
            addCriterion("grading_standard.observation_point_id =", value, "observationPointId");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdNotEqualTo(Integer value) {
            addCriterion("grading_standard.observation_point_id <>", value, "observationPointId");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdGreaterThan(Integer value) {
            addCriterion("grading_standard.observation_point_id >", value, "observationPointId");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("grading_standard.observation_point_id >=", value, "observationPointId");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdLessThan(Integer value) {
            addCriterion("grading_standard.observation_point_id <", value, "observationPointId");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdLessThanOrEqualTo(Integer value) {
            addCriterion("grading_standard.observation_point_id <=", value, "observationPointId");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdIn(List<Integer> values) {
            addCriterion("grading_standard.observation_point_id in", values, "observationPointId");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdNotIn(List<Integer> values) {
            addCriterion("grading_standard.observation_point_id not in", values, "observationPointId");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdBetween(Integer value1, Integer value2) {
            addCriterion("grading_standard.observation_point_id between", value1, value2, "observationPointId");
            return (Criteria) this;
        }

        public Criteria andObservationPointIdNotBetween(Integer value1, Integer value2) {
            addCriterion("grading_standard.observation_point_id not between", value1, value2, "observationPointId");
            return (Criteria) this;
        }

        public Criteria andObservationPointContentIsNull() {
            addCriterion("observation_point.observation_point_content is null");
            return (Criteria) this;
        }

        public Criteria andObservationPointContentIsNotNull() {
            addCriterion("observation_point.observation_point_content is not null");
            return (Criteria) this;
        }

        public Criteria andObservationPointContentEqualTo(String value) {
            addCriterion("observation_point.observation_point_content =", value, "observationPointContent");
            return (Criteria) this;
        }

        public Criteria andObservationPointContentNotEqualTo(String value) {
            addCriterion("observation_point.observation_point_content <>", value, "observationPointContent");
            return (Criteria) this;
        }

        public Criteria andObservationPointContentGreaterThan(String value) {
            addCriterion("observation_point.observation_point_content >", value, "observationPointContent");
            return (Criteria) this;
        }

        public Criteria andObservationPointContentGreaterThanOrEqualTo(String value) {
            addCriterion("observation_point.observation_point_content >=", value, "observationPointContent");
            return (Criteria) this;
        }

        public Criteria andObservationPointContentLessThan(String value) {
            addCriterion("observation_point.observation_point_content <", value, "observationPointContent");
            return (Criteria) this;
        }

        public Criteria andObservationPointContentLessThanOrEqualTo(String value) {
            addCriterion("observation_point.observation_point_content <=", value, "observationPointContent");
            return (Criteria) this;
        }

        public Criteria andObservationPointContentLike(String value) {
            addCriterion("observation_point.observation_point_content like", value, "observationPointContent");
            return (Criteria) this;
        }

        public Criteria andObservationPointContentNotLike(String value) {
            addCriterion("observation_point_content not like", value, "observationPointContent");
            return (Criteria) this;
        }

        public Criteria andObservationPointContentIn(List<String> values) {
            addCriterion("observation_point.observation_point_content in", values, "observationPointContent");
            return (Criteria) this;
        }

        public Criteria andObservationPointContentNotIn(List<String> values) {
            addCriterion("observation_point.observation_point_content not in", values, "observationPointContent");
            return (Criteria) this;
        }

        public Criteria andObservationPointContentBetween(String value1, String value2) {
            addCriterion("observation_point.observation_point_content between", value1, value2, "observationPointContent");
            return (Criteria) this;
        }

        public Criteria andObservationPointContentNotBetween(String value1, String value2) {
            addCriterion("observation_point.observation_point_content not between", value1, value2, "observationPointContent");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdIsNull() {
            addCriterion("grading_standard.evaluation_index_id is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdIsNotNull() {
            addCriterion("grading_standard.evaluation_index_id is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdEqualTo(Integer value) {
            addCriterion("grading_standard.evaluation_index_id =", value, "evaluationIndexId");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdNotEqualTo(Integer value) {
            addCriterion("grading_standard.evaluation_index_id <>", value, "evaluationIndexId");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdGreaterThan(Integer value) {
            addCriterion("grading_standard.evaluation_index_id >", value, "evaluationIndexId");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("grading_standard.evaluation_index_id >=", value, "evaluationIndexId");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdLessThan(Integer value) {
            addCriterion("grading_standard.evaluation_index_id <", value, "evaluationIndexId");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdLessThanOrEqualTo(Integer value) {
            addCriterion("grading_standard.evaluation_index_id <=", value, "evaluationIndexId");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdIn(List<Integer> values) {
            addCriterion("grading_standard.evaluation_index_id in", values, "evaluationIndexId");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdNotIn(List<Integer> values) {
            addCriterion("grading_standard.evaluation_index_id not in", values, "evaluationIndexId");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdBetween(Integer value1, Integer value2) {
            addCriterion("grading_standard.evaluation_index_id between", value1, value2, "evaluationIndexId");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexIdNotBetween(Integer value1, Integer value2) {
            addCriterion("grading_standard.evaluation_index_id not between", value1, value2, "evaluationIndexId");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexContentIsNull() {
            addCriterion("evaluation_index.evaluation_index_content is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexContentIsNotNull() {
            addCriterion("evaluation_index.evaluation_index_content is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexContentEqualTo(String value) {
            addCriterion("evaluation_index.evaluation_index_content =", value, "evaluationIndexContent");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexContentNotEqualTo(String value) {
            addCriterion("evaluation_index.evaluation_index_content <>", value, "evaluationIndexContent");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexContentGreaterThan(String value) {
            addCriterion("evaluation_index.evaluation_index_content >", value, "evaluationIndexContent");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexContentGreaterThanOrEqualTo(String value) {
            addCriterion("evaluation_index.evaluation_index_content >=", value, "evaluationIndexContent");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexContentLessThan(String value) {
            addCriterion("evaluation_index.evaluation_index_content <", value, "evaluationIndexContent");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexContentLessThanOrEqualTo(String value) {
            addCriterion("evaluation_index.evaluation_index_content <=", value, "evaluationIndexContent");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexContentLike(String value) {
            addCriterion("evaluation_index.evaluation_index_content like", value, "evaluationIndexContent");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexContentNotLike(String value) {
            addCriterion("evaluation_index.evaluation_index_content not like", value, "evaluationIndexContent");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexContentIn(List<String> values) {
            addCriterion("evaluation_index.evaluation_index_content in", values, "evaluationIndexContent");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexContentNotIn(List<String> values) {
            addCriterion("evaluation_index.evaluation_index_content not in", values, "evaluationIndexContent");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexContentBetween(String value1, String value2) {
            addCriterion("evaluation_index.evaluation_index_content between", value1, value2, "evaluationIndexContent");
            return (Criteria) this;
        }

        public Criteria andEvaluationIndexContentNotBetween(String value1, String value2) {
            addCriterion("evaluation_index.evaluation_index_content not between", value1, value2, "evaluationIndexContent");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIsNull() {
            addCriterion("grading_standard.college_id is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIsNotNull() {
            addCriterion("grading_standard.college_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeIdEqualTo(Integer value) {
            addCriterion("grading_standard.college_id =", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotEqualTo(Integer value) {
            addCriterion("grading_standard.college_id <>", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdGreaterThan(Integer value) {
            addCriterion("grading_standard.college_id >", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("grading_standard.college_id >=", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLessThan(Integer value) {
            addCriterion("grading_standard.college_id <", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLessThanOrEqualTo(Integer value) {
            addCriterion("grading_standard.college_id <=", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIn(List<Integer> values) {
            addCriterion("grading_standard.college_id in", values, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotIn(List<Integer> values) {
            addCriterion("grading_standard.college_id not in", values, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdBetween(Integer value1, Integer value2) {
            addCriterion("grading_standard.college_id between", value1, value2, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("grading_standard.college_id not between", value1, value2, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeNameIsNull() {
            addCriterion("college_name is null");
            return (Criteria) this;
        }

        public Criteria andCollegeNameIsNotNull() {
            addCriterion("college_name is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeNameEqualTo(String value) {
            addCriterion("college_name =", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameNotEqualTo(String value) {
            addCriterion("college_name <>", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameGreaterThan(String value) {
            addCriterion("college_name >", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameGreaterThanOrEqualTo(String value) {
            addCriterion("college_name >=", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameLessThan(String value) {
            addCriterion("college_name <", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameLessThanOrEqualTo(String value) {
            addCriterion("college_name <=", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameLike(String value) {
            addCriterion("college_name like", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameNotLike(String value) {
            addCriterion("college_name not like", value, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameIn(List<String> values) {
            addCriterion("college_name in", values, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameNotIn(List<String> values) {
            addCriterion("college_name not in", values, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameBetween(String value1, String value2) {
            addCriterion("college_name between", value1, value2, "collegeName");
            return (Criteria) this;
        }

        public Criteria andCollegeNameNotBetween(String value1, String value2) {
            addCriterion("college_name not between", value1, value2, "collegeName");
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
            addCriterion("order_.note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("order_.note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("order_.note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("order_.note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("order_.note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("order_.note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("order_.note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("order_.note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("order_.note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("order_.note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("order_.note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("order_.note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("order_.note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("order_.note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("order_.year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("order_.year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("order_.year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("order_.year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("order_.year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_.year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("order_.year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("order_.year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("order_.year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("order_.year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("order_.year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("order_.year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andSemesterIsNull() {
            addCriterion("order_.semester is null");
            return (Criteria) this;
        }

        public Criteria andSemesterIsNotNull() {
            addCriterion("order_.semester is not null");
            return (Criteria) this;
        }

        public Criteria andSemesterEqualTo(Integer value) {
            addCriterion("order_.semester =", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterNotEqualTo(Integer value) {
            addCriterion("order_.semester <>", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterGreaterThan(Integer value) {
            addCriterion("order_.semester >", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_.semester >=", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterLessThan(Integer value) {
            addCriterion("order_.semester <", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterLessThanOrEqualTo(Integer value) {
            addCriterion("order_.semester <=", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterIn(List<Integer> values) {
            addCriterion("order_.semester in", values, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterNotIn(List<Integer> values) {
            addCriterion("order_.semester not in", values, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterBetween(Integer value1, Integer value2) {
            addCriterion("order_.semester between", value1, value2, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterNotBetween(Integer value1, Integer value2) {
            addCriterion("order_.semester not between", value1, value2, "semester");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_.order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_.order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_.order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_.order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_.order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_.order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_.order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_.order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_.order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_.order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_.order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_.order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNull() {
            addCriterion("order_.teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("order_.teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(Integer value) {
            addCriterion("order_.teacher_id =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(Integer value) {
            addCriterion("order_.teacher_id <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(Integer value) {
            addCriterion("order_.teacher_id >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_.teacher_id >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(Integer value) {
            addCriterion("order_.teacher_id <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_.teacher_id <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<Integer> values) {
            addCriterion("order_.teacher_id in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<Integer> values) {
            addCriterion("order_.teacher_id not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(Integer value1, Integer value2) {
            addCriterion("order_.teacher_id between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_.teacher_id not between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNull() {
            addCriterion("teacher.teacher_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNotNull() {
            addCriterion("teacher.teacher_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameEqualTo(String value) {
            addCriterion("teacher.teacher_name =", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotEqualTo(String value) {
            addCriterion("teacher.teacher_name <>", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThan(String value) {
            addCriterion("teacher.teacher_name >", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher.teacher_name >=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThan(String value) {
            addCriterion("teacher.teacher_name <", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("teacher.teacher_name <=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLike(String value) {
            addCriterion("teacher.teacher_name like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotLike(String value) {
            addCriterion("teacher.teacher_name not like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIn(List<String> values) {
            addCriterion("teacher.teacher_name in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotIn(List<String> values) {
            addCriterion("teacher.teacher_name not in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameBetween(String value1, String value2) {
            addCriterion("teacher.teacher_name between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotBetween(String value1, String value2) {
            addCriterion("teacher.teacher_name not between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNull() {
            addCriterion("teacher.employee_id is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNotNull() {
            addCriterion("teacher.employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdEqualTo(String value) {
            addCriterion("teacher.employee_id =", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotEqualTo(String value) {
            addCriterion("teacher.employee_id <>", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThan(String value) {
            addCriterion("teacher.employee_id >", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("teacher.employee_id >=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThan(String value) {
            addCriterion("teacher.employee_id <", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThanOrEqualTo(String value) {
            addCriterion("teacher.employee_id <=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLike(String value) {
            addCriterion("teacher.employee_id like", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotLike(String value) {
            addCriterion("teacher.employee_id not like", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIn(List<String> values) {
            addCriterion("teacher.employee_id in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotIn(List<String> values) {
            addCriterion("teacher.employee_id not in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdBetween(String value1, String value2) {
            addCriterion("teacher.employee_id between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotBetween(String value1, String value2) {
            addCriterion("teacher.employee_id not between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleIdIsNull() {
            addCriterion("teacher.teacher_title_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleIdIsNotNull() {
            addCriterion("teacher.teacher_title_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleIdEqualTo(Integer value) {
            addCriterion("teacher.teacher_title_id =", value, "teacherTitleId");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleIdNotEqualTo(Integer value) {
            addCriterion("teacher.teacher_title_id <>", value, "teacherTitleId");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleIdGreaterThan(Integer value) {
            addCriterion("teacher.teacher_title_id >", value, "teacherTitleId");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacher.teacher_title_id >=", value, "teacherTitleId");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleIdLessThan(Integer value) {
            addCriterion("teacher.teacher_title_id <", value, "teacherTitleId");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleIdLessThanOrEqualTo(Integer value) {
            addCriterion("teacher.teacher_title_id <=", value, "teacherTitleId");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleIdIn(List<Integer> values) {
            addCriterion("teacher.teacher_title_id in", values, "teacherTitleId");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleIdNotIn(List<Integer> values) {
            addCriterion("teacher.teacher_title_id not in", values, "teacherTitleId");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleIdBetween(Integer value1, Integer value2) {
            addCriterion("teacher.teacher_title_id between", value1, value2, "teacherTitleId");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("teacher.teacher_title_id not between", value1, value2, "teacherTitleId");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleNameIsNull() {
            addCriterion("teacher_title_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleNameIsNotNull() {
            addCriterion("teacher_title_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleNameEqualTo(String value) {
            addCriterion("teacher_title_name =", value, "teacherTitleName");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleNameNotEqualTo(String value) {
            addCriterion("teacher_title_name <>", value, "teacherTitleName");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleNameGreaterThan(String value) {
            addCriterion("teacher_title_name >", value, "teacherTitleName");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleNameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_title_name >=", value, "teacherTitleName");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleNameLessThan(String value) {
            addCriterion("teacher_title_name <", value, "teacherTitleName");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleNameLessThanOrEqualTo(String value) {
            addCriterion("teacher_title_name <=", value, "teacherTitleName");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleNameLike(String value) {
            addCriterion("teacher_title_name like", value, "teacherTitleName");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleNameNotLike(String value) {
            addCriterion("teacher_title_name not like", value, "teacherTitleName");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleNameIn(List<String> values) {
            addCriterion("teacher_title_name in", values, "teacherTitleName");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleNameNotIn(List<String> values) {
            addCriterion("teacher_title_name not in", values, "teacherTitleName");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleNameBetween(String value1, String value2) {
            addCriterion("teacher_title_name between", value1, value2, "teacherTitleName");
            return (Criteria) this;
        }

        public Criteria andTeacherTitleNameNotBetween(String value1, String value2) {
            addCriterion("teacher_title_name not between", value1, value2, "teacherTitleName");
            return (Criteria) this;
        }

        public Criteria andAuditIdIsNull() {
            addCriterion("grading_standard.audit_id is null");
            return (Criteria) this;
        }

        public Criteria andAuditIdIsNotNull() {
            addCriterion("grading_standard.audit_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuditIdEqualTo(Integer value) {
            addCriterion("grading_standard.audit_id =", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdNotEqualTo(Integer value) {
            addCriterion("grading_standard.audit_id <>", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdGreaterThan(Integer value) {
            addCriterion("grading_standard.audit_id >", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("grading_standard.audit_id >=", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdLessThan(Integer value) {
            addCriterion("grading_standard.audit_id <", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdLessThanOrEqualTo(Integer value) {
            addCriterion("grading_standard.audit_id <=", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdIn(List<Integer> values) {
            addCriterion("grading_standard.audit_id in", values, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdNotIn(List<Integer> values) {
            addCriterion("grading_standard.audit_id not in", values, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdBetween(Integer value1, Integer value2) {
            addCriterion("grading_standard.audit_id between", value1, value2, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdNotBetween(Integer value1, Integer value2) {
            addCriterion("grading_standard.audit_id not between", value1, value2, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditNameIsNull() {
            addCriterion("audit_name is null");
            return (Criteria) this;
        }

        public Criteria andAuditNameIsNotNull() {
            addCriterion("audit_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuditNameEqualTo(String value) {
            addCriterion("audit_name =", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameNotEqualTo(String value) {
            addCriterion("audit_name <>", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameGreaterThan(String value) {
            addCriterion("audit_name >", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameGreaterThanOrEqualTo(String value) {
            addCriterion("audit_name >=", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameLessThan(String value) {
            addCriterion("audit_name <", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameLessThanOrEqualTo(String value) {
            addCriterion("audit_name <=", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameLike(String value) {
            addCriterion("audit_name like", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameNotLike(String value) {
            addCriterion("audit_name not like", value, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameIn(List<String> values) {
            addCriterion("audit_name in", values, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameNotIn(List<String> values) {
            addCriterion("audit_name not in", values, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameBetween(String value1, String value2) {
            addCriterion("audit_name between", value1, value2, "auditName");
            return (Criteria) this;
        }

        public Criteria andAuditNameNotBetween(String value1, String value2) {
            addCriterion("audit_name not between", value1, value2, "auditName");
            return (Criteria) this;
        }

        public Criteria andSelfReportScoreIsNull() {
            addCriterion("self_report_score is null");
            return (Criteria) this;
        }

        public Criteria andSelfReportScoreIsNotNull() {
            addCriterion("self_report_score is not null");
            return (Criteria) this;
        }

        public Criteria andSelfReportScoreEqualTo(BigDecimal value) {
            addCriterion("self_report_score =", value, "selfReportScore");
            return (Criteria) this;
        }

        public Criteria andSelfReportScoreNotEqualTo(BigDecimal value) {
            addCriterion("self_report_score <>", value, "selfReportScore");
            return (Criteria) this;
        }

        public Criteria andSelfReportScoreGreaterThan(BigDecimal value) {
            addCriterion("self_report_score >", value, "selfReportScore");
            return (Criteria) this;
        }

        public Criteria andSelfReportScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("self_report_score >=", value, "selfReportScore");
            return (Criteria) this;
        }

        public Criteria andSelfReportScoreLessThan(BigDecimal value) {
            addCriterion("self_report_score <", value, "selfReportScore");
            return (Criteria) this;
        }

        public Criteria andSelfReportScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("self_report_score <=", value, "selfReportScore");
            return (Criteria) this;
        }

        public Criteria andSelfReportScoreIn(List<BigDecimal> values) {
            addCriterion("self_report_score in", values, "selfReportScore");
            return (Criteria) this;
        }

        public Criteria andSelfReportScoreNotIn(List<BigDecimal> values) {
            addCriterion("self_report_score not in", values, "selfReportScore");
            return (Criteria) this;
        }

        public Criteria andSelfReportScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("self_report_score between", value1, value2, "selfReportScore");
            return (Criteria) this;
        }

        public Criteria andSelfReportScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("self_report_score not between", value1, value2, "selfReportScore");
            return (Criteria) this;
        }

        public Criteria andCertifiedScoreIsNull() {
            addCriterion("certified_score is null");
            return (Criteria) this;
        }

        public Criteria andCertifiedScoreIsNotNull() {
            addCriterion("certified_score is not null");
            return (Criteria) this;
        }

        public Criteria andCertifiedScoreEqualTo(BigDecimal value) {
            addCriterion("certified_score =", value, "certifiedScore");
            return (Criteria) this;
        }

        public Criteria andCertifiedScoreNotEqualTo(BigDecimal value) {
            addCriterion("certified_score <>", value, "certifiedScore");
            return (Criteria) this;
        }

        public Criteria andCertifiedScoreGreaterThan(BigDecimal value) {
            addCriterion("certified_score >", value, "certifiedScore");
            return (Criteria) this;
        }

        public Criteria andCertifiedScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("certified_score >=", value, "certifiedScore");
            return (Criteria) this;
        }

        public Criteria andCertifiedScoreLessThan(BigDecimal value) {
            addCriterion("certified_score <", value, "certifiedScore");
            return (Criteria) this;
        }

        public Criteria andCertifiedScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("certified_score <=", value, "certifiedScore");
            return (Criteria) this;
        }

        public Criteria andCertifiedScoreIn(List<BigDecimal> values) {
            addCriterion("certified_score in", values, "certifiedScore");
            return (Criteria) this;
        }

        public Criteria andCertifiedScoreNotIn(List<BigDecimal> values) {
            addCriterion("certified_score not in", values, "certifiedScore");
            return (Criteria) this;
        }

        public Criteria andCertifiedScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("certified_score between", value1, value2, "certifiedScore");
            return (Criteria) this;
        }

        public Criteria andCertifiedScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("certified_score not between", value1, value2, "certifiedScore");
            return (Criteria) this;
        }

        public Criteria andCertifiedNoteIsNull() {
            addCriterion("certified_note is null");
            return (Criteria) this;
        }

        public Criteria andCertifiedNoteIsNotNull() {
            addCriterion("certified_note is not null");
            return (Criteria) this;
        }

        public Criteria andCertifiedNoteEqualTo(String value) {
            addCriterion("certified_note =", value, "certifiedNote");
            return (Criteria) this;
        }

        public Criteria andCertifiedNoteNotEqualTo(String value) {
            addCriterion("certified_note <>", value, "certifiedNote");
            return (Criteria) this;
        }

        public Criteria andCertifiedNoteGreaterThan(String value) {
            addCriterion("certified_note >", value, "certifiedNote");
            return (Criteria) this;
        }

        public Criteria andCertifiedNoteGreaterThanOrEqualTo(String value) {
            addCriterion("certified_note >=", value, "certifiedNote");
            return (Criteria) this;
        }

        public Criteria andCertifiedNoteLessThan(String value) {
            addCriterion("certified_note <", value, "certifiedNote");
            return (Criteria) this;
        }

        public Criteria andCertifiedNoteLessThanOrEqualTo(String value) {
            addCriterion("certified_note <=", value, "certifiedNote");
            return (Criteria) this;
        }

        public Criteria andCertifiedNoteLike(String value) {
            addCriterion("certified_note like", value, "certifiedNote");
            return (Criteria) this;
        }

        public Criteria andCertifiedNoteNotLike(String value) {
            addCriterion("certified_note not like", value, "certifiedNote");
            return (Criteria) this;
        }

        public Criteria andCertifiedNoteIn(List<String> values) {
            addCriterion("certified_note in", values, "certifiedNote");
            return (Criteria) this;
        }

        public Criteria andCertifiedNoteNotIn(List<String> values) {
            addCriterion("certified_note not in", values, "certifiedNote");
            return (Criteria) this;
        }

        public Criteria andCertifiedNoteBetween(String value1, String value2) {
            addCriterion("certified_note between", value1, value2, "certifiedNote");
            return (Criteria) this;
        }

        public Criteria andCertifiedNoteNotBetween(String value1, String value2) {
            addCriterion("certified_note not between", value1, value2, "certifiedNote");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andCertifiedTimeIsNull() {
            addCriterion("certified_time is null");
            return (Criteria) this;
        }

        public Criteria andCertifiedTimeIsNotNull() {
            addCriterion("certified_time is not null");
            return (Criteria) this;
        }

        public Criteria andCertifiedTimeEqualTo(Date value) {
            addCriterion("certified_time =", value, "certifiedTime");
            return (Criteria) this;
        }

        public Criteria andCertifiedTimeNotEqualTo(Date value) {
            addCriterion("certified_time <>", value, "certifiedTime");
            return (Criteria) this;
        }

        public Criteria andCertifiedTimeGreaterThan(Date value) {
            addCriterion("certified_time >", value, "certifiedTime");
            return (Criteria) this;
        }

        public Criteria andCertifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("certified_time >=", value, "certifiedTime");
            return (Criteria) this;
        }

        public Criteria andCertifiedTimeLessThan(Date value) {
            addCriterion("certified_time <", value, "certifiedTime");
            return (Criteria) this;
        }

        public Criteria andCertifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("certified_time <=", value, "certifiedTime");
            return (Criteria) this;
        }

        public Criteria andCertifiedTimeIn(List<Date> values) {
            addCriterion("certified_time in", values, "certifiedTime");
            return (Criteria) this;
        }

        public Criteria andCertifiedTimeNotIn(List<Date> values) {
            addCriterion("certified_time not in", values, "certifiedTime");
            return (Criteria) this;
        }

        public Criteria andCertifiedTimeBetween(Date value1, Date value2) {
            addCriterion("certified_time between", value1, value2, "certifiedTime");
            return (Criteria) this;
        }

        public Criteria andCertifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("certified_time not between", value1, value2, "certifiedTime");
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