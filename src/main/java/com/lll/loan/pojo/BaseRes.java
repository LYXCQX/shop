package com.lll.loan.pojo;

import java.util.List;

import com.github.pagehelper.PageInfo;

public class BaseRes<T> {
	private Integer state =0;
	private String message;
	private T data;
	private List<T> dataList;
	private PageInfo<T> pageInfo;

	@Override
	public String toString() {
		return "BaseRes [state=" + state + ", message=" + message + ", data=" + data + ", dataList=" + dataList
				+ ", pageInfo=" + pageInfo + "]";
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public PageInfo<T> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<T> pageInfo) {
		this.pageInfo = pageInfo;
	}
}
