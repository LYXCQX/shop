package com.lll.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lll.shop.pojo.GlobalconfigPojo;

public interface GlobalconfigDao {

	@Select("select * from globalconfig ")
	public List<GlobalconfigPojo> getAllGlobal();
	
	@Select("select * from globalconfig where key = #{key}")
	public GlobalconfigPojo getGlobalByKey(@Param("key") String key);
}
