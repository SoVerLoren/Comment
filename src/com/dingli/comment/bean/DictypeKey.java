package com.dingli.comment.bean;

public class DictypeKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dic.type
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dic.code
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    private String code;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dic.type
     *
     * @return the value of dic.type
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dic.type
     *
     * @param type the value for dic.type
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dic.code
     *
     * @return the value of dic.code
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dic.code
     *
     * @param code the value for dic.code
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}