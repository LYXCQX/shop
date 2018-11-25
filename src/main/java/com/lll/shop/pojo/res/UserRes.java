package com.lll.shop.pojo.res;

public class UserRes {
	private Integer id;
	private String cellPhone;// 手机号
	private String nickName;// 姓名
	private String headFile;// 头像路径
	private String signature;
	private String loginId;
	@Override
	public String toString() {
		return "UserRes [id=" + id + ", cellPhone=" + cellPhone + ", nickName=" + nickName + ", headFile=" + headFile
				+ ", signature=" + signature + ", loginId=" + loginId + "]";
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
	public String getHeadFile() {
		return headFile;
	}
	public void setHeadFile(String headFile) {
		this.headFile = headFile;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
}

