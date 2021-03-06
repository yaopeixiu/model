package com.example.demo0116.dao;

import com.example.demo0116.domain.Abnormal;
import com.example.demo0116.domain.AbnormalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AbnormalMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal
     *
     * @mbg.generated
     */
    long countByExample(AbnormalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal
     *
     * @mbg.generated
     */
    int deleteByExample(AbnormalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal
     *
     * @mbg.generated
     */
    int insert(Abnormal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal
     *
     * @mbg.generated
     */
    int insertSelective(Abnormal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal
     *
     * @mbg.generated
     */
    Abnormal selectOneByExample(AbnormalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal
     *
     * @mbg.generated
     */
    Abnormal selectOneByExampleSelective(@Param("example") AbnormalExample example, @Param("selective") Abnormal.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal
     *
     * @mbg.generated
     */
    List<Abnormal> selectByExampleSelective(@Param("example") AbnormalExample example, @Param("selective") Abnormal.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal
     *
     * @mbg.generated
     */
    List<Abnormal> selectByExample(AbnormalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal
     *
     * @mbg.generated
     */
    Abnormal selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") Abnormal.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal
     *
     * @mbg.generated
     */
    Abnormal selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Abnormal record, @Param("example") AbnormalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Abnormal record, @Param("example") AbnormalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Abnormal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table abnormal
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Abnormal record);
}