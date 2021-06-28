package com.omnirio.demo.dto;

import java.io.Serializable;

public class ProductRequestMappingDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private Integer categoryId;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(final Integer categoryId) {
		this.categoryId = categoryId;
	}

}
