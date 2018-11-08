package com.lll.loan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lll.loan.pojo.ADPojo;
import com.lll.loan.pojo.BaseRes;
import com.lll.loan.pojo.Page;
import com.lll.loan.pojo.ProductPojo;
import com.lll.loan.pojo.ReqinfoPojo;
import com.lll.loan.pojo.res.SyListRes;
import com.lll.loan.service.LoanService;
import com.lll.loan.util.IpUtil;

@Controller
@RequestMapping("loan")
public class LoanController {

	private static final Logger log = LoggerFactory.getLogger(LoanController.class);

	@Autowired
	private LoanService loanService;

	@RequestMapping("getAd")
	@ResponseBody
	public BaseRes<ADPojo> getAd(ADPojo aDPar) {
		log.info("查询广告请求：" + aDPar.toString());
		List<ADPojo> aDPojoList = new ArrayList<ADPojo>();
		BaseRes<ADPojo> baseRes = new BaseRes<ADPojo>();
		try {
			aDPojoList = loanService.getAd(aDPar);
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
			PageInfo<ProductPojo> pageInfo = loanService.getProduct(productpar);
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
			ProductPojo productPojo = loanService.getProductInfo(productpar);
			model.addAttribute("product", productPojo);
			log.info("查询产品详情信息响应:" + productPojo.toString());
		} catch (Exception e) {
			log.error("查询产品详情信息抛出异常", e);
		}
		return "loanMain/loanInfo :: productInfo";
	}
	/**
	 * 查询产品
	 * 
	 * @param productPojo
	 * @return
	 */
	@RequestMapping("getSyList")
//	@ResponseBody
	public String getSyList(Page<ProductPojo> productPojo,Model model) {
		log.info("查询首页产品信息请求：" + productPojo.toString());
		BaseRes<SyListRes> baseRes = new BaseRes<SyListRes>();
		try {
			PageInfo<SyListRes> pageInfo = loanService.getSyList(productPojo);
			model.addAttribute("product", pageInfo.getList());
			model.addAttribute("total", pageInfo.getTotal());
			model.addAttribute("nextPage", pageInfo.getNextPage());
			model.addAttribute("ftype", productPojo.getReqData().getFtype());
			baseRes.setPageInfo(pageInfo);
			log.info("查询首页产品信息响应:" + baseRes.toString());
		} catch (Exception e) {
			log.error("查询首页产品信息抛出异常", e);
		}
		return "loanMain/loanList";
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
			int updateCount = loanService.updateApplyCount(productpar);
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
	public String saveReqinfo(HttpServletRequest request, ReqinfoPojo reqinfo, Model model) {
		log.info("用户信息请求：" + reqinfo.toString());
		try {
			reqinfo.setIp(IpUtil.getIpAddr(request));
			loanService.saveReqinfo(reqinfo);
			model.addAttribute("ad", loanService.getAd(new ADPojo()));
//			model.addAttribute("product", loanService.getProduct(new ProductPojo()));
			log.info("用户信息响应:" + model.toString());
		} catch (Exception e) {
			log.error("用户信息抛出异常", e);
		}
		return "loanMain/main";
	}
	
	@RequestMapping("reqLoan")
	@ResponseBody
	public BaseRes<ReqinfoPojo> reqLoan(HttpServletRequest request, ReqinfoPojo reqinfo) {
		log.info("用户点击借款链接请求：" + reqinfo.toString());
		BaseRes<ReqinfoPojo> baseRes = new BaseRes<ReqinfoPojo>();
		try {
			reqinfo.setIp(IpUtil.getIpAddr(request));
			reqinfo.setType(1);
			loanService.reqLoan(reqinfo);
			log.info("用户点击借款链接响应:" + baseRes.toString());
		} catch (Exception e) {
			log.error("用户点击借款链接抛出异常", e);
		}
		return baseRes;
	}
}
