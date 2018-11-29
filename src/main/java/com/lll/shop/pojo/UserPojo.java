package com.lll.shop.pojo;

import java.util.Date;

public class UserPojo {
	private Integer id;
	private String cellPhone;// 手机号
	private String nickName;// 姓名
	private String passWord;// 密码
	private String salt;// 密码加密字段
	private String headFile;// 头像路径
	private String signature;
	private String loginId;
	private Integer loginCount;//登录次数
	private Date createTime;// 创建时间
	private Date lastLogInTime;// 最后登录时间
	private String code;
	private String codeType;
	@Override
	public String toString() {
		return "UserPojo [id=" + id + ", cellPhone=" + cellPhone + ", nickName=" + nickName + ", passWord=" + passWord
				+ ", salt=" + salt + ", headFile=" + headFile + ", signature=" + signature + ", loginId=" + loginId
				+ ", loginCount=" + loginCount + ", createTime=" + createTime + ", lastLogInTime=" + lastLogInTime
				+ ", code=" + code + ", codeType=" + codeType + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getHeadFile() {
		return headFile;
	}
	public void setHeadFile(String headFile) {
		this.headFile = headFile;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastLogInTime() {
		return lastLogInTime;
	}
	public void setLastLogInTime(Date lastLogInTime) {
		this.lastLogInTime = lastLogInTime;
	}
	public Integer getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
}
