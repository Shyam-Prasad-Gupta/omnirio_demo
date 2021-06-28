package com.omnirio.demo.dto;

import java.io.Serializable;
import java.util.List;

public class CategoryResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private List<AttributeResponseDto> attributes;

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

	public List<AttributeResponseDto> getAttributes() {
		return attributes;
	}

	public void setAttributes(final List<AttributeResponseDto> attributes) {
		this.attributes = attributes;
	}

}
