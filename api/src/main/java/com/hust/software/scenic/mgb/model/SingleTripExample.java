package com.hust.software.scenic.mgb.model;

import java.util.ArrayList;
import java.util.List;

public class SingleTripExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SingleTripExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMainTripIdIsNull() {
            addCriterion("main_trip_id is null");
            return (Criteria) this;
        }

        public Criteria andMainTripIdIsNotNull() {
            addCriterion("main_trip_id is not null");
            return (Criteria) this;
        }

        public Criteria andMainTripIdEqualTo(Integer value) {
            addCriterion("main_trip_id =", value, "mainTripId");
            return (Criteria) this;
        }

        public Criteria andMainTripIdNotEqualTo(Integer value) {
            addCriterion("main_trip_id <>", value, "mainTripId");
            return (Criteria) this;
        }

        public Criteria andMainTripIdGreaterThan(Integer value) {
            addCriterion("main_trip_id >", value, "mainTripId");
            return (Criteria) this;
        }

        public Criteria andMainTripIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("main_trip_id >=", value, "mainTripId");
            return (Criteria) this;
        }

        public Criteria andMainTripIdLessThan(Integer value) {
            addCriterion("main_trip_id <", value, "mainTripId");
            return (Criteria) this;
        }

        public Criteria andMainTripIdLessThanOrEqualTo(Integer value) {
            addCriterion("main_trip_id <=", value, "mainTripId");
            return (Criteria) this;
        }

        public Criteria andMainTripIdIn(List<Integer> values) {
            addCriterion("main_trip_id in", values, "mainTripId");
            return (Criteria) this;
        }

        public Criteria andMainTripIdNotIn(List<Integer> values) {
            addCriterion("main_trip_id not in", values, "mainTripId");
            return (Criteria) this;
        }

        public Criteria andMainTripIdBetween(Integer value1, Integer value2) {
            addCriterion("main_trip_id between", value1, value2, "mainTripId");
            return (Criteria) this;
        }

        public Criteria andMainTripIdNotBetween(Integer value1, Integer value2) {
            addCriterion("main_trip_id not between", value1, value2, "mainTripId");
            return (Criteria) this;
        }

        public Criteria andScenicOrderIsNull() {
            addCriterion("scenic_order is null");
            return (Criteria) this;
        }

        public Criteria andScenicOrderIsNotNull() {
            addCriterion("scenic_order is not null");
            return (Criteria) this;
        }

        public Criteria andScenicOrderEqualTo(String value) {
            addCriterion("scenic_order =", value, "scenicOrder");
            return (Criteria) this;
        }

        public Criteria andScenicOrderNotEqualTo(String value) {
            addCriterion("scenic_order <>", value, "scenicOrder");
            return (Criteria) this;
        }

        public Criteria andScenicOrderGreaterThan(String value) {
            addCriterion("scenic_order >", value, "scenicOrder");
            return (Criteria) this;
        }

        public Criteria andScenicOrderGreaterThanOrEqualTo(String value) {
            addCriterion("scenic_order >=", value, "scenicOrder");
            return (Criteria) this;
        }

        public Criteria andScenicOrderLessThan(String value) {
            addCriterion("scenic_order <", value, "scenicOrder");
            return (Criteria) this;
        }

        public Criteria andScenicOrderLessThanOrEqualTo(String value) {
            addCriterion("scenic_order <=", value, "scenicOrder");
            return (Criteria) this;
        }

        public Criteria andScenicOrderLike(String value) {
            addCriterion("scenic_order like", value, "scenicOrder");
            return (Criteria) this;
        }

        public Criteria andScenicOrderNotLike(String value) {
            addCriterion("scenic_order not like", value, "scenicOrder");
            return (Criteria) this;
        }

        public Criteria andScenicOrderIn(List<String> values) {
            addCriterion("scenic_order in", values, "scenicOrder");
            return (Criteria) this;
        }

        public Criteria andScenicOrderNotIn(List<String> values) {
            addCriterion("scenic_order not in", values, "scenicOrder");
            return (Criteria) this;
        }

        public Criteria andScenicOrderBetween(String value1, String value2) {
            addCriterion("scenic_order between", value1, value2, "scenicOrder");
            return (Criteria) this;
        }

        public Criteria andScenicOrderNotBetween(String value1, String value2) {
            addCriterion("scenic_order not between", value1, value2, "scenicOrder");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Boolean value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Boolean value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Boolean value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Boolean value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Boolean> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Boolean> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }
    }

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