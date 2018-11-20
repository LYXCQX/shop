package com.lll.shop.pojo;

/**
 * 产品类型
 * @author Administrator
 *
 */
public class ProductTypePojo {

	private Integer id;
	private String typeName;// 产品类型
	private String type;
	private String typeValue;
	@Override
	public String toString() {
		return "ProductTypePojo [id=" + id + ", typeName=" + typeName + ", type=" + type + ", typeValue=" + typeValue
				+ "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeValue() {
		return typeValue;
	}
	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}
	
}
