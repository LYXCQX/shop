package com.lll.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.lll.shop.pojo.ADPojo;
import com.lll.shop.pojo.BaseRes;
import com.lll.shop.pojo.Page;
import com.lll.shop.pojo.ProductPojo;
import com.lll.shop.pojo.ProductTypePojo;
import com.lll.shop.pojo.ReqinfoPojo;
import com.lll.shop.pojo.res.SyListRes;
import com.lll.shop.service.ShopService;
import com.lll.shop.util.IpUtil;

@RestController
@RequestMapping("shop")
public class ShopController {

	private static final Logger log = LoggerFactory.getLogger(ShopController.class);

	@Autowired
	private ShopService shopService;

	@RequestMapping("getAd")
	@ResponseBody
	public BaseRes<ADPojo> getAd(ADPojo aDPar) {
		log.info("查询广告请求：" + aDPar.toString());
		List<ADPojo> aDPojoList = new ArrayList<ADPojo>();
		BaseRes<ADPojo> baseRes = new BaseRes<ADPojo>();
		try {
			aDPojoList = shopService.getAd(aDPar);
			baseRes.setDataList(aDPojoList);
			log.info("查询广告响应:" + baseRes.toString());
		} catch (Exception e) {
			log.error("查询广告抛出异常", e);
		}
		return baseRes;
	}

	/**
	 * 查询产品
	 * 
	 * @param productpar
	 * @return
	 */
	@RequestMapping("getProduct")
	@ResponseBody
	public BaseRes<ProductPojo> getProduct(Page<ProductPojo> productpar,Model model) {
		log.info("查询产品信息请求：" + productpar.toString());
		BaseRes<ProductPojo> baseRes = new BaseRes<ProductPojo>();
		try {
			PageInfo<ProductPojo> pageInfo = shopService.getProduct(productpar);
			model.addAttribute("product", pageInfo.getList());
			baseRes.setPageInfo(pageInfo);
			log.info("查询产品信息响应:" + baseRes.toString());
		} catch (Exception e) {
			log.error("查询产品信息抛出异常", e);
		}
		return baseRes;
	}
	
	/**
	 * 查询产品
	 * 
	 * @param productpar
	 * @return
	 */
	@RequestMapping("getProductInfo")
	public String getProductInfo(ProductPojo productpar,Model model) {
		log.info("查询产品详情信息请求：" + productpar.toString());
		try {
			ProductPojo productPojo = shopService.getProductInfo(productpar);
			model.addAttribute("product", productPojo);
			log.info("查询产品详情信息响应:" + productPojo.toString());
		} catch (Exception e) {
			log.error("查询产品详情信息抛出异常", e);
		}
		return "shopMain/shopInfo :: productInfo";
	}
	/**
	 * 查询产品
	 * 
	 * @param productPojo
	 * @return
	 */
	@RequestMapping("getSyList")
//	@ResponseBody
	public BaseRes<SyListRes> getSyList(Page<ProductPojo> productPojo,Model model) {
		log.info("查询首页产品信息请求：" + productPojo.toString());
		BaseRes<SyListRes> baseRes = new BaseRes<SyListRes>();
		try {
			PageInfo<SyListRes> pageInfo = shopService.getSyList(productPojo);
//			baseRes.setPageInfo(pageInfo);
			baseRes.setDataList(pageInfo.getList());
			log.info("查询首页产品信息响应:" + baseRes.toString());
		} catch (Exception e) {
			log.error("查询首页产品信息抛出异常", e);
		}
		return baseRes;
	}

	/**
	 * 修改产品信息
	 * 
	 * @param productpar
	 * @return
	 */
	@RequestMapping("updateApplyCount")
	@ResponseBody
	public BaseRes<Integer> updateApplyCount(ProductPojo productpar) {
		log.info("修改产品信息请求：" + productpar.toString());
		BaseRes<Integer> baseRes = new BaseRes<Integer>();
		try {
			int updateCount = shopService.updateApplyCount(productpar);
			log.info("修改产品信息响应:" + updateCount);
		} catch (Exception e) {
			log.error("修改产品信息抛出异常", e);
			baseRes.setState(500);
		}
		return baseRes;
	}

	/**
	 * 用于记录用户访问记录
	 * 
	 * @param reqinfo
	 * @return
	 */
	@RequestMapping("reqinfo")
	public BaseRes<ADPojo> saveReqinfo(HttpServletRequest request, ReqinfoPojo reqinfo, Model model) {
		log.info("用户信息请求：" + reqinfo.toString());
		BaseRes<ADPojo> res =new BaseRes<ADPojo>();
		try {
			reqinfo.setIp(IpUtil.getIpAddr(request));
			shopService.saveReqinfo(reqinfo);
			res.setDataList(shopService.getAd(new ADPojo()));
			log.info("用户信息响应:" + model.toString());
		} catch (Exception e) {
			res.setState(500);
			res.setMessage("服务器开小差了，请刷新再试...");
			log.error("用户信息抛出异常", e);
		}
		return res;
	}
	/**
	 * 查询产品类型列表
	 * 
	 * @param reqinfo
	 * @return
	 */
	@RequestMapping("getTypeList")
	public BaseRes<ProductTypePojo> getTypeList(Model model) {
		log.info("查询产品类型列表");
		BaseRes<ProductTypePojo> res =new BaseRes<ProductTypePojo>();
		try {
			res.setDataList(shopService.getTypeList());
			log.info("查询产品类型列表响应:" + res.toString());
		} catch (Exception e) {
			log.error("查询产品类型列表抛出异常", e);
		}
		return res;
	}
	
	@RequestMapping("reqShop")
	@ResponseBody
	public BaseRes<ReqinfoPojo> reqShop(HttpServletRequest request, ReqinfoPojo reqinfo) {
		log.info("用户点击申请链接请求：" + reqinfo.toString());
		BaseRes<ReqinfoPojo> baseRes = new BaseRes<ReqinfoPojo>();
		try {
			reqinfo.setIp(IpUtil.getIpAddr(request));
			reqinfo.setType(1);
			shopService.reqShop(reqinfo);
			log.info("用户点击申请链接响应:" + baseRes.toString());
		} catch (Exception e) {
			log.error("用户点击申请链接抛出异常", e);
		}
		return baseRes;
	}
}
