package com.omnirio.demo.dto;

import java.io.Serializable;

public class CategoryRequestMappingDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String attributeIds;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getAttributeIds() {
		return attributeIds;
	}

	public void setAttributeIds(final String attributeIds) {
		this.attributeIds = attributeIds;
	}

}
