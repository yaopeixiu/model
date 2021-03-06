package com.example.demo0116.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver.driver_id
     *
     * @mbg.generated
     */
    private Integer driverId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver.realname
     *
     * @mbg.generated
     */
    private String realname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver.mobile
     *
     * @mbg.generated
     */
    private String mobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver.card
     *
     * @mbg.generated
     */
    private String card;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver.license
     *
     * @mbg.generated
     */
    private String license;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver.entry_date
     *
     * @mbg.generated
     */
    private LocalDateTime entryDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver.address
     *
     * @mbg.generated
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver.add_time
     *
     * @mbg.generated
     */
    private LocalDateTime addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver.update_time
     *
     * @mbg.generated
     */
    private LocalDateTime updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column driver.logdelete
     *
     * @mbg.generated
     */
    private Boolean logdelete;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver.driver_id
     *
     * @return the value of driver.driver_id
     *
     * @mbg.generated
     */
    public Integer getDriverId() {
        return driverId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver.driver_id
     *
     * @param driverId the value for driver.driver_id
     *
     * @mbg.generated
     */
    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver.realname
     *
     * @return the value of driver.realname
     *
     * @mbg.generated
     */
    public String getRealname() {
        return realname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver.realname
     *
     * @param realname the value for driver.realname
     *
     * @mbg.generated
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver.mobile
     *
     * @return the value of driver.mobile
     *
     * @mbg.generated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver.mobile
     *
     * @param mobile the value for driver.mobile
     *
     * @mbg.generated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver.card
     *
     * @return the value of driver.card
     *
     * @mbg.generated
     */
    public String getCard() {
        return card;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver.card
     *
     * @param card the value for driver.card
     *
     * @mbg.generated
     */
    public void setCard(String card) {
        this.card = card;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver.license
     *
     * @return the value of driver.license
     *
     * @mbg.generated
     */
    public String getLicense() {
        return license;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver.license
     *
     * @param license the value for driver.license
     *
     * @mbg.generated
     */
    public void setLicense(String license) {
        this.license = license;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver.entry_date
     *
     * @return the value of driver.entry_date
     *
     * @mbg.generated
     */
    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver.entry_date
     *
     * @param entryDate the value for driver.entry_date
     *
     * @mbg.generated
     */
    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver.address
     *
     * @return the value of driver.address
     *
     * @mbg.generated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver.address
     *
     * @param address the value for driver.address
     *
     * @mbg.generated
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver.remark
     *
     * @return the value of driver.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver.remark
     *
     * @param remark the value for driver.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver.add_time
     *
     * @return the value of driver.add_time
     *
     * @mbg.generated
     */
    public LocalDateTime getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver.add_time
     *
     * @param addTime the value for driver.add_time
     *
     * @mbg.generated
     */
    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver.update_time
     *
     * @return the value of driver.update_time
     *
     * @mbg.generated
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver.update_time
     *
     * @param updateTime the value for driver.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column driver.logdelete
     *
     * @return the value of driver.logdelete
     *
     * @mbg.generated
     */
    public Boolean getLogdelete() {
        return logdelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column driver.logdelete
     *
     * @param logdelete the value for driver.logdelete
     *
     * @mbg.generated
     */
    public void setLogdelete(Boolean logdelete) {
        this.logdelete = logdelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", driverId=").append(driverId);
        sb.append(", realname=").append(realname);
        sb.append(", mobile=").append(mobile);
        sb.append(", card=").append(card);
        sb.append(", license=").append(license);
        sb.append(", entryDate=").append(entryDate);
        sb.append(", address=").append(address);
        sb.append(", remark=").append(remark);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", logdelete=").append(logdelete);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Driver other = (Driver) that;
        return (this.getDriverId() == null ? other.getDriverId() == null : this.getDriverId().equals(other.getDriverId()))
            && (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getCard() == null ? other.getCard() == null : this.getCard().equals(other.getCard()))
            && (this.getLicense() == null ? other.getLicense() == null : this.getLicense().equals(other.getLicense()))
            && (this.getEntryDate() == null ? other.getEntryDate() == null : this.getEntryDate().equals(other.getEntryDate()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getLogdelete() == null ? other.getLogdelete() == null : this.getLogdelete().equals(other.getLogdelete()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table driver
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDriverId() == null) ? 0 : getDriverId().hashCode());
        result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getCard() == null) ? 0 : getCard().hashCode());
        result = prime * result + ((getLicense() == null) ? 0 : getLicense().hashCode());
        result = prime * result + ((getEntryDate() == null) ? 0 : getEntryDate().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getLogdelete() == null) ? 0 : getLogdelete().hashCode());
        return result;
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table driver
     *
     * @mbg.generated
     */
    public enum Column {
        driverId("driver_id", "driverId", "INTEGER", false),
        realname("realname", "realname", "VARCHAR", false),
        mobile("mobile", "mobile", "VARCHAR", false),
        card("card", "card", "VARCHAR", false),
        license("license", "license", "VARCHAR", false),
        entryDate("entry_date", "entryDate", "TIMESTAMP", false),
        address("address", "address", "VARCHAR", false),
        remark("remark", "remark", "VARCHAR", false),
        addTime("add_time", "addTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        logdelete("logdelete", "logdelete", "BIT", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table driver
         *
         * @mbg.generated
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table driver
         *
         * @mbg.generated
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table driver
         *
         * @mbg.generated
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table driver
         *
         * @mbg.generated
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table driver
         *
         * @mbg.generated
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table driver
         *
         * @mbg.generated
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table driver
         *
         * @mbg.generated
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table driver
         *
         * @mbg.generated
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table driver
         *
         * @mbg.generated
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table driver
         *
         * @mbg.generated
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table driver
         *
         * @mbg.generated
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table driver
         *
         * @mbg.generated
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table driver
         *
         * @mbg.generated
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table driver
         *
         * @mbg.generated
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table driver
         *
         * @mbg.generated
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table driver
         *
         * @mbg.generated
         */
        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}