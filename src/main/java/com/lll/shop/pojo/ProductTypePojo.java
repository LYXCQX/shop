package com.lll.shop.pojo;

/**
 * 产品类型
 * @author Administrator
 *
 */
public class ProductTypePojo {

	private Integer id;
	private String typeName;// 产品类型
	@Override
	public String toString() {
		return "ProductTypePojo [id=" + id + ", typeName=" + typeName + "]";
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
	
}
