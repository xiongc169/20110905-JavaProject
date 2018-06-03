package org.practice.mybatis.northwind.domain;

import java.util.ArrayList;
import java.util.List;

public class RegionExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Region
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Region
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Region
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Region
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public RegionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Region
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Region
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Region
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Region
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Region
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Region
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Region
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Region
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Region
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Region
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Region
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
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

        public Criteria andRegionidIsNull() {
            addCriterion("RegionID is null");
            return (Criteria) this;
        }

        public Criteria andRegionidIsNotNull() {
            addCriterion("RegionID is not null");
            return (Criteria) this;
        }

        public Criteria andRegionidEqualTo(Integer value) {
            addCriterion("RegionID =", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidNotEqualTo(Integer value) {
            addCriterion("RegionID <>", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidGreaterThan(Integer value) {
            addCriterion("RegionID >", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("RegionID >=", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidLessThan(Integer value) {
            addCriterion("RegionID <", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidLessThanOrEqualTo(Integer value) {
            addCriterion("RegionID <=", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidIn(List<Integer> values) {
            addCriterion("RegionID in", values, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidNotIn(List<Integer> values) {
            addCriterion("RegionID not in", values, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidBetween(Integer value1, Integer value2) {
            addCriterion("RegionID between", value1, value2, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidNotBetween(Integer value1, Integer value2) {
            addCriterion("RegionID not between", value1, value2, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegiondescriptionIsNull() {
            addCriterion("RegionDescription is null");
            return (Criteria) this;
        }

        public Criteria andRegiondescriptionIsNotNull() {
            addCriterion("RegionDescription is not null");
            return (Criteria) this;
        }

        public Criteria andRegiondescriptionEqualTo(String value) {
            addCriterion("RegionDescription =", value, "regiondescription");
            return (Criteria) this;
        }

        public Criteria andRegiondescriptionNotEqualTo(String value) {
            addCriterion("RegionDescription <>", value, "regiondescription");
            return (Criteria) this;
        }

        public Criteria andRegiondescriptionGreaterThan(String value) {
            addCriterion("RegionDescription >", value, "regiondescription");
            return (Criteria) this;
        }

        public Criteria andRegiondescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("RegionDescription >=", value, "regiondescription");
            return (Criteria) this;
        }

        public Criteria andRegiondescriptionLessThan(String value) {
            addCriterion("RegionDescription <", value, "regiondescription");
            return (Criteria) this;
        }

        public Criteria andRegiondescriptionLessThanOrEqualTo(String value) {
            addCriterion("RegionDescription <=", value, "regiondescription");
            return (Criteria) this;
        }

        public Criteria andRegiondescriptionLike(String value) {
            addCriterion("RegionDescription like", value, "regiondescription");
            return (Criteria) this;
        }

        public Criteria andRegiondescriptionNotLike(String value) {
            addCriterion("RegionDescription not like", value, "regiondescription");
            return (Criteria) this;
        }

        public Criteria andRegiondescriptionIn(List<String> values) {
            addCriterion("RegionDescription in", values, "regiondescription");
            return (Criteria) this;
        }

        public Criteria andRegiondescriptionNotIn(List<String> values) {
            addCriterion("RegionDescription not in", values, "regiondescription");
            return (Criteria) this;
        }

        public Criteria andRegiondescriptionBetween(String value1, String value2) {
            addCriterion("RegionDescription between", value1, value2, "regiondescription");
            return (Criteria) this;
        }

        public Criteria andRegiondescriptionNotBetween(String value1, String value2) {
            addCriterion("RegionDescription not between", value1, value2, "regiondescription");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Region
     *
     * @mbggenerated do_not_delete_during_merge Sun Jun 03 14:25:41 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table Region
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
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