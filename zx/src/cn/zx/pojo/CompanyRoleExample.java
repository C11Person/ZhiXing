package cn.zx.pojo;

import java.util.ArrayList;
import java.util.List;

public class CompanyRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyRoleExample() {
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

        public Criteria andUser_idIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(Integer value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(Integer value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(Integer value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<Integer> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andC_r_useridIsNull() {
            addCriterion("c_r_userid is null");
            return (Criteria) this;
        }

        public Criteria andC_r_useridIsNotNull() {
            addCriterion("c_r_userid is not null");
            return (Criteria) this;
        }

        public Criteria andC_r_useridEqualTo(String value) {
            addCriterion("c_r_userid =", value, "c_r_userid");
            return (Criteria) this;
        }

        public Criteria andC_r_useridNotEqualTo(String value) {
            addCriterion("c_r_userid <>", value, "c_r_userid");
            return (Criteria) this;
        }

        public Criteria andC_r_useridGreaterThan(String value) {
            addCriterion("c_r_userid >", value, "c_r_userid");
            return (Criteria) this;
        }

        public Criteria andC_r_useridGreaterThanOrEqualTo(String value) {
            addCriterion("c_r_userid >=", value, "c_r_userid");
            return (Criteria) this;
        }

        public Criteria andC_r_useridLessThan(String value) {
            addCriterion("c_r_userid <", value, "c_r_userid");
            return (Criteria) this;
        }

        public Criteria andC_r_useridLessThanOrEqualTo(String value) {
            addCriterion("c_r_userid <=", value, "c_r_userid");
            return (Criteria) this;
        }

        public Criteria andC_r_useridLike(String value) {
            addCriterion("c_r_userid like", value, "c_r_userid");
            return (Criteria) this;
        }

        public Criteria andC_r_useridNotLike(String value) {
            addCriterion("c_r_userid not like", value, "c_r_userid");
            return (Criteria) this;
        }

        public Criteria andC_r_useridIn(List<String> values) {
            addCriterion("c_r_userid in", values, "c_r_userid");
            return (Criteria) this;
        }

        public Criteria andC_r_useridNotIn(List<String> values) {
            addCriterion("c_r_userid not in", values, "c_r_userid");
            return (Criteria) this;
        }

        public Criteria andC_r_useridBetween(String value1, String value2) {
            addCriterion("c_r_userid between", value1, value2, "c_r_userid");
            return (Criteria) this;
        }

        public Criteria andC_r_useridNotBetween(String value1, String value2) {
            addCriterion("c_r_userid not between", value1, value2, "c_r_userid");
            return (Criteria) this;
        }

        public Criteria andC_r_passwordIsNull() {
            addCriterion("c_r_password is null");
            return (Criteria) this;
        }

        public Criteria andC_r_passwordIsNotNull() {
            addCriterion("c_r_password is not null");
            return (Criteria) this;
        }

        public Criteria andC_r_passwordEqualTo(String value) {
            addCriterion("c_r_password =", value, "c_r_password");
            return (Criteria) this;
        }

        public Criteria andC_r_passwordNotEqualTo(String value) {
            addCriterion("c_r_password <>", value, "c_r_password");
            return (Criteria) this;
        }

        public Criteria andC_r_passwordGreaterThan(String value) {
            addCriterion("c_r_password >", value, "c_r_password");
            return (Criteria) this;
        }

        public Criteria andC_r_passwordGreaterThanOrEqualTo(String value) {
            addCriterion("c_r_password >=", value, "c_r_password");
            return (Criteria) this;
        }

        public Criteria andC_r_passwordLessThan(String value) {
            addCriterion("c_r_password <", value, "c_r_password");
            return (Criteria) this;
        }

        public Criteria andC_r_passwordLessThanOrEqualTo(String value) {
            addCriterion("c_r_password <=", value, "c_r_password");
            return (Criteria) this;
        }

        public Criteria andC_r_passwordLike(String value) {
            addCriterion("c_r_password like", value, "c_r_password");
            return (Criteria) this;
        }

        public Criteria andC_r_passwordNotLike(String value) {
            addCriterion("c_r_password not like", value, "c_r_password");
            return (Criteria) this;
        }

        public Criteria andC_r_passwordIn(List<String> values) {
            addCriterion("c_r_password in", values, "c_r_password");
            return (Criteria) this;
        }

        public Criteria andC_r_passwordNotIn(List<String> values) {
            addCriterion("c_r_password not in", values, "c_r_password");
            return (Criteria) this;
        }

        public Criteria andC_r_passwordBetween(String value1, String value2) {
            addCriterion("c_r_password between", value1, value2, "c_r_password");
            return (Criteria) this;
        }

        public Criteria andC_r_passwordNotBetween(String value1, String value2) {
            addCriterion("c_r_password not between", value1, value2, "c_r_password");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRulesIsNull() {
            addCriterion("rules is null");
            return (Criteria) this;
        }

        public Criteria andRulesIsNotNull() {
            addCriterion("rules is not null");
            return (Criteria) this;
        }

        public Criteria andRulesEqualTo(String value) {
            addCriterion("rules =", value, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesNotEqualTo(String value) {
            addCriterion("rules <>", value, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesGreaterThan(String value) {
            addCriterion("rules >", value, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesGreaterThanOrEqualTo(String value) {
            addCriterion("rules >=", value, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesLessThan(String value) {
            addCriterion("rules <", value, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesLessThanOrEqualTo(String value) {
            addCriterion("rules <=", value, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesLike(String value) {
            addCriterion("rules like", value, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesNotLike(String value) {
            addCriterion("rules not like", value, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesIn(List<String> values) {
            addCriterion("rules in", values, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesNotIn(List<String> values) {
            addCriterion("rules not in", values, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesBetween(String value1, String value2) {
            addCriterion("rules between", value1, value2, "rules");
            return (Criteria) this;
        }

        public Criteria andRulesNotBetween(String value1, String value2) {
            addCriterion("rules not between", value1, value2, "rules");
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