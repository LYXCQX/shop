package com.lll.shop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lll.shop.pojo.ADPojo;
import com.lll.shop.pojo.Page;
import com.lll.shop.pojo.ProductPojo;
import com.lll.shop.pojo.ProductTypePojo;
import com.lll.shop.pojo.ReqinfoPojo;
import com.lll.shop.pojo.res.SyListRes;

public interface ShopService {

	/**
	 * 查询广告
	 * @return
	 */
	public List<ADPojo> getAd(ADPojo aDPojo);

	/**
	 * 查询产品
	 * @param productpar
	 * @return
	 */
	public PageInfo<ProductPojo> getProduct(Page<ProductPojo> productpar);

	/**
	 * 修改产品信息
	 * @param productpar
	 * @return
	 */
	public int updateApplyCount(ProductPojo productpar);

	/**
	 * 用于记录用户访问记录
	 * @param reqinfo
	 * @return
	 */
	public int saveReqinfo(ReqinfoPojo reqinfo);

	public PageInfo<SyListRes> getSyList(Page<ProductPojo> productpar);

	/**
	 * 查询产品详情
	 * @param productpar
	 * @return
	 */
	public ProductPojo getProductInfo(ProductPojo productpar);

	/**
	 * 用户点击申请链接
	 * @param reqinfo
	 */
	public void reqShop(ReqinfoPojo reqinfo);

	/**
	 * 查询产品类型列表
	 * @return
	 */
	public List<ProductTypePojo> getTypeList();

}
