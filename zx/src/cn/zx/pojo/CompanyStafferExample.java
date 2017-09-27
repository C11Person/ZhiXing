package cn.zx.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyStafferExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyStafferExample() {
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

        public Criteria andCompany_idIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompany_idIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompany_idEqualTo(Integer value) {
            addCriterion("company_id =", value, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idGreaterThan(Integer value) {
            addCriterion("company_id >", value, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idLessThan(Integer value) {
            addCriterion("company_id <", value, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idIn(List<Integer> values) {
            addCriterion("company_id in", values, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "company_id");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andSf_passwordIsNull() {
            addCriterion("sf_password is null");
            return (Criteria) this;
        }

        public Criteria andSf_passwordIsNotNull() {
            addCriterion("sf_password is not null");
            return (Criteria) this;
        }

        public Criteria andSf_passwordEqualTo(String value) {
            addCriterion("sf_password =", value, "sf_password");
            return (Criteria) this;
        }

        public Criteria andSf_passwordNotEqualTo(String value) {
            addCriterion("sf_password <>", value, "sf_password");
            return (Criteria) this;
        }

        public Criteria andSf_passwordGreaterThan(String value) {
            addCriterion("sf_password >", value, "sf_password");
            return (Criteria) this;
        }

        public Criteria andSf_passwordGreaterThanOrEqualTo(String value) {
            addCriterion("sf_password >=", value, "sf_password");
            return (Criteria) this;
        }

        public Criteria andSf_passwordLessThan(String value) {
            addCriterion("sf_password <", value, "sf_password");
            return (Criteria) this;
        }

        public Criteria andSf_passwordLessThanOrEqualTo(String value) {
            addCriterion("sf_password <=", value, "sf_password");
            return (Criteria) this;
        }

        public Criteria andSf_passwordLike(String value) {
            addCriterion("sf_password like", value, "sf_password");
            return (Criteria) this;
        }

        public Criteria andSf_passwordNotLike(String value) {
            addCriterion("sf_password not like", value, "sf_password");
            return (Criteria) this;
        }

        public Criteria andSf_passwordIn(List<String> values) {
            addCriterion("sf_password in", values, "sf_password");
            return (Criteria) this;
        }

        public Criteria andSf_passwordNotIn(List<String> values) {
            addCriterion("sf_password not in", values, "sf_password");
            return (Criteria) this;
        }

        public Criteria andSf_passwordBetween(String value1, String value2) {
            addCriterion("sf_password between", value1, value2, "sf_password");
            return (Criteria) this;
        }

        public Criteria andSf_passwordNotBetween(String value1, String value2) {
            addCriterion("sf_password not between", value1, value2, "sf_password");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("realname is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("realname is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("realname =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("realname <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("realname >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("realname >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("realname <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("realname <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("realname like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("realname not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("realname in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("realname not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("realname between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("realname not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andFaceIsNull() {
            addCriterion("face is null");
            return (Criteria) this;
        }

        public Criteria andFaceIsNotNull() {
            addCriterion("face is not null");
            return (Criteria) this;
        }

        public Criteria andFaceEqualTo(String value) {
            addCriterion("face =", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceNotEqualTo(String value) {
            addCriterion("face <>", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceGreaterThan(String value) {
            addCriterion("face >", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceGreaterThanOrEqualTo(String value) {
            addCriterion("face >=", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceLessThan(String value) {
            addCriterion("face <", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceLessThanOrEqualTo(String value) {
            addCriterion("face <=", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceLike(String value) {
            addCriterion("face like", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceNotLike(String value) {
            addCriterion("face not like", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceIn(List<String> values) {
            addCriterion("face in", values, "face");
            return (Criteria) this;
        }

        public Criteria andFaceNotIn(List<String> values) {
            addCriterion("face not in", values, "face");
            return (Criteria) this;
        }

        public Criteria andFaceBetween(String value1, String value2) {
            addCriterion("face between", value1, value2, "face");
            return (Criteria) this;
        }

        public Criteria andFaceNotBetween(String value1, String value2) {
            addCriterion("face not between", value1, value2, "face");
            return (Criteria) this;
        }

        public Criteria andExt0IsNull() {
            addCriterion("ext0 is null");
            return (Criteria) this;
        }

        public Criteria andExt0IsNotNull() {
            addCriterion("ext0 is not null");
            return (Criteria) this;
        }

        public Criteria andExt0EqualTo(String value) {
            addCriterion("ext0 =", value, "ext0");
            return (Criteria) this;
        }

        public Criteria andExt0NotEqualTo(String value) {
            addCriterion("ext0 <>", value, "ext0");
            return (Criteria) this;
        }

        public Criteria andExt0GreaterThan(String value) {
            addCriterion("ext0 >", value, "ext0");
            return (Criteria) this;
        }

        public Criteria andExt0GreaterThanOrEqualTo(String value) {
            addCriterion("ext0 >=", value, "ext0");
            return (Criteria) this;
        }

        public Criteria andExt0LessThan(String value) {
            addCriterion("ext0 <", value, "ext0");
            return (Criteria) this;
        }

        public Criteria andExt0LessThanOrEqualTo(String value) {
            addCriterion("ext0 <=", value, "ext0");
            return (Criteria) this;
        }

        public Criteria andExt0Like(String value) {
            addCriterion("ext0 like", value, "ext0");
            return (Criteria) this;
        }

        public Criteria andExt0NotLike(String value) {
            addCriterion("ext0 not like", value, "ext0");
            return (Criteria) this;
        }

        public Criteria andExt0In(List<String> values) {
            addCriterion("ext0 in", values, "ext0");
            return (Criteria) this;
        }

        public Criteria andExt0NotIn(List<String> values) {
            addCriterion("ext0 not in", values, "ext0");
            return (Criteria) this;
        }

        public Criteria andExt0Between(String value1, String value2) {
            addCriterion("ext0 between", value1, value2, "ext0");
            return (Criteria) this;
        }

        public Criteria andExt0NotBetween(String value1, String value2) {
            addCriterion("ext0 not between", value1, value2, "ext0");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andReg_timeIsNull() {
            addCriterion("reg_time is null");
            return (Criteria) this;
        }

        public Criteria andReg_timeIsNotNull() {
            addCriterion("reg_time is not null");
            return (Criteria) this;
        }

        public Criteria andReg_timeEqualTo(Date value) {
            addCriterion("reg_time =", value, "reg_time");
            return (Criteria) this;
        }

        public Criteria andReg_timeNotEqualTo(Date value) {
            addCriterion("reg_time <>", value, "reg_time");
            return (Criteria) this;
        }

        public Criteria andReg_timeGreaterThan(Date value) {
            addCriterion("reg_time >", value, "reg_time");
            return (Criteria) this;
        }

        public Criteria andReg_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("reg_time >=", value, "reg_time");
            return (Criteria) this;
        }

        public Criteria andReg_timeLessThan(Date value) {
            addCriterion("reg_time <", value, "reg_time");
            return (Criteria) this;
        }

        public Criteria andReg_timeLessThanOrEqualTo(Date value) {
            addCriterion("reg_time <=", value, "reg_time");
            return (Criteria) this;
        }

        public Criteria andReg_timeIn(List<Date> values) {
            addCriterion("reg_time in", values, "reg_time");
            return (Criteria) this;
        }

        public Criteria andReg_timeNotIn(List<Date> values) {
            addCriterion("reg_time not in", values, "reg_time");
            return (Criteria) this;
        }

        public Criteria andReg_timeBetween(Date value1, Date value2) {
            addCriterion("reg_time between", value1, value2, "reg_time");
            return (Criteria) this;
        }

        public Criteria andReg_timeNotBetween(Date value1, Date value2) {
            addCriterion("reg_time not between", value1, value2, "reg_time");
            return (Criteria) this;
        }

        public Criteria andIn_timeIsNull() {
            addCriterion("in_time is null");
            return (Criteria) this;
        }

        public Criteria andIn_timeIsNotNull() {
            addCriterion("in_time is not null");
            return (Criteria) this;
        }

        public Criteria andIn_timeEqualTo(Date value) {
            addCriterion("in_time =", value, "in_time");
            return (Criteria) this;
        }

        public Criteria andIn_timeNotEqualTo(Date value) {
            addCriterion("in_time <>", value, "in_time");
            return (Criteria) this;
        }

        public Criteria andIn_timeGreaterThan(Date value) {
            addCriterion("in_time >", value, "in_time");
            return (Criteria) this;
        }

        public Criteria andIn_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("in_time >=", value, "in_time");
            return (Criteria) this;
        }

        public Criteria andIn_timeLessThan(Date value) {
            addCriterion("in_time <", value, "in_time");
            return (Criteria) this;
        }

        public Criteria andIn_timeLessThanOrEqualTo(Date value) {
            addCriterion("in_time <=", value, "in_time");
            return (Criteria) this;
        }

        public Criteria andIn_timeIn(List<Date> values) {
            addCriterion("in_time in", values, "in_time");
            return (Criteria) this;
        }

        public Criteria andIn_timeNotIn(List<Date> values) {
            addCriterion("in_time not in", values, "in_time");
            return (Criteria) this;
        }

        public Criteria andIn_timeBetween(Date value1, Date value2) {
            addCriterion("in_time between", value1, value2, "in_time");
            return (Criteria) this;
        }

        public Criteria andIn_timeNotBetween(Date value1, Date value2) {
            addCriterion("in_time not between", value1, value2, "in_time");
            return (Criteria) this;
        }

        public Criteria andReg_ipIsNull() {
            addCriterion("reg_ip is null");
            return (Criteria) this;
        }

        public Criteria andReg_ipIsNotNull() {
            addCriterion("reg_ip is not null");
            return (Criteria) this;
        }

        public Criteria andReg_ipEqualTo(String value) {
            addCriterion("reg_ip =", value, "reg_ip");
            return (Criteria) this;
        }

        public Criteria andReg_ipNotEqualTo(String value) {
            addCriterion("reg_ip <>", value, "reg_ip");
            return (Criteria) this;
        }

        public Criteria andReg_ipGreaterThan(String value) {
            addCriterion("reg_ip >", value, "reg_ip");
            return (Criteria) this;
        }

        public Criteria andReg_ipGreaterThanOrEqualTo(String value) {
            addCriterion("reg_ip >=", value, "reg_ip");
            return (Criteria) this;
        }

        public Criteria andReg_ipLessThan(String value) {
            addCriterion("reg_ip <", value, "reg_ip");
            return (Criteria) this;
        }

        public Criteria andReg_ipLessThanOrEqualTo(String value) {
            addCriterion("reg_ip <=", value, "reg_ip");
            return (Criteria) this;
        }

        public Criteria andReg_ipLike(String value) {
            addCriterion("reg_ip like", value, "reg_ip");
            return (Criteria) this;
        }

        public Criteria andReg_ipNotLike(String value) {
            addCriterion("reg_ip not like", value, "reg_ip");
            return (Criteria) this;
        }

        public Criteria andReg_ipIn(List<String> values) {
            addCriterion("reg_ip in", values, "reg_ip");
            return (Criteria) this;
        }

        public Criteria andReg_ipNotIn(List<String> values) {
            addCriterion("reg_ip not in", values, "reg_ip");
            return (Criteria) this;
        }

        public Criteria andReg_ipBetween(String value1, String value2) {
            addCriterion("reg_ip between", value1, value2, "reg_ip");
            return (Criteria) this;
        }

        public Criteria andReg_ipNotBetween(String value1, String value2) {
            addCriterion("reg_ip not between", value1, value2, "reg_ip");
            return (Criteria) this;
        }

        public Criteria andLast_timeIsNull() {
            addCriterion("last_time is null");
            return (Criteria) this;
        }

        public Criteria andLast_timeIsNotNull() {
            addCriterion("last_time is not null");
            return (Criteria) this;
        }

        public Criteria andLast_timeEqualTo(Date value) {
            addCriterion("last_time =", value, "last_time");
            return (Criteria) this;
        }

        public Criteria andLast_timeNotEqualTo(Date value) {
            addCriterion("last_time <>", value, "last_time");
            return (Criteria) this;
        }

        public Criteria andLast_timeGreaterThan(Date value) {
            addCriterion("last_time >", value, "last_time");
            return (Criteria) this;
        }

        public Criteria andLast_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_time >=", value, "last_time");
            return (Criteria) this;
        }

        public Criteria andLast_timeLessThan(Date value) {
            addCriterion("last_time <", value, "last_time");
            return (Criteria) this;
        }

        public Criteria andLast_timeLessThanOrEqualTo(Date value) {
            addCriterion("last_time <=", value, "last_time");
            return (Criteria) this;
        }

        public Criteria andLast_timeIn(List<Date> values) {
            addCriterion("last_time in", values, "last_time");
            return (Criteria) this;
        }

        public Criteria andLast_timeNotIn(List<Date> values) {
            addCriterion("last_time not in", values, "last_time");
            return (Criteria) this;
        }

        public Criteria andLast_timeBetween(Date value1, Date value2) {
            addCriterion("last_time between", value1, value2, "last_time");
            return (Criteria) this;
        }

        public Criteria andLast_timeNotBetween(Date value1, Date value2) {
            addCriterion("last_time not between", value1, value2, "last_time");
            return (Criteria) this;
        }

        public Criteria andLast_ipIsNull() {
            addCriterion("last_ip is null");
            return (Criteria) this;
        }

        public Criteria andLast_ipIsNotNull() {
            addCriterion("last_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLast_ipEqualTo(String value) {
            addCriterion("last_ip =", value, "last_ip");
            return (Criteria) this;
        }

        public Criteria andLast_ipNotEqualTo(String value) {
            addCriterion("last_ip <>", value, "last_ip");
            return (Criteria) this;
        }

        public Criteria andLast_ipGreaterThan(String value) {
            addCriterion("last_ip >", value, "last_ip");
            return (Criteria) this;
        }

        public Criteria andLast_ipGreaterThanOrEqualTo(String value) {
            addCriterion("last_ip >=", value, "last_ip");
            return (Criteria) this;
        }

        public Criteria andLast_ipLessThan(String value) {
            addCriterion("last_ip <", value, "last_ip");
            return (Criteria) this;
        }

        public Criteria andLast_ipLessThanOrEqualTo(String value) {
            addCriterion("last_ip <=", value, "last_ip");
            return (Criteria) this;
        }

        public Criteria andLast_ipLike(String value) {
            addCriterion("last_ip like", value, "last_ip");
            return (Criteria) this;
        }

        public Criteria andLast_ipNotLike(String value) {
            addCriterion("last_ip not like", value, "last_ip");
            return (Criteria) this;
        }

        public Criteria andLast_ipIn(List<String> values) {
            addCriterion("last_ip in", values, "last_ip");
            return (Criteria) this;
        }

        public Criteria andLast_ipNotIn(List<String> values) {
            addCriterion("last_ip not in", values, "last_ip");
            return (Criteria) this;
        }

        public Criteria andLast_ipBetween(String value1, String value2) {
            addCriterion("last_ip between", value1, value2, "last_ip");
            return (Criteria) this;
        }

        public Criteria andLast_ipNotBetween(String value1, String value2) {
            addCriterion("last_ip not between", value1, value2, "last_ip");
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

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
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

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPostIsNull() {
            addCriterion("post is null");
            return (Criteria) this;
        }

        public Criteria andPostIsNotNull() {
            addCriterion("post is not null");
            return (Criteria) this;
        }

        public Criteria andPostEqualTo(Integer value) {
            addCriterion("post =", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotEqualTo(Integer value) {
            addCriterion("post <>", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostGreaterThan(Integer value) {
            addCriterion("post >", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostGreaterThanOrEqualTo(Integer value) {
            addCriterion("post >=", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostLessThan(Integer value) {
            addCriterion("post <", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostLessThanOrEqualTo(Integer value) {
            addCriterion("post <=", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostIn(List<Integer> values) {
            addCriterion("post in", values, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotIn(List<Integer> values) {
            addCriterion("post not in", values, "post");
            return (Criteria) this;
        }

        public Criteria andPostBetween(Integer value1, Integer value2) {
            addCriterion("post between", value1, value2, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotBetween(Integer value1, Integer value2) {
            addCriterion("post not between", value1, value2, "post");
            return (Criteria) this;
        }

        public Criteria andDepartIsNull() {
            addCriterion("depart is null");
            return (Criteria) this;
        }

        public Criteria andDepartIsNotNull() {
            addCriterion("depart is not null");
            return (Criteria) this;
        }

        public Criteria andDepartEqualTo(Integer value) {
            addCriterion("depart =", value, "depart");
            return (Criteria) this;
        }

        public Criteria andDepartNotEqualTo(Integer value) {
            addCriterion("depart <>", value, "depart");
            return (Criteria) this;
        }

        public Criteria andDepartGreaterThan(Integer value) {
            addCriterion("depart >", value, "depart");
            return (Criteria) this;
        }

        public Criteria andDepartGreaterThanOrEqualTo(Integer value) {
            addCriterion("depart >=", value, "depart");
            return (Criteria) this;
        }

        public Criteria andDepartLessThan(Integer value) {
            addCriterion("depart <", value, "depart");
            return (Criteria) this;
        }

        public Criteria andDepartLessThanOrEqualTo(Integer value) {
            addCriterion("depart <=", value, "depart");
            return (Criteria) this;
        }

        public Criteria andDepartIn(List<Integer> values) {
            addCriterion("depart in", values, "depart");
            return (Criteria) this;
        }

        public Criteria andDepartNotIn(List<Integer> values) {
            addCriterion("depart not in", values, "depart");
            return (Criteria) this;
        }

        public Criteria andDepartBetween(Integer value1, Integer value2) {
            addCriterion("depart between", value1, value2, "depart");
            return (Criteria) this;
        }

        public Criteria andDepartNotBetween(Integer value1, Integer value2) {
            addCriterion("depart not between", value1, value2, "depart");
            return (Criteria) this;
        }

        public Criteria andPostlevelIsNull() {
            addCriterion("postlevel is null");
            return (Criteria) this;
        }

        public Criteria andPostlevelIsNotNull() {
            addCriterion("postlevel is not null");
            return (Criteria) this;
        }

        public Criteria andPostlevelEqualTo(Integer value) {
            addCriterion("postlevel =", value, "postlevel");
            return (Criteria) this;
        }

        public Criteria andPostlevelNotEqualTo(Integer value) {
            addCriterion("postlevel <>", value, "postlevel");
            return (Criteria) this;
        }

        public Criteria andPostlevelGreaterThan(Integer value) {
            addCriterion("postlevel >", value, "postlevel");
            return (Criteria) this;
        }

        public Criteria andPostlevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("postlevel >=", value, "postlevel");
            return (Criteria) this;
        }

        public Criteria andPostlevelLessThan(Integer value) {
            addCriterion("postlevel <", value, "postlevel");
            return (Criteria) this;
        }

        public Criteria andPostlevelLessThanOrEqualTo(Integer value) {
            addCriterion("postlevel <=", value, "postlevel");
            return (Criteria) this;
        }

        public Criteria andPostlevelIn(List<Integer> values) {
            addCriterion("postlevel in", values, "postlevel");
            return (Criteria) this;
        }

        public Criteria andPostlevelNotIn(List<Integer> values) {
            addCriterion("postlevel not in", values, "postlevel");
            return (Criteria) this;
        }

        public Criteria andPostlevelBetween(Integer value1, Integer value2) {
            addCriterion("postlevel between", value1, value2, "postlevel");
            return (Criteria) this;
        }

        public Criteria andPostlevelNotBetween(Integer value1, Integer value2) {
            addCriterion("postlevel not between", value1, value2, "postlevel");
            return (Criteria) this;
        }

        public Criteria andAuditIsNull() {
            addCriterion("audit is null");
            return (Criteria) this;
        }

        public Criteria andAuditIsNotNull() {
            addCriterion("audit is not null");
            return (Criteria) this;
        }

        public Criteria andAuditEqualTo(Integer value) {
            addCriterion("audit =", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotEqualTo(Integer value) {
            addCriterion("audit <>", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditGreaterThan(Integer value) {
            addCriterion("audit >", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit >=", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditLessThan(Integer value) {
            addCriterion("audit <", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditLessThanOrEqualTo(Integer value) {
            addCriterion("audit <=", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditIn(List<Integer> values) {
            addCriterion("audit in", values, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotIn(List<Integer> values) {
            addCriterion("audit not in", values, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditBetween(Integer value1, Integer value2) {
            addCriterion("audit between", value1, value2, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotBetween(Integer value1, Integer value2) {
            addCriterion("audit not between", value1, value2, "audit");
            return (Criteria) this;
        }

        public Criteria andOpen_idIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpen_idIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpen_idEqualTo(String value) {
            addCriterion("open_id =", value, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpen_idNotEqualTo(String value) {
            addCriterion("open_id <>", value, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpen_idGreaterThan(String value) {
            addCriterion("open_id >", value, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpen_idGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpen_idLessThan(String value) {
            addCriterion("open_id <", value, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpen_idLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpen_idLike(String value) {
            addCriterion("open_id like", value, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpen_idNotLike(String value) {
            addCriterion("open_id not like", value, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpen_idIn(List<String> values) {
            addCriterion("open_id in", values, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpen_idNotIn(List<String> values) {
            addCriterion("open_id not in", values, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpen_idBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "open_id");
            return (Criteria) this;
        }

        public Criteria andOpen_idNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "open_id");
            return (Criteria) this;
        }

        public Criteria andTokenIsNull() {
            addCriterion("token is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("token is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("token =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("token <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("token >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("token >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("token <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("token <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("token like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("token not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("token in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("token not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("token between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("token not between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andHeaderIsNull() {
            addCriterion("header is null");
            return (Criteria) this;
        }

        public Criteria andHeaderIsNotNull() {
            addCriterion("header is not null");
            return (Criteria) this;
        }

        public Criteria andHeaderEqualTo(String value) {
            addCriterion("header =", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderNotEqualTo(String value) {
            addCriterion("header <>", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderGreaterThan(String value) {
            addCriterion("header >", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderGreaterThanOrEqualTo(String value) {
            addCriterion("header >=", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderLessThan(String value) {
            addCriterion("header <", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderLessThanOrEqualTo(String value) {
            addCriterion("header <=", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderLike(String value) {
            addCriterion("header like", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderNotLike(String value) {
            addCriterion("header not like", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderIn(List<String> values) {
            addCriterion("header in", values, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderNotIn(List<String> values) {
            addCriterion("header not in", values, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderBetween(String value1, String value2) {
            addCriterion("header between", value1, value2, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderNotBetween(String value1, String value2) {
            addCriterion("header not between", value1, value2, "header");
            return (Criteria) this;
        }

        public Criteria andHire_dateIsNull() {
            addCriterion("hire_date is null");
            return (Criteria) this;
        }

        public Criteria andHire_dateIsNotNull() {
            addCriterion("hire_date is not null");
            return (Criteria) this;
        }

        public Criteria andHire_dateEqualTo(Date value) {
            addCriterion("hire_date =", value, "hire_date");
            return (Criteria) this;
        }

        public Criteria andHire_dateNotEqualTo(Date value) {
            addCriterion("hire_date <>", value, "hire_date");
            return (Criteria) this;
        }

        public Criteria andHire_dateGreaterThan(Date value) {
            addCriterion("hire_date >", value, "hire_date");
            return (Criteria) this;
        }

        public Criteria andHire_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("hire_date >=", value, "hire_date");
            return (Criteria) this;
        }

        public Criteria andHire_dateLessThan(Date value) {
            addCriterion("hire_date <", value, "hire_date");
            return (Criteria) this;
        }

        public Criteria andHire_dateLessThanOrEqualTo(Date value) {
            addCriterion("hire_date <=", value, "hire_date");
            return (Criteria) this;
        }

        public Criteria andHire_dateIn(List<Date> values) {
            addCriterion("hire_date in", values, "hire_date");
            return (Criteria) this;
        }

        public Criteria andHire_dateNotIn(List<Date> values) {
            addCriterion("hire_date not in", values, "hire_date");
            return (Criteria) this;
        }

        public Criteria andHire_dateBetween(Date value1, Date value2) {
            addCriterion("hire_date between", value1, value2, "hire_date");
            return (Criteria) this;
        }

        public Criteria andHire_dateNotBetween(Date value1, Date value2) {
            addCriterion("hire_date not between", value1, value2, "hire_date");
            return (Criteria) this;
        }

        public Criteria andNext_promotion_timeIsNull() {
            addCriterion("next_promotion_time is null");
            return (Criteria) this;
        }

        public Criteria andNext_promotion_timeIsNotNull() {
            addCriterion("next_promotion_time is not null");
            return (Criteria) this;
        }

        public Criteria andNext_promotion_timeEqualTo(Date value) {
            addCriterion("next_promotion_time =", value, "next_promotion_time");
            return (Criteria) this;
        }

        public Criteria andNext_promotion_timeNotEqualTo(Date value) {
            addCriterion("next_promotion_time <>", value, "next_promotion_time");
            return (Criteria) this;
        }

        public Criteria andNext_promotion_timeGreaterThan(Date value) {
            addCriterion("next_promotion_time >", value, "next_promotion_time");
            return (Criteria) this;
        }

        public Criteria andNext_promotion_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("next_promotion_time >=", value, "next_promotion_time");
            return (Criteria) this;
        }

        public Criteria andNext_promotion_timeLessThan(Date value) {
            addCriterion("next_promotion_time <", value, "next_promotion_time");
            return (Criteria) this;
        }

        public Criteria andNext_promotion_timeLessThanOrEqualTo(Date value) {
            addCriterion("next_promotion_time <=", value, "next_promotion_time");
            return (Criteria) this;
        }

        public Criteria andNext_promotion_timeIn(List<Date> values) {
            addCriterion("next_promotion_time in", values, "next_promotion_time");
            return (Criteria) this;
        }

        public Criteria andNext_promotion_timeNotIn(List<Date> values) {
            addCriterion("next_promotion_time not in", values, "next_promotion_time");
            return (Criteria) this;
        }

        public Criteria andNext_promotion_timeBetween(Date value1, Date value2) {
            addCriterion("next_promotion_time between", value1, value2, "next_promotion_time");
            return (Criteria) this;
        }

        public Criteria andNext_promotion_timeNotBetween(Date value1, Date value2) {
            addCriterion("next_promotion_time not between", value1, value2, "next_promotion_time");
            return (Criteria) this;
        }

        public Criteria andLast_promotion_timeIsNull() {
            addCriterion("last_promotion_time is null");
            return (Criteria) this;
        }

        public Criteria andLast_promotion_timeIsNotNull() {
            addCriterion("last_promotion_time is not null");
            return (Criteria) this;
        }

        public Criteria andLast_promotion_timeEqualTo(Date value) {
            addCriterion("last_promotion_time =", value, "last_promotion_time");
            return (Criteria) this;
        }

        public Criteria andLast_promotion_timeNotEqualTo(Date value) {
            addCriterion("last_promotion_time <>", value, "last_promotion_time");
            return (Criteria) this;
        }

        public Criteria andLast_promotion_timeGreaterThan(Date value) {
            addCriterion("last_promotion_time >", value, "last_promotion_time");
            return (Criteria) this;
        }

        public Criteria andLast_promotion_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_promotion_time >=", value, "last_promotion_time");
            return (Criteria) this;
        }

        public Criteria andLast_promotion_timeLessThan(Date value) {
            addCriterion("last_promotion_time <", value, "last_promotion_time");
            return (Criteria) this;
        }

        public Criteria andLast_promotion_timeLessThanOrEqualTo(Date value) {
            addCriterion("last_promotion_time <=", value, "last_promotion_time");
            return (Criteria) this;
        }

        public Criteria andLast_promotion_timeIn(List<Date> values) {
            addCriterion("last_promotion_time in", values, "last_promotion_time");
            return (Criteria) this;
        }

        public Criteria andLast_promotion_timeNotIn(List<Date> values) {
            addCriterion("last_promotion_time not in", values, "last_promotion_time");
            return (Criteria) this;
        }

        public Criteria andLast_promotion_timeBetween(Date value1, Date value2) {
            addCriterion("last_promotion_time between", value1, value2, "last_promotion_time");
            return (Criteria) this;
        }

        public Criteria andLast_promotion_timeNotBetween(Date value1, Date value2) {
            addCriterion("last_promotion_time not between", value1, value2, "last_promotion_time");
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