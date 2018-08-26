package com.dingli.comment.dao;

import com.dingli.comment.bean.Dictype;
import com.dingli.comment.bean.DictypeExample;
import com.dingli.comment.bean.DictypeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictypeMapper {
	
	List<Dictype> selectDictype(String type);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    int countByExample(DictypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    int deleteByExample(DictypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    int deleteByPrimaryKey(DictypeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    int insert(Dictype record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    int insertSelective(Dictype record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    List<Dictype> selectByExample(DictypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    Dictype selectByPrimaryKey(DictypeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    int updateByExampleSelective(@Param("record") Dictype record, @Param("example") DictypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    int updateByExample(@Param("record") Dictype record, @Param("example") DictypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    int updateByPrimaryKeySelective(Dictype record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 11:00:59 CST 2018
     */
    int updateByPrimaryKey(Dictype record);
}