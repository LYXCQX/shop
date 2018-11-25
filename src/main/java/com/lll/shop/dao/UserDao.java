package com.lll.shop.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lll.shop.pojo.UserPojo;

public interface UserDao {

	/**
	 * 查询用户信息
	 * @param userPojo
	 * @return
	 */
	@Select("select * from user where cellPhone = #{cellPhone}")
	public UserPojo selectUser(UserPojo userPojo);
	
	/**
	 * 查询用户信息
	 * @param userPojo
	 * @return
	 */
	@Select("select * from user where loginId = #{loginId}")
	public UserPojo selectUserByLoginId(UserPojo userPojo);
	
	/**
	 * 保存用户信息
	 * @param userPojo
	 * @return
	 */
	@Insert("INSERT INTO user(cellPhone, nickName, passWord, salt,loginId,lastLogInTime) VALUES (#{cellPhone}, #{nickName}, #{passWord}, #{salt},#{loginId},#{lastLogInTime})")
	public int saveUser(UserPojo userPojo);
	
	/**
	 * 修改用户信息
	 * @param userPojo
	 * @return
	 */
	@Update("<script> UPDATE user SET "
			+ "<trim suffixOverrides=','>"
			+ "<if test='nickName != null'>  nickName = #{nickName},</if> "
			+ "<if test='passWord != null'>  passWord = #{passWord},</if> "
			+ "<if test='headFile != null'> headFile = #{headFile}, </if> "
			+ "<if test='salt != null'>  salt = #{salt},</if> "
			+ "<if test='loginCount != null'>  loginCount = loginCount+1,</if> "
			+ "<if test='lastLogInTime != null'> lastLogInTime = #{lastLogInTime}</if> "
			+ "</trim>"
			+ " WHERE cellPhone = #{cellPhone} "
			+ "</script>"
			)
	public int updateUser(UserPojo userPojo);
}
