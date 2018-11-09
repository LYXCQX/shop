package com.lll.shop.dao;

import org.apache.ibatis.annotations.Insert;

import com.lll.shop.pojo.ReqinfoPojo;

public interface ReqinfoDao {

	@Insert("insert into reqinfo (id, ip, uid,pid,type,forgetUrl) values (#{id},#{ip},#{uid},#{pid},#{type},#{forgetUrl})")
	public int saveReqinfo(ReqinfoPojo reqinfoPojo);
}
