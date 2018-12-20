package com.smxy.healthmedical.bean;

import java.util.ArrayList;
import java.util.List;

public class InfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InfoExample() {
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

        public Criteria andPinfoIdIsNull() {
            addCriterion("pinfo_id is null");
            return (Criteria) this;
        }

        public Criteria andPinfoIdIsNotNull() {
            addCriterion("pinfo_id is not null");
            return (Criteria) this;
        }

        public Criteria andPinfoIdEqualTo(Integer value) {
            addCriterion("pinfo_id =", value, "pinfoId");
            return (Criteria) this;
        }

        public Criteria andPinfoIdNotEqualTo(Integer value) {
            addCriterion("pinfo_id <>", value, "pinfoId");
            return (Criteria) this;
        }

        public Criteria andPinfoIdGreaterThan(Integer value) {
            addCriterion("pinfo_id >", value, "pinfoId");
            return (Criteria) this;
        }

        public Criteria andPinfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pinfo_id >=", value, "pinfoId");
            return (Criteria) this;
        }

        public Criteria andPinfoIdLessThan(Integer value) {
            addCriterion("pinfo_id <", value, "pinfoId");
            return (Criteria) this;
        }

        public Criteria andPinfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("pinfo_id <=", value, "pinfoId");
            return (Criteria) this;
        }

        public Criteria andPinfoIdIn(List<Integer> values) {
            addCriterion("pinfo_id in", values, "pinfoId");
            return (Criteria) this;
        }

        public Criteria andPinfoIdNotIn(List<Integer> values) {
            addCriterion("pinfo_id not in", values, "pinfoId");
            return (Criteria) this;
        }

        public Criteria andPinfoIdBetween(Integer value1, Integer value2) {
            addCriterion("pinfo_id between", value1, value2, "pinfoId");
            return (Criteria) this;
        }

        public Criteria andPinfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pinfo_id not between", value1, value2, "pinfoId");
            return (Criteria) this;
        }

        public Criteria andPinfoNameIsNull() {
            addCriterion("pinfo_name is null");
            return (Criteria) this;
        }

        public Criteria andPinfoNameIsNotNull() {
            addCriterion("pinfo_name is not null");
            return (Criteria) this;
        }

        public Criteria andPinfoNameEqualTo(String value) {
            addCriterion("pinfo_name =", value, "pinfoName");
            return (Criteria) this;
        }

        public Criteria andPinfoNameNotEqualTo(String value) {
            addCriterion("pinfo_name <>", value, "pinfoName");
            return (Criteria) this;
        }

        public Criteria andPinfoNameGreaterThan(String value) {
            addCriterion("pinfo_name >", value, "pinfoName");
            return (Criteria) this;
        }

        public Criteria andPinfoNameGreaterThanOrEqualTo(String value) {
            addCriterion("pinfo_name >=", value, "pinfoName");
            return (Criteria) this;
        }

        public Criteria andPinfoNameLessThan(String value) {
            addCriterion("pinfo_name <", value, "pinfoName");
            return (Criteria) this;
        }

        public Criteria andPinfoNameLessThanOrEqualTo(String value) {
            addCriterion("pinfo_name <=", value, "pinfoName");
            return (Criteria) this;
        }

        public Criteria andPinfoNameLike(String value) {
            addCriterion("pinfo_name like", value, "pinfoName");
            return (Criteria) this;
        }

        public Criteria andPinfoNameNotLike(String value) {
            addCriterion("pinfo_name not like", value, "pinfoName");
            return (Criteria) this;
        }

        public Criteria andPinfoNameIn(List<String> values) {
            addCriterion("pinfo_name in", values, "pinfoName");
            return (Criteria) this;
        }

        public Criteria andPinfoNameNotIn(List<String> values) {
            addCriterion("pinfo_name not in", values, "pinfoName");
            return (Criteria) this;
        }

        public Criteria andPinfoNameBetween(String value1, String value2) {
            addCriterion("pinfo_name between", value1, value2, "pinfoName");
            return (Criteria) this;
        }

        public Criteria andPinfoNameNotBetween(String value1, String value2) {
            addCriterion("pinfo_name not between", value1, value2, "pinfoName");
            return (Criteria) this;
        }

        public Criteria andPinfoGenderIsNull() {
            addCriterion("pinfo_gender is null");
            return (Criteria) this;
        }

        public Criteria andPinfoGenderIsNotNull() {
            addCriterion("pinfo_gender is not null");
            return (Criteria) this;
        }

        public Criteria andPinfoGenderEqualTo(String value) {
            addCriterion("pinfo_gender =", value, "pinfoGender");
            return (Criteria) this;
        }

        public Criteria andPinfoGenderNotEqualTo(String value) {
            addCriterion("pinfo_gender <>", value, "pinfoGender");
            return (Criteria) this;
        }

        public Criteria andPinfoGenderGreaterThan(String value) {
            addCriterion("pinfo_gender >", value, "pinfoGender");
            return (Criteria) this;
        }

        public Criteria andPinfoGenderGreaterThanOrEqualTo(String value) {
            addCriterion("pinfo_gender >=", value, "pinfoGender");
            return (Criteria) this;
        }

        public Criteria andPinfoGenderLessThan(String value) {
            addCriterion("pinfo_gender <", value, "pinfoGender");
            return (Criteria) this;
        }

        public Criteria andPinfoGenderLessThanOrEqualTo(String value) {
            addCriterion("pinfo_gender <=", value, "pinfoGender");
            return (Criteria) this;
        }

        public Criteria andPinfoGenderLike(String value) {
            addCriterion("pinfo_gender like", value, "pinfoGender");
            return (Criteria) this;
        }

        public Criteria andPinfoGenderNotLike(String value) {
            addCriterion("pinfo_gender not like", value, "pinfoGender");
            return (Criteria) this;
        }

        public Criteria andPinfoGenderIn(List<String> values) {
            addCriterion("pinfo_gender in", values, "pinfoGender");
            return (Criteria) this;
        }

        public Criteria andPinfoGenderNotIn(List<String> values) {
            addCriterion("pinfo_gender not in", values, "pinfoGender");
            return (Criteria) this;
        }

        public Criteria andPinfoGenderBetween(String value1, String value2) {
            addCriterion("pinfo_gender between", value1, value2, "pinfoGender");
            return (Criteria) this;
        }

        public Criteria andPinfoGenderNotBetween(String value1, String value2) {
            addCriterion("pinfo_gender not between", value1, value2, "pinfoGender");
            return (Criteria) this;
        }

        public Criteria andPpinfoIllnameIsNull() {
            addCriterion("ppinfo_illname is null");
            return (Criteria) this;
        }

        public Criteria andPpinfoIllnameIsNotNull() {
            addCriterion("ppinfo_illname is not null");
            return (Criteria) this;
        }

        public Criteria andPpinfoIllnameEqualTo(String value) {
            addCriterion("ppinfo_illname =", value, "ppinfoIllname");
            return (Criteria) this;
        }

        public Criteria andPpinfoIllnameNotEqualTo(String value) {
            addCriterion("ppinfo_illname <>", value, "ppinfoIllname");
            return (Criteria) this;
        }

        public Criteria andPpinfoIllnameGreaterThan(String value) {
            addCriterion("ppinfo_illname >", value, "ppinfoIllname");
            return (Criteria) this;
        }

        public Criteria andPpinfoIllnameGreaterThanOrEqualTo(String value) {
            addCriterion("ppinfo_illname >=", value, "ppinfoIllname");
            return (Criteria) this;
        }

        public Criteria andPpinfoIllnameLessThan(String value) {
            addCriterion("ppinfo_illname <", value, "ppinfoIllname");
            return (Criteria) this;
        }

        public Criteria andPpinfoIllnameLessThanOrEqualTo(String value) {
            addCriterion("ppinfo_illname <=", value, "ppinfoIllname");
            return (Criteria) this;
        }

        public Criteria andPpinfoIllnameLike(String value) {
            addCriterion("ppinfo_illname like", value, "ppinfoIllname");
            return (Criteria) this;
        }

        public Criteria andPpinfoIllnameNotLike(String value) {
            addCriterion("ppinfo_illname not like", value, "ppinfoIllname");
            return (Criteria) this;
        }

        public Criteria andPpinfoIllnameIn(List<String> values) {
            addCriterion("ppinfo_illname in", values, "ppinfoIllname");
            return (Criteria) this;
        }

        public Criteria andPpinfoIllnameNotIn(List<String> values) {
            addCriterion("ppinfo_illname not in", values, "ppinfoIllname");
            return (Criteria) this;
        }

        public Criteria andPpinfoIllnameBetween(String value1, String value2) {
            addCriterion("ppinfo_illname between", value1, value2, "ppinfoIllname");
            return (Criteria) this;
        }

        public Criteria andPpinfoIllnameNotBetween(String value1, String value2) {
            addCriterion("ppinfo_illname not between", value1, value2, "ppinfoIllname");
            return (Criteria) this;
        }

        public Criteria andPinfoInfoIsNull() {
            addCriterion("pinfo_info is null");
            return (Criteria) this;
        }

        public Criteria andPinfoInfoIsNotNull() {
            addCriterion("pinfo_info is not null");
            return (Criteria) this;
        }

        public Criteria andPinfoInfoEqualTo(String value) {
            addCriterion("pinfo_info =", value, "pinfoInfo");
            return (Criteria) this;
        }

        public Criteria andPinfoInfoNotEqualTo(String value) {
            addCriterion("pinfo_info <>", value, "pinfoInfo");
            return (Criteria) this;
        }

        public Criteria andPinfoInfoGreaterThan(String value) {
            addCriterion("pinfo_info >", value, "pinfoInfo");
            return (Criteria) this;
        }

        public Criteria andPinfoInfoGreaterThanOrEqualTo(String value) {
            addCriterion("pinfo_info >=", value, "pinfoInfo");
            return (Criteria) this;
        }

        public Criteria andPinfoInfoLessThan(String value) {
            addCriterion("pinfo_info <", value, "pinfoInfo");
            return (Criteria) this;
        }

        public Criteria andPinfoInfoLessThanOrEqualTo(String value) {
            addCriterion("pinfo_info <=", value, "pinfoInfo");
            return (Criteria) this;
        }

        public Criteria andPinfoInfoLike(String value) {
            addCriterion("pinfo_info like", value, "pinfoInfo");
            return (Criteria) this;
        }

        public Criteria andPinfoInfoNotLike(String value) {
            addCriterion("pinfo_info not like", value, "pinfoInfo");
            return (Criteria) this;
        }

        public Criteria andPinfoInfoIn(List<String> values) {
            addCriterion("pinfo_info in", values, "pinfoInfo");
            return (Criteria) this;
        }

        public Criteria andPinfoInfoNotIn(List<String> values) {
            addCriterion("pinfo_info not in", values, "pinfoInfo");
            return (Criteria) this;
        }

        public Criteria andPinfoInfoBetween(String value1, String value2) {
            addCriterion("pinfo_info between", value1, value2, "pinfoInfo");
            return (Criteria) this;
        }

        public Criteria andPinfoInfoNotBetween(String value1, String value2) {
            addCriterion("pinfo_info not between", value1, value2, "pinfoInfo");
            return (Criteria) this;
        }

        public Criteria andPiIdIsNull() {
            addCriterion("pi_id is null");
            return (Criteria) this;
        }

        public Criteria andPiIdIsNotNull() {
            addCriterion("pi_id is not null");
            return (Criteria) this;
        }

        public Criteria andPiIdEqualTo(Integer value) {
            addCriterion("pi_id =", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdNotEqualTo(Integer value) {
            addCriterion("pi_id <>", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdGreaterThan(Integer value) {
            addCriterion("pi_id >", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pi_id >=", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdLessThan(Integer value) {
            addCriterion("pi_id <", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdLessThanOrEqualTo(Integer value) {
            addCriterion("pi_id <=", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdIn(List<Integer> values) {
            addCriterion("pi_id in", values, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdNotIn(List<Integer> values) {
            addCriterion("pi_id not in", values, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdBetween(Integer value1, Integer value2) {
            addCriterion("pi_id between", value1, value2, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pi_id not between", value1, value2, "piId");
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