package com.omnirio.demo.entity;

//@Entity
//@Table(name = "category_attribute_mapping")
public class CategoryAttributeMapping {

	// @Column(name = "category_id")
	private Integer categoryId;

	// @Column(name = "attribute_id")
	private Integer attributeId;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(final Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(final Integer attributeId) {
		this.attributeId = attributeId;
	}

}
