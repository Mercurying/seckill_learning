package com.mercury.dao;

import com.mercury.dataobject.UserPasswordDO;
import org.apache.ibatis.annotations.Param;

public interface UserPasswordDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Sat Dec 22 23:55:18 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Sat Dec 22 23:55:18 CST 2018
     */
    int insert(UserPasswordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Sat Dec 22 23:55:18 CST 2018
     */
    int insertSelective(UserPasswordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Sat Dec 22 23:55:18 CST 2018
     */
    UserPasswordDO selectByPrimaryKey(Integer id);


    UserPasswordDO selectByUserId(Integer userId);

    UserPasswordDO selectByUserIdPassword(@Param("userId")Integer userId,@Param("password")String password);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Sat Dec 22 23:55:18 CST 2018
     */
    int updateByPrimaryKeySelective(UserPasswordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Sat Dec 22 23:55:18 CST 2018
     */
    int updateByPrimaryKey(UserPasswordDO record);
}