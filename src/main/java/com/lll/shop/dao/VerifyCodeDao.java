package com.lll.shop.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.lll.shop.pojo.UserPojo;
import com.lll.shop.pojo.VerifyCode;

public interface VerifyCodeDao {

	@Insert("INSERT INTO `shop`.`verifycode`(`cellPhone`, `code`, `codeType`) VALUES (#{cellPhone}, #{code}, #{codeType})")
	public int saveCode(VerifyCode verifyCode);
	
	@Select("select * from verifycode where cellPhone = #{cellPhone} and codeType= #{codeType} order by createTime desc limit 1 ")
	public VerifyCode selectCode(VerifyCode verifyCode);
	
	@Select("select * from verifycode where cellPhone = #{cellPhone} and codeType= #{codeType} order by createTime desc limit 1 ")
	public VerifyCode selectCodeByUser(UserPojo userPojo);
}
