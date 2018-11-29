package com.lll.shop.pojo;

import java.util.Date;

public class VerifyCode {
	private Integer id;
	private String cellPhone;// 手机号
	private String code;//验证码
	private Integer codeType;// 验证码类型
	private Date createTime;// 创建时间
	@Override
	public String toString() {
		return "VerifyCode [id=" + id + ", cellPhone=" + cellPhone + ", code=" + code + ", codeType=" + codeType
				+ ", createTime=" + createTime + "]";
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getCodeType() {
		return codeType;
	}
	public void setCodeType(Integer codeType) {
		this.codeType = codeType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
