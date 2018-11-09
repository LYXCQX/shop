package com.lll.shop.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 请求记录
 * 
 * @author Administrator
 *
 */
public class OrdersPojo {

	private Integer id;
	private BigDecimal amount;// 申请金额
	private Integer cellPhone;// 申请人手机号
	private Integer idCard;// 申请人身份证
	private Integer pid;// 产品id
	private String name;// 姓名
	private String ip;// 申请ip
	private String remarks;// 申请备注
	private String address;// 申请地址
	private String bankCardNo;// 申请银行卡号
	private String bankCardName;// 银行名称
	private BigDecimal fee;// 手续费
	private Integer days;// 期限天数
	private Integer type;//状态（0申请，1贷超）
	private Date createTime;// 创建时间

	@Override
	public String toString() {
		return "OrdersPojo [id=" + id + ", amount=" + amount + ", cellPhone=" + cellPhone + ", idCard=" + idCard
				+ ", pid=" + pid + ", name=" + name + ", ip=" + ip + ", remarks=" + remarks + ", address=" + address
				+ ", bankCardNo=" + bankCardNo + ", bankCardName=" + bankCardName + ", fee=" + fee + ", days=" + days
				+ ", type=" + type + ", createTime=" + createTime + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(Integer cellPhone) {
		this.cellPhone = cellPhone;
	}

	public Integer getIdCard() {
		return idCard;
	}

	public void setIdCard(Integer idCard) {
		this.idCard = idCard;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

	public String getBankCardName() {
		return bankCardName;
	}

	public void setBankCardName(String bankCardName) {
		this.bankCardName = bankCardName;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
