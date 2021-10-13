package com.myteam.mall.entity.po;

import java.util.ArrayList;
import java.util.List;

public class ShopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Integer value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Integer value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Integer value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Integer value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Integer value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Integer> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Integer> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Integer value1, Integer value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopAcctIsNull() {
            addCriterion("shop_acct is null");
            return (Criteria) this;
        }

        public Criteria andShopAcctIsNotNull() {
            addCriterion("shop_acct is not null");
            return (Criteria) this;
        }

        public Criteria andShopAcctEqualTo(String value) {
            addCriterion("shop_acct =", value, "shopAcct");
            return (Criteria) this;
        }

        public Criteria andShopAcctNotEqualTo(String value) {
            addCriterion("shop_acct <>", value, "shopAcct");
            return (Criteria) this;
        }

        public Criteria andShopAcctGreaterThan(String value) {
            addCriterion("shop_acct >", value, "shopAcct");
            return (Criteria) this;
        }

        public Criteria andShopAcctGreaterThanOrEqualTo(String value) {
            addCriterion("shop_acct >=", value, "shopAcct");
            return (Criteria) this;
        }

        public Criteria andShopAcctLessThan(String value) {
            addCriterion("shop_acct <", value, "shopAcct");
            return (Criteria) this;
        }

        public Criteria andShopAcctLessThanOrEqualTo(String value) {
            addCriterion("shop_acct <=", value, "shopAcct");
            return (Criteria) this;
        }

        public Criteria andShopAcctLike(String value) {
            addCriterion("shop_acct like", value, "shopAcct");
            return (Criteria) this;
        }

        public Criteria andShopAcctNotLike(String value) {
            addCriterion("shop_acct not like", value, "shopAcct");
            return (Criteria) this;
        }

        public Criteria andShopAcctIn(List<String> values) {
            addCriterion("shop_acct in", values, "shopAcct");
            return (Criteria) this;
        }

        public Criteria andShopAcctNotIn(List<String> values) {
            addCriterion("shop_acct not in", values, "shopAcct");
            return (Criteria) this;
        }

        public Criteria andShopAcctBetween(String value1, String value2) {
            addCriterion("shop_acct between", value1, value2, "shopAcct");
            return (Criteria) this;
        }

        public Criteria andShopAcctNotBetween(String value1, String value2) {
            addCriterion("shop_acct not between", value1, value2, "shopAcct");
            return (Criteria) this;
        }

        public Criteria andShopPwdIsNull() {
            addCriterion("shop_pwd is null");
            return (Criteria) this;
        }

        public Criteria andShopPwdIsNotNull() {
            addCriterion("shop_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andShopPwdEqualTo(String value) {
            addCriterion("shop_pwd =", value, "shopPwd");
            return (Criteria) this;
        }

        public Criteria andShopPwdNotEqualTo(String value) {
            addCriterion("shop_pwd <>", value, "shopPwd");
            return (Criteria) this;
        }

        public Criteria andShopPwdGreaterThan(String value) {
            addCriterion("shop_pwd >", value, "shopPwd");
            return (Criteria) this;
        }

        public Criteria andShopPwdGreaterThanOrEqualTo(String value) {
            addCriterion("shop_pwd >=", value, "shopPwd");
            return (Criteria) this;
        }

        public Criteria andShopPwdLessThan(String value) {
            addCriterion("shop_pwd <", value, "shopPwd");
            return (Criteria) this;
        }

        public Criteria andShopPwdLessThanOrEqualTo(String value) {
            addCriterion("shop_pwd <=", value, "shopPwd");
            return (Criteria) this;
        }

        public Criteria andShopPwdLike(String value) {
            addCriterion("shop_pwd like", value, "shopPwd");
            return (Criteria) this;
        }

        public Criteria andShopPwdNotLike(String value) {
            addCriterion("shop_pwd not like", value, "shopPwd");
            return (Criteria) this;
        }

        public Criteria andShopPwdIn(List<String> values) {
            addCriterion("shop_pwd in", values, "shopPwd");
            return (Criteria) this;
        }

        public Criteria andShopPwdNotIn(List<String> values) {
            addCriterion("shop_pwd not in", values, "shopPwd");
            return (Criteria) this;
        }

        public Criteria andShopPwdBetween(String value1, String value2) {
            addCriterion("shop_pwd between", value1, value2, "shopPwd");
            return (Criteria) this;
        }

        public Criteria andShopPwdNotBetween(String value1, String value2) {
            addCriterion("shop_pwd not between", value1, value2, "shopPwd");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("shop_name =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("shop_name <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("shop_name like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("shop_name not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("shop_name in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopPersoninchargeIsNull() {
            addCriterion("shop_personincharge is null");
            return (Criteria) this;
        }

        public Criteria andShopPersoninchargeIsNotNull() {
            addCriterion("shop_personincharge is not null");
            return (Criteria) this;
        }

        public Criteria andShopPersoninchargeEqualTo(String value) {
            addCriterion("shop_personincharge =", value, "shopPersonincharge");
            return (Criteria) this;
        }

        public Criteria andShopPersoninchargeNotEqualTo(String value) {
            addCriterion("shop_personincharge <>", value, "shopPersonincharge");
            return (Criteria) this;
        }

        public Criteria andShopPersoninchargeGreaterThan(String value) {
            addCriterion("shop_personincharge >", value, "shopPersonincharge");
            return (Criteria) this;
        }

        public Criteria andShopPersoninchargeGreaterThanOrEqualTo(String value) {
            addCriterion("shop_personincharge >=", value, "shopPersonincharge");
            return (Criteria) this;
        }

        public Criteria andShopPersoninchargeLessThan(String value) {
            addCriterion("shop_personincharge <", value, "shopPersonincharge");
            return (Criteria) this;
        }

        public Criteria andShopPersoninchargeLessThanOrEqualTo(String value) {
            addCriterion("shop_personincharge <=", value, "shopPersonincharge");
            return (Criteria) this;
        }

        public Criteria andShopPersoninchargeLike(String value) {
            addCriterion("shop_personincharge like", value, "shopPersonincharge");
            return (Criteria) this;
        }

        public Criteria andShopPersoninchargeNotLike(String value) {
            addCriterion("shop_personincharge not like", value, "shopPersonincharge");
            return (Criteria) this;
        }

        public Criteria andShopPersoninchargeIn(List<String> values) {
            addCriterion("shop_personincharge in", values, "shopPersonincharge");
            return (Criteria) this;
        }

        public Criteria andShopPersoninchargeNotIn(List<String> values) {
            addCriterion("shop_personincharge not in", values, "shopPersonincharge");
            return (Criteria) this;
        }

        public Criteria andShopPersoninchargeBetween(String value1, String value2) {
            addCriterion("shop_personincharge between", value1, value2, "shopPersonincharge");
            return (Criteria) this;
        }

        public Criteria andShopPersoninchargeNotBetween(String value1, String value2) {
            addCriterion("shop_personincharge not between", value1, value2, "shopPersonincharge");
            return (Criteria) this;
        }

        public Criteria andShopPersonphoneIsNull() {
            addCriterion("shop_personphone is null");
            return (Criteria) this;
        }

        public Criteria andShopPersonphoneIsNotNull() {
            addCriterion("shop_personphone is not null");
            return (Criteria) this;
        }

        public Criteria andShopPersonphoneEqualTo(String value) {
            addCriterion("shop_personphone =", value, "shopPersonphone");
            return (Criteria) this;
        }

        public Criteria andShopPersonphoneNotEqualTo(String value) {
            addCriterion("shop_personphone <>", value, "shopPersonphone");
            return (Criteria) this;
        }

        public Criteria andShopPersonphoneGreaterThan(String value) {
            addCriterion("shop_personphone >", value, "shopPersonphone");
            return (Criteria) this;
        }

        public Criteria andShopPersonphoneGreaterThanOrEqualTo(String value) {
            addCriterion("shop_personphone >=", value, "shopPersonphone");
            return (Criteria) this;
        }

        public Criteria andShopPersonphoneLessThan(String value) {
            addCriterion("shop_personphone <", value, "shopPersonphone");
            return (Criteria) this;
        }

        public Criteria andShopPersonphoneLessThanOrEqualTo(String value) {
            addCriterion("shop_personphone <=", value, "shopPersonphone");
            return (Criteria) this;
        }

        public Criteria andShopPersonphoneLike(String value) {
            addCriterion("shop_personphone like", value, "shopPersonphone");
            return (Criteria) this;
        }

        public Criteria andShopPersonphoneNotLike(String value) {
            addCriterion("shop_personphone not like", value, "shopPersonphone");
            return (Criteria) this;
        }

        public Criteria andShopPersonphoneIn(List<String> values) {
            addCriterion("shop_personphone in", values, "shopPersonphone");
            return (Criteria) this;
        }

        public Criteria andShopPersonphoneNotIn(List<String> values) {
            addCriterion("shop_personphone not in", values, "shopPersonphone");
            return (Criteria) this;
        }

        public Criteria andShopPersonphoneBetween(String value1, String value2) {
            addCriterion("shop_personphone between", value1, value2, "shopPersonphone");
            return (Criteria) this;
        }

        public Criteria andShopPersonphoneNotBetween(String value1, String value2) {
            addCriterion("shop_personphone not between", value1, value2, "shopPersonphone");
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