package com.lll.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lll.shop.pojo.ProductPojo;
import com.lll.shop.pojo.res.SyListRes;

public interface ProductDao {

	@Select("<script> select * from product where isPop=0 "
			+ "<if test='id != null'> and id = #{id}  </if> "
			+ "<if test='type != null'>  and FIND_IN_SET(#{type},type) </if> "
			+ "<if test='startQuota != null'>  and startQuota <![CDATA[ >= ]]> #{startQuota} </if> "
			+ "<if test='endQuota != null'>  and endQuota <![CDATA[ <= ]]> #{endQuota} </if> "
			+ "<if test='cycle != null'>  and cycle <![CDATA[ > ]]> #{cycle} and cycleType =#{cycleType} </if> "
			+ "<if test='endCycle != null'>  and endCycle <![CDATA[ < ]]> #{endCycle} and cycleType =#{cycleType} </if> "
			+ "<if test='isCredit != null'>  and isCredit = #{isCredit} </if> "
			+ "<if test='sort != null'> order by sort  </if> "
			+ "order by createTime desc </script>"
			)
	public List<ProductPojo> getProduct(ProductPojo productPojo);
	
	@Select("select * from product where isPop=0 and id = #{id} ")
	public ProductPojo getProductInfo(ProductPojo productPojo);
	
	@Select("<script> select id,name,introduce,logo,isDetail,type,startQuota,endQuota,rate,passRate,auditType from product where isPop=0 "
			+ "<if test='id != null'> and id = #{id}  </if> "
			+ "<if test='type != null'>  and FIND_IN_SET(#{type},type) </if> "
			+ "<if test='startQuota != null'>  and startQuota <![CDATA[ >= ]]> #{startQuota} </if> "
			+ "<if test='endQuota != null'>  and (endQuota <![CDATA[ <= ]]> #{endQuota} || startQuota <![CDATA[ <= ]]> #{endQuota}) </if> "
			+ "<if test='cycle != null'>  and cycle <![CDATA[ > ]]> #{cycle} and cycleType =#{cycleType} </if> "
			+ "<if test='endCycle != null'>  and endCycle <![CDATA[ < ]]> #{endCycle} and cycleType =#{cycleType} </if> "
			+ "<if test='isCredit != null'>  and isCredit = #{isCredit} </if> "
			+ "<if test='sort != null'> order by sort desc </if> </script>"
			)
	public List<SyListRes> getSyList(ProductPojo productPojo);

	@Update("update product set applyCount=applyCount+1 where id =#{id}")
	public int updateApplyCount(ProductPojo productpar);
}
