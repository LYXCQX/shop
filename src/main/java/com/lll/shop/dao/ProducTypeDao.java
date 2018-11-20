package com.lll.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.lll.shop.pojo.ProductTypePojo;

public interface ProducTypeDao {

	@Select("select * from productType order by id")
	public List<ProductTypePojo> getAll();
}
