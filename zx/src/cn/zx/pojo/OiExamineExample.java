package cn.zx.pojo;

import java.util.ArrayList;
import java.util.List;

public class OiExamineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OiExamineExample() {
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

        public Criteria andEx_idIsNull() {
            addCriterion("ex_id is null");
            return (Criteria) this;
        }

        public Criteria andEx_idIsNotNull() {
            addCriterion("ex_id is not null");
            return (Criteria) this;
        }

        public Criteria andEx_idEqualTo(Integer value) {
            addCriterion("ex_id =", value, "ex_id");
            return (Criteria) this;
        }

        public Criteria andEx_idNotEqualTo(Integer value) {
            addCriterion("ex_id <>", value, "ex_id");
            return (Criteria) this;
        }

        public Criteria andEx_idGreaterThan(Integer value) {
            addCriterion("ex_id >", value, "ex_id");
            return (Criteria) this;
        }

        public Criteria andEx_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("ex_id >=", value, "ex_id");
            return (Criteria) this;
        }

        public Criteria andEx_idLessThan(Integer value) {
            addCriterion("ex_id <", value, "ex_id");
            return (Criteria) this;
        }

        public Criteria andEx_idLessThanOrEqualTo(Integer value) {
            addCriterion("ex_id <=", value, "ex_id");
            return (Criteria) this;
        }

        public Criteria andEx_idIn(List<Integer> values) {
            addCriterion("ex_id in", values, "ex_id");
            return (Criteria) this;
        }

        public Criteria andEx_idNotIn(List<Integer> values) {
            addCriterion("ex_id not in", values, "ex_id");
            return (Criteria) this;
        }

        public Criteria andEx_idBetween(Integer value1, Integer value2) {
            addCriterion("ex_id between", value1, value2, "ex_id");
            return (Criteria) this;
        }

        public Criteria andEx_idNotBetween(Integer value1, Integer value2) {
            addCriterion("ex_id not between", value1, value2, "ex_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idIsNull() {
            addCriterion("license_id is null");
            return (Criteria) this;
        }

        public Criteria andLicense_idIsNotNull() {
            addCriterion("license_id is not null");
            return (Criteria) this;
        }

        public Criteria andLicense_idEqualTo(String value) {
            addCriterion("license_id =", value, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idNotEqualTo(String value) {
            addCriterion("license_id <>", value, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idGreaterThan(String value) {
            addCriterion("license_id >", value, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idGreaterThanOrEqualTo(String value) {
            addCriterion("license_id >=", value, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idLessThan(String value) {
            addCriterion("license_id <", value, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idLessThanOrEqualTo(String value) {
            addCriterion("license_id <=", value, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idLike(String value) {
            addCriterion("license_id like", value, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idNotLike(String value) {
            addCriterion("license_id not like", value, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idIn(List<String> values) {
            addCriterion("license_id in", values, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idNotIn(List<String> values) {
            addCriterion("license_id not in", values, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idBetween(String value1, String value2) {
            addCriterion("license_id between", value1, value2, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idNotBetween(String value1, String value2) {
            addCriterion("license_id not between", value1, value2, "license_id");
            return (Criteria) this;
        }

        public Criteria andUse_nameIsNull() {
            addCriterion("use_name is null");
            return (Criteria) this;
        }

        public Criteria andUse_nameIsNotNull() {
            addCriterion("use_name is not null");
            return (Criteria) this;
        }

        public Criteria andUse_nameEqualTo(String value) {
            addCriterion("use_name =", value, "use_name");
            return (Criteria) this;
        }

        public Criteria andUse_nameNotEqualTo(String value) {
            addCriterion("use_name <>", value, "use_name");
            return (Criteria) this;
        }

        public Criteria andUse_nameGreaterThan(String value) {
            addCriterion("use_name >", value, "use_name");
            return (Criteria) this;
        }

        public Criteria andUse_nameGreaterThanOrEqualTo(String value) {
            addCriterion("use_name >=", value, "use_name");
            return (Criteria) this;
        }

        public Criteria andUse_nameLessThan(String value) {
            addCriterion("use_name <", value, "use_name");
            return (Criteria) this;
        }

        public Criteria andUse_nameLessThanOrEqualTo(String value) {
            addCriterion("use_name <=", value, "use_name");
            return (Criteria) this;
        }

        public Criteria andUse_nameLike(String value) {
            addCriterion("use_name like", value, "use_name");
            return (Criteria) this;
        }

        public Criteria andUse_nameNotLike(String value) {
            addCriterion("use_name not like", value, "use_name");
            return (Criteria) this;
        }

        public Criteria andUse_nameIn(List<String> values) {
            addCriterion("use_name in", values, "use_name");
            return (Criteria) this;
        }

        public Criteria andUse_nameNotIn(List<String> values) {
            addCriterion("use_name not in", values, "use_name");
            return (Criteria) this;
        }

        public Criteria andUse_nameBetween(String value1, String value2) {
            addCriterion("use_name between", value1, value2, "use_name");
            return (Criteria) this;
        }

        public Criteria andUse_nameNotBetween(String value1, String value2) {
            addCriterion("use_name not between", value1, value2, "use_name");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(Integer value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(Integer value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(Integer value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(Integer value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(Integer value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<Integer> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<Integer> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(Integer value1, Integer value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(Integer value1, Integer value2) {
            addCriterion("phone not between", value1, value2, "phone");
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