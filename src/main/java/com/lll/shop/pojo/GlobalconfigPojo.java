package com.lll.shop.pojo;

import java.util.Date;

public class GlobalconfigPojo {
	private Integer id;
	private String parKey;// 配置的key
	private String parValue;// 配置的value
	private String remark;// 备注
	private Date createTime;// 记录创建时间

	@Override
	public String toString() {
		return "GlobalconfigPojo [id=" + id + ", parKey=" + parKey + ", parValue=" + parValue + ", remark=" + remark
				+ ", createTime=" + createTime + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParKey() {
		return parKey;
	}

	public void setParKey(String parKey) {
		this.parKey = parKey;
	}

	public String getParValue() {
		return parValue;
	}

	public void setParValue(String parValue) {
		this.parValue = parValue;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
