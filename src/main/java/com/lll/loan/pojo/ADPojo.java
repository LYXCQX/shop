package com.lll.loan.pojo;

import java.util.Date;
/**
 * 广告
 * @author Administrator
 *
 */
public class ADPojo {

	private Integer id;
	private Integer pid;// 产品id
	private String adUrl;// 广告地址
	private String adImg;// 广告图片
	private String adRemark;//广告备注
	private Integer adType;// 广告类型(0 轮播广告，1提醒广告 )
	private Date createTime;// 创建时间
	private Date updateTime;// 修改时间
	@Override
	public String toString() {
		return "ADPojo [id=" + id + ", pid=" + pid + ", adUrl=" + adUrl + ", adImg=" + adImg + ", adRemark=" + adRemark
				+ ", adType=" + adType + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getAdUrl() {
		return adUrl;
	}
	public void setAdUrl(String adUrl) {
		this.adUrl = adUrl;
	}
	public String getAdImg() {
		return adImg;
	}
	public void setAdImg(String adImg) {
		this.adImg = adImg;
	}
	public Integer getAdType() {
		return adType;
	}
	public void setAdType(Integer adType) {
		this.adType = adType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getAdRemark() {
		return adRemark;
	}
	public void setAdRemark(String adRemark) {
		this.adRemark = adRemark;
	}
}
