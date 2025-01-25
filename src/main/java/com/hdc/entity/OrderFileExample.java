package com.hdc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public OrderFileExample() {
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

        public Criteria andOrderFileIdIsNull() {
            addCriterion("order_file_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderFileIdIsNotNull() {
            addCriterion("order_file_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFileIdEqualTo(Long value) {
            addCriterion("order_file_id =", value, "orderFileId");
            return (Criteria) this;
        }

        public Criteria andOrderFileIdNotEqualTo(Long value) {
            addCriterion("order_file_id <>", value, "orderFileId");
            return (Criteria) this;
        }

        public Criteria andOrderFileIdGreaterThan(Long value) {
            addCriterion("order_file_id >", value, "orderFileId");
            return (Criteria) this;
        }

        public Criteria andOrderFileIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_file_id >=", value, "orderFileId");
            return (Criteria) this;
        }

        public Criteria andOrderFileIdLessThan(Long value) {
            addCriterion("order_file_id <", value, "orderFileId");
            return (Criteria) this;
        }

        public Criteria andOrderFileIdLessThanOrEqualTo(Long value) {
            addCriterion("order_file_id <=", value, "orderFileId");
            return (Criteria) this;
        }

        public Criteria andOrderFileIdIn(List<Long> values) {
            addCriterion("order_file_id in", values, "orderFileId");
            return (Criteria) this;
        }

        public Criteria andOrderFileIdNotIn(List<Long> values) {
            addCriterion("order_file_id not in", values, "orderFileId");
            return (Criteria) this;
        }

        public Criteria andOrderFileIdBetween(Long value1, Long value2) {
            addCriterion("order_file_id between", value1, value2, "orderFileId");
            return (Criteria) this;
        }

        public Criteria andOrderFileIdNotBetween(Long value1, Long value2) {
            addCriterion("order_file_id not between", value1, value2, "orderFileId");
            return (Criteria) this;
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

        public Criteria andSaveFileNameIsNull() {
            addCriterion("save_file_name is null");
            return (Criteria) this;
        }

        public Criteria andSaveFileNameIsNotNull() {
            addCriterion("save_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andSaveFileNameEqualTo(String value) {
            addCriterion("save_file_name =", value, "saveFileName");
            return (Criteria) this;
        }

        public Criteria andSaveFileNameNotEqualTo(String value) {
            addCriterion("save_file_name <>", value, "saveFileName");
            return (Criteria) this;
        }

        public Criteria andSaveFileNameGreaterThan(String value) {
            addCriterion("save_file_name >", value, "saveFileName");
            return (Criteria) this;
        }

        public Criteria andSaveFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("save_file_name >=", value, "saveFileName");
            return (Criteria) this;
        }

        public Criteria andSaveFileNameLessThan(String value) {
            addCriterion("save_file_name <", value, "saveFileName");
            return (Criteria) this;
        }

        public Criteria andSaveFileNameLessThanOrEqualTo(String value) {
            addCriterion("save_file_name <=", value, "saveFileName");
            return (Criteria) this;
        }

        public Criteria andSaveFileNameLike(String value) {
            addCriterion("save_file_name like", value, "saveFileName");
            return (Criteria) this;
        }

        public Criteria andSaveFileNameNotLike(String value) {
            addCriterion("save_file_name not like", value, "saveFileName");
            return (Criteria) this;
        }

        public Criteria andSaveFileNameIn(List<String> values) {
            addCriterion("save_file_name in", values, "saveFileName");
            return (Criteria) this;
        }

        public Criteria andSaveFileNameNotIn(List<String> values) {
            addCriterion("save_file_name not in", values, "saveFileName");
            return (Criteria) this;
        }

        public Criteria andSaveFileNameBetween(String value1, String value2) {
            addCriterion("save_file_name between", value1, value2, "saveFileName");
            return (Criteria) this;
        }

        public Criteria andSaveFileNameNotBetween(String value1, String value2) {
            addCriterion("save_file_name not between", value1, value2, "saveFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameIsNull() {
            addCriterion("origin_file_name is null");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameIsNotNull() {
            addCriterion("origin_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameEqualTo(String value) {
            addCriterion("origin_file_name =", value, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameNotEqualTo(String value) {
            addCriterion("origin_file_name <>", value, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameGreaterThan(String value) {
            addCriterion("origin_file_name >", value, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("origin_file_name >=", value, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameLessThan(String value) {
            addCriterion("origin_file_name <", value, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameLessThanOrEqualTo(String value) {
            addCriterion("origin_file_name <=", value, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameLike(String value) {
            addCriterion("origin_file_name like", value, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameNotLike(String value) {
            addCriterion("origin_file_name not like", value, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameIn(List<String> values) {
            addCriterion("origin_file_name in", values, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameNotIn(List<String> values) {
            addCriterion("origin_file_name not in", values, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameBetween(String value1, String value2) {
            addCriterion("origin_file_name between", value1, value2, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameNotBetween(String value1, String value2) {
            addCriterion("origin_file_name not between", value1, value2, "originFileName");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(Long value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(Long value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(Long value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(Long value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(Long value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<Long> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<Long> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(Long value1, Long value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(Long value1, Long value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andFileUrlIsNull() {
            addCriterion("file_url is null");
            return (Criteria) this;
        }

        public Criteria andFileUrlIsNotNull() {
            addCriterion("file_url is not null");
            return (Criteria) this;
        }

        public Criteria andFileUrlEqualTo(String value) {
            addCriterion("file_url =", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotEqualTo(String value) {
            addCriterion("file_url <>", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlGreaterThan(String value) {
            addCriterion("file_url >", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("file_url >=", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLessThan(String value) {
            addCriterion("file_url <", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLessThanOrEqualTo(String value) {
            addCriterion("file_url <=", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLike(String value) {
            addCriterion("file_url like", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotLike(String value) {
            addCriterion("file_url not like", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlIn(List<String> values) {
            addCriterion("file_url in", values, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotIn(List<String> values) {
            addCriterion("file_url not in", values, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlBetween(String value1, String value2) {
            addCriterion("file_url between", value1, value2, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotBetween(String value1, String value2) {
            addCriterion("file_url not between", value1, value2, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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