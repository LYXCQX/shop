package com.lll.loan.dao;

import org.apache.ibatis.annotations.Insert;

import com.lll.loan.pojo.ReqinfoPojo;

public interface ReqinfoDao {

	@Insert("insert into reqinfo (id, ip, uid,pid,type,forgetUrl) values (#{id},#{ip},#{uid},#{pid},#{type},#{forgetUrl})")
	public int saveReqinfo(ReqinfoPojo reqinfoPojo);
}
