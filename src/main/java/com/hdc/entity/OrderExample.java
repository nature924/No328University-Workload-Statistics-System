package com.hdc.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public OrderExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNull() {
            addCriterion("teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(Integer value) {
            addCriterion("teacher_id =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(Integer value) {
            addCriterion("teacher_id <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(Integer value) {
            addCriterion("teacher_id >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacher_id >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(Integer value) {
            addCriterion("teacher_id <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(Integer value) {
            addCriterion("teacher_id <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<Integer> values) {
            addCriterion("teacher_id in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<Integer> values) {
            addCriterion("teacher_id not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id not between", value1, value2, "teacherId");
            return (Criteria) this;
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

        public Criteria andDeclarationNoteIsNull() {
            addCriterion("declaration_note is null");
            return (Criteria) this;
        }

        public Criteria andDeclarationNoteIsNotNull() {
            addCriterion("declaration_note is not null");
            return (Criteria) this;
        }

        public Criteria andDeclarationNoteEqualTo(String value) {
            addCriterion("declaration_note =", value, "declarationNote");
            return (Criteria) this;
        }

        public Criteria andDeclarationNoteNotEqualTo(String value) {
            addCriterion("declaration_note <>", value, "declarationNote");
            return (Criteria) this;
        }

        public Criteria andDeclarationNoteGreaterThan(String value) {
            addCriterion("declaration_note >", value, "declarationNote");
            return (Criteria) this;
        }

        public Criteria andDeclarationNoteGreaterThanOrEqualTo(String value) {
            addCriterion("declaration_note >=", value, "declarationNote");
            return (Criteria) this;
        }

        public Criteria andDeclarationNoteLessThan(String value) {
            addCriterion("declaration_note <", value, "declarationNote");
            return (Criteria) this;
        }

        public Criteria andDeclarationNoteLessThanOrEqualTo(String value) {
            addCriterion("declaration_note <=", value, "declarationNote");
            return (Criteria) this;
        }

        public Criteria andDeclarationNoteLike(String value) {
            addCriterion("declaration_note like", value, "declarationNote");
            return (Criteria) this;
        }

        public Criteria andDeclarationNoteNotLike(String value) {
            addCriterion("declaration_note not like", value, "declarationNote");
            return (Criteria) this;
        }

        public Criteria andDeclarationNoteIn(List<String> values) {
            addCriterion("declaration_note in", values, "declarationNote");
            return (Criteria) this;
        }

        public Criteria andDeclarationNoteNotIn(List<String> values) {
            addCriterion("declaration_note not in", values, "declarationNote");
            return (Criteria) this;
        }

        public Criteria andDeclarationNoteBetween(String value1, String value2) {
            addCriterion("declaration_note between", value1, value2, "declarationNote");
            return (Criteria) this;
        }

        public Criteria andDeclarationNoteNotBetween(String value1, String value2) {
            addCriterion("declaration_note not between", value1, value2, "declarationNote");
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