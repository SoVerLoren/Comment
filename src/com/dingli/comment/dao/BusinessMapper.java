package com.dingli.comment.dao;

import com.dingli.comment.bean.Business;
import com.dingli.comment.bean.BusinessDto;
import com.dingli.comment.bean.BusinessExample;
import com.dingli.comment.bean.Dictype;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessMapper {
	
	List<Business> selectAllbusiness();
	
	int insertBu(Business business);
	
	List<BusinessDto> selectLoveBus(BusinessDto buDto);
	
	List<Business> selectByTitle(String title);
	
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    int countByExample(BusinessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    int deleteByExample(BusinessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    int insert(Business record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    int insertSelective(Business record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    List<Business> selectByExample(BusinessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    Business selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    int updateByExampleSelective(@Param("record") Business record, @Param("example") BusinessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    int updateByExample(@Param("record") Business record, @Param("example") BusinessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    int updateByPrimaryKeySelective(Business record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    int updateByPrimaryKey(Business record);

	
}