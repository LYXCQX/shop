package com.lll.shop.pojo;

import java.util.Date;

/**
 * 请求记录
 * @author Administrator
 *
 */
public class ReqinfoPojo {

	private Integer id;
	private String ip;// 访问ip
	private Integer uid;// 用户id
	private int pid;//产品id
	private String forgetUrl;
	private int type;
	private Date createTime;// 创建时间
	@Override
	public String toString() {
		return "ReqinfoPojo [id=" + id + ", ip=" + ip + ", uid=" + uid + ", pid=" + pid + ", forgetUrl=" + forgetUrl
				+ ", type=" + type + ", createTime=" + createTime + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getForgetUrl() {
		return forgetUrl;
	}
	public void setForgetUrl(String forgetUrl) {
		this.forgetUrl = forgetUrl;
	}
	
}
