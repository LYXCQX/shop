package com.lll.shop.pojo;

import com.alibaba.fastjson.JSON;

public class Page<T> {
	//当前页
    private Integer pageNum = 1;
    //每页的数量
    private Integer pageSize = 20;
    
    private T reqData;

	@Override
	public String toString() {
		return "Page [pageNum=" + pageNum + ", pageSize=" + pageSize + ", reqData=" + reqData + "]";
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public T getReqData() {
		return reqData;
	}

	public void setReqData(String reqData) {
		this.reqData = (T) JSON.toJavaObject(JSON.parseObject(reqData) , ProductPojo.class);
	}
	
}
