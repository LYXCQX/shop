package com.lll.loan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lll.loan.dao.ADDao;
import com.lll.loan.dao.ProductDao;
import com.lll.loan.dao.ReqinfoDao;
import com.lll.loan.pojo.ADPojo;
import com.lll.loan.pojo.Page;
import com.lll.loan.pojo.ProductPojo;
import com.lll.loan.pojo.ReqinfoPojo;
import com.lll.loan.pojo.res.SyListRes;
import com.lll.loan.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService{

	@Autowired
	private ADDao aDDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ReqinfoDao reqinfoDao;
	/**
	 * 查询广告
	 */
	@Override
	public List<ADPojo> getAd(ADPojo aDPojo) {
		return aDDao.getAd(aDPojo);
	}
	/**
	 * 查询产品
	 */
	@Override
	public PageInfo<ProductPojo> getProduct(Page<ProductPojo> productpar) {
		PageHelper.startPage(productpar.getPageNum(), productpar.getPageSize());
		List<ProductPojo> list = productDao.getProduct(productpar.getReqData());
		PageInfo<ProductPojo> pageInfo = new PageInfo<ProductPojo>(list);
		return pageInfo;
	}
	
	/**
	 * 查询产品详情
	 */
	@Override
	public ProductPojo getProductInfo(ProductPojo productpar) {
		ProductPojo  productPojo= productDao.getProductInfo(productpar);
		productPojo.init();
		return productPojo;
	}
	/**
	 * 查询产品
	 */
	@Override
	public PageInfo<SyListRes> getSyList(Page<ProductPojo> productpar) {
		PageHelper.startPage(productpar.getPageNum(), productpar.getPageSize());
		List<SyListRes> list = productDao.getSyList(productpar.getReqData());
		PageInfo<SyListRes> pageInfo = new PageInfo<SyListRes>(list);
		return pageInfo;
	}
	/**
	 * 修改产品信息
	 */
	@Override
	public int updateApplyCount(ProductPojo productpar) {
		return productDao.updateApplyCount(productpar);
	}
	/**
	 * 用于记录用户访问记录
	 */
	@Override
	public int saveReqinfo(ReqinfoPojo reqinfo) {
		return reqinfoDao.saveReqinfo(reqinfo);
	}
	/**
	 * 用户点击申请链接
	 */
	@Transactional
	@Override
	public void reqLoan(ReqinfoPojo reqinfo) {
		//保存用户请求记录
		reqinfoDao.saveReqinfo(reqinfo);
		ProductPojo  productpar =new ProductPojo();
		productpar.setId(reqinfo.getPid());
		productDao.updateApplyCount(productpar);
	}

}
