package com.lll.shop.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 产品表
 * 
 * @author Administrator
 *
 */
public class ProductPojo {
	private Integer id;
	private String name;// 产品名称
	private String company;// 公司
//	private String contact;// 联系人姓名
//	private String contactPhone;// 联系人手机号码
	private String introduce;// 产品简介
	private String logo;// 产品logo
	private String url;// 产品推广链接
	private Integer isDetail;// 是否有详情页(0 有，1没有)
	private String type;// 产品类型(0秒下款，1额度高，2周期长，3黑户贷款，4利息低)
	private String applyCondition;// 申请条件
	private String applyInformation;// 申请资料
	private Integer startQuota;// 开始额度
	private Integer endQuota;// 结束额度
	private BigDecimal rate;// 利息
	private Integer passRate;// 通过率
	private Integer isPop;// 是否推广(0推广，1不推广)
	private Integer cycle;// 贷款周期开始
	private Integer endCycle;// 贷款周期结束
	private String cycleType;// 周期类型(0天,1月)
	private String auditLong;// 审核时长
	private Integer applyCount;// 申请人数
	private Integer isCredit;// 是否需要征信(0不需要，1需要)
	private String auditType;// 审核方式
	private Integer sort;// 排序
	private String remark;
	private Integer ptype;
	private Date createTime;// 创建时间
	private Date updateTime;// 修改时间
	private Map<String, String> typeM = new HashMap<String, String>();
	private String typeS ="";
	private String servicePhone ="";
	private int ftype;

	@Override
	public String toString() {
		return "ProductPojo [id=" + id + ", name=" + name + ", company=" + company + ", introduce=" + introduce
				+ ", logo=" + logo + ", url=" + url + ", isDetail=" + isDetail + ", type=" + type + ", applyCondition="
				+ applyCondition + ", applyInformation=" + applyInformation + ", startQuota=" + startQuota
				+ ", endQuota=" + endQuota + ", rate=" + rate + ", passRate=" + passRate + ", isPop=" + isPop
				+ ", cycle=" + cycle + ", endCycle=" + endCycle + ", cycleType=" + cycleType + ", auditLong="
				+ auditLong + ", applyCount=" + applyCount + ", isCredit=" + isCredit + ", auditType=" + auditType
				+ ", sort=" + sort + ", remark=" + remark + ", ptype=" + ptype + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", typeM=" + typeM + ", typeS=" + typeS + ", servicePhone="
				+ servicePhone + ", ftype=" + ftype + "]";
	}

	public void init() {
		typeM.put("0", "秒下款");
		typeM.put("1", "额度高");
		typeM.put("2", "周期长");
		typeM.put("3", "黑户贷款");
		typeM.put("4", "利息低");
		if (type != null) {
			for (String ty : type.split(",")) {
				typeS += typeM.get(ty) != null ? (typeM.get(ty) + " , ") : "";
			}
		}
	}

	public Integer getId() {
		return id;
	}

	public ProductPojo setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getAuditLong() {
		return auditLong;
	}

	public void setAuditLong(String auditLong) {
		this.auditLong = auditLong;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getIsDetail() {
		return isDetail;
	}

	public void setIsDetail(Integer isDetail) {
		this.isDetail = isDetail;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
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

	public Integer getIsPop() {
		return isPop;
	}

	public void setIsPop(Integer isPop) {
		this.isPop = isPop;
	}

	public String getApplyCondition() {
		return applyCondition;
	}

	public void setApplyCondition(String applyCondition) {
		this.applyCondition = applyCondition;
	}

	public String getApplyInformation() {
		return applyInformation;
	}

	public void setApplyInformation(String applyInformation) {
		this.applyInformation = applyInformation;
	}

	public Integer getCycle() {
		return cycle;
	}

	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}

	public Integer getEndCycle() {
		return endCycle;
	}

	public void setEndCycle(Integer endCycle) {
		this.endCycle = endCycle;
	}

	public String getCycleType() {
		return cycleType;
	}

	public void setCycleType(String cycleType) {
		this.cycleType = cycleType;
	}

	public Integer getApplyCount() {
		return applyCount;
	}

	public void setApplyCount(Integer applyCount) {
		this.applyCount = applyCount;
	}

	public Integer getIsCredit() {
		return isCredit;
	}

	public void setIsCredit(Integer isCredit) {
		this.isCredit = isCredit;
	}

	public String getAuditType() {
		return auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Map<String, String> getTypeM() {
		return typeM;
	}

	public void setTypeM(Map<String, String> typeM) {
		this.typeM = typeM;
	}

	public String getTypeS() {
		return typeS;
	}

	public void setTypeS(String typeS) {
		this.typeS = typeS;
	}

	public String getServicePhone() {
		return servicePhone;
	}

	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone;
	}

	public int getFtype() {
		return ftype;
	}

	public void setFtype(int ftype) {
		this.ftype = ftype;
	}

	public Integer getPtype() {
		return ptype;
	}

	public void setPtype(Integer ptype) {
		this.ptype = ptype;
	}

}
