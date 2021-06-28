package com.omnirio.demo.dto;

import java.io.Serializable;

public class ProductResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private CategoryResponseDto category;

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public CategoryResponseDto getCategory() {
		return category;
	}

	public void setCategory(final CategoryResponseDto category) {
		this.category = category;
	}

}
