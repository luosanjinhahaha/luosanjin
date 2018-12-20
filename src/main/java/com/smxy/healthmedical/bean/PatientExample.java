package com.smxy.healthmedical.bean;

import java.util.ArrayList;
import java.util.List;

public class PatientExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PatientExample() {
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

        public Criteria andPatientIdIsNull() {
            addCriterion("patient_id is null");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNotNull() {
            addCriterion("patient_id is not null");
            return (Criteria) this;
        }

        public Criteria andPatientIdEqualTo(Integer value) {
            addCriterion("patient_id =", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotEqualTo(Integer value) {
            addCriterion("patient_id <>", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThan(Integer value) {
            addCriterion("patient_id >", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("patient_id >=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThan(Integer value) {
            addCriterion("patient_id <", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThanOrEqualTo(Integer value) {
            addCriterion("patient_id <=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdIn(List<Integer> values) {
            addCriterion("patient_id in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotIn(List<Integer> values) {
            addCriterion("patient_id not in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdBetween(Integer value1, Integer value2) {
            addCriterion("patient_id between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotBetween(Integer value1, Integer value2) {
            addCriterion("patient_id not between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientUsernameIsNull() {
            addCriterion("patient_username is null");
            return (Criteria) this;
        }

        public Criteria andPatientUsernameIsNotNull() {
            addCriterion("patient_username is not null");
            return (Criteria) this;
        }

        public Criteria andPatientUsernameEqualTo(String value) {
            addCriterion("patient_username =", value, "patientUsername");
            return (Criteria) this;
        }

        public Criteria andPatientUsernameNotEqualTo(String value) {
            addCriterion("patient_username <>", value, "patientUsername");
            return (Criteria) this;
        }

        public Criteria andPatientUsernameGreaterThan(String value) {
            addCriterion("patient_username >", value, "patientUsername");
            return (Criteria) this;
        }

        public Criteria andPatientUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("patient_username >=", value, "patientUsername");
            return (Criteria) this;
        }

        public Criteria andPatientUsernameLessThan(String value) {
            addCriterion("patient_username <", value, "patientUsername");
            return (Criteria) this;
        }

        public Criteria andPatientUsernameLessThanOrEqualTo(String value) {
            addCriterion("patient_username <=", value, "patientUsername");
            return (Criteria) this;
        }

        public Criteria andPatientUsernameLike(String value) {
            addCriterion("patient_username like", value, "patientUsername");
            return (Criteria) this;
        }

        public Criteria andPatientUsernameNotLike(String value) {
            addCriterion("patient_username not like", value, "patientUsername");
            return (Criteria) this;
        }

        public Criteria andPatientUsernameIn(List<String> values) {
            addCriterion("patient_username in", values, "patientUsername");
            return (Criteria) this;
        }

        public Criteria andPatientUsernameNotIn(List<String> values) {
            addCriterion("patient_username not in", values, "patientUsername");
            return (Criteria) this;
        }

        public Criteria andPatientUsernameBetween(String value1, String value2) {
            addCriterion("patient_username between", value1, value2, "patientUsername");
            return (Criteria) this;
        }

        public Criteria andPatientUsernameNotBetween(String value1, String value2) {
            addCriterion("patient_username not between", value1, value2, "patientUsername");
            return (Criteria) this;
        }

        public Criteria andPatientPasswordIsNull() {
            addCriterion("patient_password is null");
            return (Criteria) this;
        }

        public Criteria andPatientPasswordIsNotNull() {
            addCriterion("patient_password is not null");
            return (Criteria) this;
        }

        public Criteria andPatientPasswordEqualTo(String value) {
            addCriterion("patient_password =", value, "patientPassword");
            return (Criteria) this;
        }

        public Criteria andPatientPasswordNotEqualTo(String value) {
            addCriterion("patient_password <>", value, "patientPassword");
            return (Criteria) this;
        }

        public Criteria andPatientPasswordGreaterThan(String value) {
            addCriterion("patient_password >", value, "patientPassword");
            return (Criteria) this;
        }

        public Criteria andPatientPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("patient_password >=", value, "patientPassword");
            return (Criteria) this;
        }

        public Criteria andPatientPasswordLessThan(String value) {
            addCriterion("patient_password <", value, "patientPassword");
            return (Criteria) this;
        }

        public Criteria andPatientPasswordLessThanOrEqualTo(String value) {
            addCriterion("patient_password <=", value, "patientPassword");
            return (Criteria) this;
        }

        public Criteria andPatientPasswordLike(String value) {
            addCriterion("patient_password like", value, "patientPassword");
            return (Criteria) this;
        }

        public Criteria andPatientPasswordNotLike(String value) {
            addCriterion("patient_password not like", value, "patientPassword");
            return (Criteria) this;
        }

        public Criteria andPatientPasswordIn(List<String> values) {
            addCriterion("patient_password in", values, "patientPassword");
            return (Criteria) this;
        }

        public Criteria andPatientPasswordNotIn(List<String> values) {
            addCriterion("patient_password not in", values, "patientPassword");
            return (Criteria) this;
        }

        public Criteria andPatientPasswordBetween(String value1, String value2) {
            addCriterion("patient_password between", value1, value2, "patientPassword");
            return (Criteria) this;
        }

        public Criteria andPatientPasswordNotBetween(String value1, String value2) {
            addCriterion("patient_password not between", value1, value2, "patientPassword");
            return (Criteria) this;
        }

        public Criteria andPatientRepasswordIsNull() {
            addCriterion("patient_repassword is null");
            return (Criteria) this;
        }

        public Criteria andPatientRepasswordIsNotNull() {
            addCriterion("patient_repassword is not null");
            return (Criteria) this;
        }

        public Criteria andPatientRepasswordEqualTo(String value) {
            addCriterion("patient_repassword =", value, "patientRepassword");
            return (Criteria) this;
        }

        public Criteria andPatientRepasswordNotEqualTo(String value) {
            addCriterion("patient_repassword <>", value, "patientRepassword");
            return (Criteria) this;
        }

        public Criteria andPatientRepasswordGreaterThan(String value) {
            addCriterion("patient_repassword >", value, "patientRepassword");
            return (Criteria) this;
        }

        public Criteria andPatientRepasswordGreaterThanOrEqualTo(String value) {
            addCriterion("patient_repassword >=", value, "patientRepassword");
            return (Criteria) this;
        }

        public Criteria andPatientRepasswordLessThan(String value) {
            addCriterion("patient_repassword <", value, "patientRepassword");
            return (Criteria) this;
        }

        public Criteria andPatientRepasswordLessThanOrEqualTo(String value) {
            addCriterion("patient_repassword <=", value, "patientRepassword");
            return (Criteria) this;
        }

        public Criteria andPatientRepasswordLike(String value) {
            addCriterion("patient_repassword like", value, "patientRepassword");
            return (Criteria) this;
        }

        public Criteria andPatientRepasswordNotLike(String value) {
            addCriterion("patient_repassword not like", value, "patientRepassword");
            return (Criteria) this;
        }

        public Criteria andPatientRepasswordIn(List<String> values) {
            addCriterion("patient_repassword in", values, "patientRepassword");
            return (Criteria) this;
        }

        public Criteria andPatientRepasswordNotIn(List<String> values) {
            addCriterion("patient_repassword not in", values, "patientRepassword");
            return (Criteria) this;
        }

        public Criteria andPatientRepasswordBetween(String value1, String value2) {
            addCriterion("patient_repassword between", value1, value2, "patientRepassword");
            return (Criteria) this;
        }

        public Criteria andPatientRepasswordNotBetween(String value1, String value2) {
            addCriterion("patient_repassword not between", value1, value2, "patientRepassword");
            return (Criteria) this;
        }

        public Criteria andPatientGenderIsNull() {
            addCriterion("patient_gender is null");
            return (Criteria) this;
        }

        public Criteria andPatientGenderIsNotNull() {
            addCriterion("patient_gender is not null");
            return (Criteria) this;
        }

        public Criteria andPatientGenderEqualTo(String value) {
            addCriterion("patient_gender =", value, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderNotEqualTo(String value) {
            addCriterion("patient_gender <>", value, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderGreaterThan(String value) {
            addCriterion("patient_gender >", value, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderGreaterThanOrEqualTo(String value) {
            addCriterion("patient_gender >=", value, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderLessThan(String value) {
            addCriterion("patient_gender <", value, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderLessThanOrEqualTo(String value) {
            addCriterion("patient_gender <=", value, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderLike(String value) {
            addCriterion("patient_gender like", value, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderNotLike(String value) {
            addCriterion("patient_gender not like", value, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderIn(List<String> values) {
            addCriterion("patient_gender in", values, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderNotIn(List<String> values) {
            addCriterion("patient_gender not in", values, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderBetween(String value1, String value2) {
            addCriterion("patient_gender between", value1, value2, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientGenderNotBetween(String value1, String value2) {
            addCriterion("patient_gender not between", value1, value2, "patientGender");
            return (Criteria) this;
        }

        public Criteria andPatientPhoneIsNull() {
            addCriterion("patient_phone is null");
            return (Criteria) this;
        }

        public Criteria andPatientPhoneIsNotNull() {
            addCriterion("patient_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPatientPhoneEqualTo(String value) {
            addCriterion("patient_phone =", value, "patientPhone");
            return (Criteria) this;
        }

        public Criteria andPatientPhoneNotEqualTo(String value) {
            addCriterion("patient_phone <>", value, "patientPhone");
            return (Criteria) this;
        }

        public Criteria andPatientPhoneGreaterThan(String value) {
            addCriterion("patient_phone >", value, "patientPhone");
            return (Criteria) this;
        }

        public Criteria andPatientPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("patient_phone >=", value, "patientPhone");
            return (Criteria) this;
        }

        public Criteria andPatientPhoneLessThan(String value) {
            addCriterion("patient_phone <", value, "patientPhone");
            return (Criteria) this;
        }

        public Criteria andPatientPhoneLessThanOrEqualTo(String value) {
            addCriterion("patient_phone <=", value, "patientPhone");
            return (Criteria) this;
        }

        public Criteria andPatientPhoneLike(String value) {
            addCriterion("patient_phone like", value, "patientPhone");
            return (Criteria) this;
        }

        public Criteria andPatientPhoneNotLike(String value) {
            addCriterion("patient_phone not like", value, "patientPhone");
            return (Criteria) this;
        }

        public Criteria andPatientPhoneIn(List<String> values) {
            addCriterion("patient_phone in", values, "patientPhone");
            return (Criteria) this;
        }

        public Criteria andPatientPhoneNotIn(List<String> values) {
            addCriterion("patient_phone not in", values, "patientPhone");
            return (Criteria) this;
        }

        public Criteria andPatientPhoneBetween(String value1, String value2) {
            addCriterion("patient_phone between", value1, value2, "patientPhone");
            return (Criteria) this;
        }

        public Criteria andPatientPhoneNotBetween(String value1, String value2) {
            addCriterion("patient_phone not between", value1, value2, "patientPhone");
            return (Criteria) this;
        }

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
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