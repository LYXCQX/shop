package com.lll.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.lll.shop.pojo.ADPojo;

public interface ADDao {

	@Select("<script>select * from ad where status=0 "
			+ "<if test='adType != null'>"
			+ " and adType = #{adType} "
			+ "</if> "
			+ "<if test='id != null'>"
			+ " and id = #{id} "
			+ "</if> </script>"
			)
	public List<ADPojo> getAd(ADPojo aDPojo);
}
