package com.myteam.mall.entity.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderPOExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderCouponIdIsNull() {
            addCriterion("order_coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderCouponIdIsNotNull() {
            addCriterion("order_coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCouponIdEqualTo(Integer value) {
            addCriterion("order_coupon_id =", value, "orderCouponId");
            return (Criteria) this;
        }

        public Criteria andOrderCouponIdNotEqualTo(Integer value) {
            addCriterion("order_coupon_id <>", value, "orderCouponId");
            return (Criteria) this;
        }

        public Criteria andOrderCouponIdGreaterThan(Integer value) {
            addCriterion("order_coupon_id >", value, "orderCouponId");
            return (Criteria) this;
        }

        public Criteria andOrderCouponIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_coupon_id >=", value, "orderCouponId");
            return (Criteria) this;
        }

        public Criteria andOrderCouponIdLessThan(Integer value) {
            addCriterion("order_coupon_id <", value, "orderCouponId");
            return (Criteria) this;
        }

        public Criteria andOrderCouponIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_coupon_id <=", value, "orderCouponId");
            return (Criteria) this;
        }

        public Criteria andOrderCouponIdIn(List<Integer> values) {
            addCriterion("order_coupon_id in", values, "orderCouponId");
            return (Criteria) this;
        }

        public Criteria andOrderCouponIdNotIn(List<Integer> values) {
            addCriterion("order_coupon_id not in", values, "orderCouponId");
            return (Criteria) this;
        }

        public Criteria andOrderCouponIdBetween(Integer value1, Integer value2) {
            addCriterion("order_coupon_id between", value1, value2, "orderCouponId");
            return (Criteria) this;
        }

        public Criteria andOrderCouponIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_coupon_id not between", value1, value2, "orderCouponId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdIsNull() {
            addCriterion("order_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdIsNotNull() {
            addCriterion("order_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdEqualTo(Integer value) {
            addCriterion("order_user_id =", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdNotEqualTo(Integer value) {
            addCriterion("order_user_id <>", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdGreaterThan(Integer value) {
            addCriterion("order_user_id >", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_user_id >=", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdLessThan(Integer value) {
            addCriterion("order_user_id <", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_user_id <=", value, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdIn(List<Integer> values) {
            addCriterion("order_user_id in", values, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdNotIn(List<Integer> values) {
            addCriterion("order_user_id not in", values, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdBetween(Integer value1, Integer value2) {
            addCriterion("order_user_id between", value1, value2, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_user_id not between", value1, value2, "orderUserId");
            return (Criteria) this;
        }

        public Criteria andOrderOriginMoneyIsNull() {
            addCriterion("order_origin_money is null");
            return (Criteria) this;
        }

        public Criteria andOrderOriginMoneyIsNotNull() {
            addCriterion("order_origin_money is not null");
            return (Criteria) this;
        }

        public Criteria andOrderOriginMoneyEqualTo(BigDecimal value) {
            addCriterion("order_origin_money =", value, "orderOriginMoney");
            return (Criteria) this;
        }

        public Criteria andOrderOriginMoneyNotEqualTo(BigDecimal value) {
            addCriterion("order_origin_money <>", value, "orderOriginMoney");
            return (Criteria) this;
        }

        public Criteria andOrderOriginMoneyGreaterThan(BigDecimal value) {
            addCriterion("order_origin_money >", value, "orderOriginMoney");
            return (Criteria) this;
        }

        public Criteria andOrderOriginMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_origin_money >=", value, "orderOriginMoney");
            return (Criteria) this;
        }

        public Criteria andOrderOriginMoneyLessThan(BigDecimal value) {
            addCriterion("order_origin_money <", value, "orderOriginMoney");
            return (Criteria) this;
        }

        public Criteria andOrderOriginMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_origin_money <=", value, "orderOriginMoney");
            return (Criteria) this;
        }

        public Criteria andOrderOriginMoneyIn(List<BigDecimal> values) {
            addCriterion("order_origin_money in", values, "orderOriginMoney");
            return (Criteria) this;
        }

        public Criteria andOrderOriginMoneyNotIn(List<BigDecimal> values) {
            addCriterion("order_origin_money not in", values, "orderOriginMoney");
            return (Criteria) this;
        }

        public Criteria andOrderOriginMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_origin_money between", value1, value2, "orderOriginMoney");
            return (Criteria) this;
        }

        public Criteria andOrderOriginMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_origin_money not between", value1, value2, "orderOriginMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMovingMoneyIsNull() {
            addCriterion("order_moving_money is null");
            return (Criteria) this;
        }

        public Criteria andOrderMovingMoneyIsNotNull() {
            addCriterion("order_moving_money is not null");
            return (Criteria) this;
        }

        public Criteria andOrderMovingMoneyEqualTo(BigDecimal value) {
            addCriterion("order_moving_money =", value, "orderMovingMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMovingMoneyNotEqualTo(BigDecimal value) {
            addCriterion("order_moving_money <>", value, "orderMovingMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMovingMoneyGreaterThan(BigDecimal value) {
            addCriterion("order_moving_money >", value, "orderMovingMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMovingMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_moving_money >=", value, "orderMovingMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMovingMoneyLessThan(BigDecimal value) {
            addCriterion("order_moving_money <", value, "orderMovingMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMovingMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_moving_money <=", value, "orderMovingMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMovingMoneyIn(List<BigDecimal> values) {
            addCriterion("order_moving_money in", values, "orderMovingMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMovingMoneyNotIn(List<BigDecimal> values) {
            addCriterion("order_moving_money not in", values, "orderMovingMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMovingMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_moving_money between", value1, value2, "orderMovingMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMovingMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_moving_money not between", value1, value2, "orderMovingMoney");
            return (Criteria) this;
        }

        public Criteria andOrderScoretoMoneyIsNull() {
            addCriterion("order_scoreto_money is null");
            return (Criteria) this;
        }

        public Criteria andOrderScoretoMoneyIsNotNull() {
            addCriterion("order_scoreto_money is not null");
            return (Criteria) this;
        }

        public Criteria andOrderScoretoMoneyEqualTo(BigDecimal value) {
            addCriterion("order_scoreto_money =", value, "orderScoretoMoney");
            return (Criteria) this;
        }

        public Criteria andOrderScoretoMoneyNotEqualTo(BigDecimal value) {
            addCriterion("order_scoreto_money <>", value, "orderScoretoMoney");
            return (Criteria) this;
        }

        public Criteria andOrderScoretoMoneyGreaterThan(BigDecimal value) {
            addCriterion("order_scoreto_money >", value, "orderScoretoMoney");
            return (Criteria) this;
        }

        public Criteria andOrderScoretoMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_scoreto_money >=", value, "orderScoretoMoney");
            return (Criteria) this;
        }

        public Criteria andOrderScoretoMoneyLessThan(BigDecimal value) {
            addCriterion("order_scoreto_money <", value, "orderScoretoMoney");
            return (Criteria) this;
        }

        public Criteria andOrderScoretoMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_scoreto_money <=", value, "orderScoretoMoney");
            return (Criteria) this;
        }

        public Criteria andOrderScoretoMoneyIn(List<BigDecimal> values) {
            addCriterion("order_scoreto_money in", values, "orderScoretoMoney");
            return (Criteria) this;
        }

        public Criteria andOrderScoretoMoneyNotIn(List<BigDecimal> values) {
            addCriterion("order_scoreto_money not in", values, "orderScoretoMoney");
            return (Criteria) this;
        }

        public Criteria andOrderScoretoMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_scoreto_money between", value1, value2, "orderScoretoMoney");
            return (Criteria) this;
        }

        public Criteria andOrderScoretoMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_scoreto_money not between", value1, value2, "orderScoretoMoney");
            return (Criteria) this;
        }

        public Criteria andOrderCoupontoMoneyIsNull() {
            addCriterion("order_couponto_money is null");
            return (Criteria) this;
        }

        public Criteria andOrderCoupontoMoneyIsNotNull() {
            addCriterion("order_couponto_money is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCoupontoMoneyEqualTo(BigDecimal value) {
            addCriterion("order_couponto_money =", value, "orderCoupontoMoney");
            return (Criteria) this;
        }

        public Criteria andOrderCoupontoMoneyNotEqualTo(BigDecimal value) {
            addCriterion("order_couponto_money <>", value, "orderCoupontoMoney");
            return (Criteria) this;
        }

        public Criteria andOrderCoupontoMoneyGreaterThan(BigDecimal value) {
            addCriterion("order_couponto_money >", value, "orderCoupontoMoney");
            return (Criteria) this;
        }

        public Criteria andOrderCoupontoMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_couponto_money >=", value, "orderCoupontoMoney");
            return (Criteria) this;
        }

        public Criteria andOrderCoupontoMoneyLessThan(BigDecimal value) {
            addCriterion("order_couponto_money <", value, "orderCoupontoMoney");
            return (Criteria) this;
        }

        public Criteria andOrderCoupontoMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_couponto_money <=", value, "orderCoupontoMoney");
            return (Criteria) this;
        }

        public Criteria andOrderCoupontoMoneyIn(List<BigDecimal> values) {
            addCriterion("order_couponto_money in", values, "orderCoupontoMoney");
            return (Criteria) this;
        }

        public Criteria andOrderCoupontoMoneyNotIn(List<BigDecimal> values) {
            addCriterion("order_couponto_money not in", values, "orderCoupontoMoney");
            return (Criteria) this;
        }

        public Criteria andOrderCoupontoMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_couponto_money between", value1, value2, "orderCoupontoMoney");
            return (Criteria) this;
        }

        public Criteria andOrderCoupontoMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_couponto_money not between", value1, value2, "orderCoupontoMoney");
            return (Criteria) this;
        }

        public Criteria andOrderToPayIsNull() {
            addCriterion("order_to_pay is null");
            return (Criteria) this;
        }

        public Criteria andOrderToPayIsNotNull() {
            addCriterion("order_to_pay is not null");
            return (Criteria) this;
        }

        public Criteria andOrderToPayEqualTo(BigDecimal value) {
            addCriterion("order_to_pay =", value, "orderToPay");
            return (Criteria) this;
        }

        public Criteria andOrderToPayNotEqualTo(BigDecimal value) {
            addCriterion("order_to_pay <>", value, "orderToPay");
            return (Criteria) this;
        }

        public Criteria andOrderToPayGreaterThan(BigDecimal value) {
            addCriterion("order_to_pay >", value, "orderToPay");
            return (Criteria) this;
        }

        public Criteria andOrderToPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_to_pay >=", value, "orderToPay");
            return (Criteria) this;
        }

        public Criteria andOrderToPayLessThan(BigDecimal value) {
            addCriterion("order_to_pay <", value, "orderToPay");
            return (Criteria) this;
        }

        public Criteria andOrderToPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_to_pay <=", value, "orderToPay");
            return (Criteria) this;
        }

        public Criteria andOrderToPayIn(List<BigDecimal> values) {
            addCriterion("order_to_pay in", values, "orderToPay");
            return (Criteria) this;
        }

        public Criteria andOrderToPayNotIn(List<BigDecimal> values) {
            addCriterion("order_to_pay not in", values, "orderToPay");
            return (Criteria) this;
        }

        public Criteria andOrderToPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_to_pay between", value1, value2, "orderToPay");
            return (Criteria) this;
        }

        public Criteria andOrderToPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_to_pay not between", value1, value2, "orderToPay");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeNameIsNull() {
            addCriterion("order_cogsignee_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeNameIsNotNull() {
            addCriterion("order_cogsignee_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeNameEqualTo(String value) {
            addCriterion("order_cogsignee_name =", value, "orderCogsigneeName");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeNameNotEqualTo(String value) {
            addCriterion("order_cogsignee_name <>", value, "orderCogsigneeName");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeNameGreaterThan(String value) {
            addCriterion("order_cogsignee_name >", value, "orderCogsigneeName");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_cogsignee_name >=", value, "orderCogsigneeName");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeNameLessThan(String value) {
            addCriterion("order_cogsignee_name <", value, "orderCogsigneeName");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeNameLessThanOrEqualTo(String value) {
            addCriterion("order_cogsignee_name <=", value, "orderCogsigneeName");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeNameLike(String value) {
            addCriterion("order_cogsignee_name like", value, "orderCogsigneeName");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeNameNotLike(String value) {
            addCriterion("order_cogsignee_name not like", value, "orderCogsigneeName");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeNameIn(List<String> values) {
            addCriterion("order_cogsignee_name in", values, "orderCogsigneeName");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeNameNotIn(List<String> values) {
            addCriterion("order_cogsignee_name not in", values, "orderCogsigneeName");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeNameBetween(String value1, String value2) {
            addCriterion("order_cogsignee_name between", value1, value2, "orderCogsigneeName");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeNameNotBetween(String value1, String value2) {
            addCriterion("order_cogsignee_name not between", value1, value2, "orderCogsigneeName");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneePhoneIsNull() {
            addCriterion("order_cogsignee_phone is null");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneePhoneIsNotNull() {
            addCriterion("order_cogsignee_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneePhoneEqualTo(String value) {
            addCriterion("order_cogsignee_phone =", value, "orderCogsigneePhone");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneePhoneNotEqualTo(String value) {
            addCriterion("order_cogsignee_phone <>", value, "orderCogsigneePhone");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneePhoneGreaterThan(String value) {
            addCriterion("order_cogsignee_phone >", value, "orderCogsigneePhone");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("order_cogsignee_phone >=", value, "orderCogsigneePhone");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneePhoneLessThan(String value) {
            addCriterion("order_cogsignee_phone <", value, "orderCogsigneePhone");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneePhoneLessThanOrEqualTo(String value) {
            addCriterion("order_cogsignee_phone <=", value, "orderCogsigneePhone");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneePhoneLike(String value) {
            addCriterion("order_cogsignee_phone like", value, "orderCogsigneePhone");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneePhoneNotLike(String value) {
            addCriterion("order_cogsignee_phone not like", value, "orderCogsigneePhone");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneePhoneIn(List<String> values) {
            addCriterion("order_cogsignee_phone in", values, "orderCogsigneePhone");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneePhoneNotIn(List<String> values) {
            addCriterion("order_cogsignee_phone not in", values, "orderCogsigneePhone");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneePhoneBetween(String value1, String value2) {
            addCriterion("order_cogsignee_phone between", value1, value2, "orderCogsigneePhone");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneePhoneNotBetween(String value1, String value2) {
            addCriterion("order_cogsignee_phone not between", value1, value2, "orderCogsigneePhone");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeAddressIsNull() {
            addCriterion("order_cogsignee_address is null");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeAddressIsNotNull() {
            addCriterion("order_cogsignee_address is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeAddressEqualTo(String value) {
            addCriterion("order_cogsignee_address =", value, "orderCogsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeAddressNotEqualTo(String value) {
            addCriterion("order_cogsignee_address <>", value, "orderCogsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeAddressGreaterThan(String value) {
            addCriterion("order_cogsignee_address >", value, "orderCogsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("order_cogsignee_address >=", value, "orderCogsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeAddressLessThan(String value) {
            addCriterion("order_cogsignee_address <", value, "orderCogsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeAddressLessThanOrEqualTo(String value) {
            addCriterion("order_cogsignee_address <=", value, "orderCogsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeAddressLike(String value) {
            addCriterion("order_cogsignee_address like", value, "orderCogsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeAddressNotLike(String value) {
            addCriterion("order_cogsignee_address not like", value, "orderCogsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeAddressIn(List<String> values) {
            addCriterion("order_cogsignee_address in", values, "orderCogsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeAddressNotIn(List<String> values) {
            addCriterion("order_cogsignee_address not in", values, "orderCogsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeAddressBetween(String value1, String value2) {
            addCriterion("order_cogsignee_address between", value1, value2, "orderCogsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderCogsigneeAddressNotBetween(String value1, String value2) {
            addCriterion("order_cogsignee_address not between", value1, value2, "orderCogsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(String value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(String value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(String value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(String value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLike(String value) {
            addCriterion("order_status like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotLike(String value) {
            addCriterion("order_status not like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<String> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<String> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(String value1, String value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(String value1, String value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderPayingTimeIsNull() {
            addCriterion("order_paying_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderPayingTimeIsNotNull() {
            addCriterion("order_paying_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPayingTimeEqualTo(Date value) {
            addCriterion("order_paying_time =", value, "orderPayingTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayingTimeNotEqualTo(Date value) {
            addCriterion("order_paying_time <>", value, "orderPayingTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayingTimeGreaterThan(Date value) {
            addCriterion("order_paying_time >", value, "orderPayingTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_paying_time >=", value, "orderPayingTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayingTimeLessThan(Date value) {
            addCriterion("order_paying_time <", value, "orderPayingTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayingTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_paying_time <=", value, "orderPayingTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayingTimeIn(List<Date> values) {
            addCriterion("order_paying_time in", values, "orderPayingTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayingTimeNotIn(List<Date> values) {
            addCriterion("order_paying_time not in", values, "orderPayingTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayingTimeBetween(Date value1, Date value2) {
            addCriterion("order_paying_time between", value1, value2, "orderPayingTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayingTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_paying_time not between", value1, value2, "orderPayingTime");
            return (Criteria) this;
        }

        public Criteria andOrderReceivingTimeIsNull() {
            addCriterion("order_receiving_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderReceivingTimeIsNotNull() {
            addCriterion("order_receiving_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderReceivingTimeEqualTo(Date value) {
            addCriterion("order_receiving_time =", value, "orderReceivingTime");
            return (Criteria) this;
        }

        public Criteria andOrderReceivingTimeNotEqualTo(Date value) {
            addCriterion("order_receiving_time <>", value, "orderReceivingTime");
            return (Criteria) this;
        }

        public Criteria andOrderReceivingTimeGreaterThan(Date value) {
            addCriterion("order_receiving_time >", value, "orderReceivingTime");
            return (Criteria) this;
        }

        public Criteria andOrderReceivingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_receiving_time >=", value, "orderReceivingTime");
            return (Criteria) this;
        }

        public Criteria andOrderReceivingTimeLessThan(Date value) {
            addCriterion("order_receiving_time <", value, "orderReceivingTime");
            return (Criteria) this;
        }

        public Criteria andOrderReceivingTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_receiving_time <=", value, "orderReceivingTime");
            return (Criteria) this;
        }

        public Criteria andOrderReceivingTimeIn(List<Date> values) {
            addCriterion("order_receiving_time in", values, "orderReceivingTime");
            return (Criteria) this;
        }

        public Criteria andOrderReceivingTimeNotIn(List<Date> values) {
            addCriterion("order_receiving_time not in", values, "orderReceivingTime");
            return (Criteria) this;
        }

        public Criteria andOrderReceivingTimeBetween(Date value1, Date value2) {
            addCriterion("order_receiving_time between", value1, value2, "orderReceivingTime");
            return (Criteria) this;
        }

        public Criteria andOrderReceivingTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_receiving_time not between", value1, value2, "orderReceivingTime");
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