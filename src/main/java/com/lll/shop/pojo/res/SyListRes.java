package com.lll.shop.pojo.res;

import java.math.BigDecimal;

public class SyListRes {
	private Integer id;
	private String name;// 产品名称
	private String introduce;// 产品简介
	private String logo;// 产品logo
	private Integer isDetail;// 是否有详情页(0 有，1没有)
	private Integer type;// 产品类型(0秒下款，1额度高，2周期长，3黑户贷款，4利息低)
	private Integer startQuota;// 开始额度
	private Integer endQuota;// 结束额度
	private BigDecimal rate;// 利息
	private Integer passRate;// 通过率
	private String auditType;// 审核方式
	private Integer applyCount;// 申请人数
	private Integer ptype;
	@Override
	public String toString() {
		return "SyListRes [id=" + id + ", name=" + name + ", introduce=" + introduce + ", logo=" + logo + ", isDetail="
				+ isDetail + ", type=" + type + ", startQuota=" + startQuota + ", endQuota=" + endQuota + ", rate="
				+ rate + ", passRate=" + passRate + ", auditType=" + auditType + ", applyCount=" + applyCount
				+ ", ptype=" + ptype + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Integer getIsDetail() {
		return isDetail;
	}
	public void setIsDetail(Integer isDetail) {
		this.isDetail = isDetail;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStartQuota() {
		return startQuota;
	}
	public void setStartQuota(Integer startQuota) {
		this.startQuota = startQuota;
	}
	public Integer getEndQuota() {
		return endQuota;
	}
	public void setEndQuota(Integer endQuota) {
		this.endQuota = endQuota;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public Integer getPassRate() {
		return passRate;
	}
	public void setPassRate(Integer passRate) {
		this.passRate = passRate;
	}
	public String getAuditType() {
		return auditType;
	}
	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}
	public Integer getApplyCount() {
		return applyCount;
	}
	public void setApplyCount(Integer applyCount) {
		this.applyCount = applyCount;
	}
	public Integer getPtype() {
		return ptype;
	}
	public void setPtype(Integer ptype) {
		this.ptype = ptype;
	}
}
