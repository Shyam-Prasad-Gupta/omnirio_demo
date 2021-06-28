package com.omnirio.demo.dto;

import java.io.Serializable;

public class AttributeResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer attributeId;

	private String attributeName;

	private String attributeValue;

	public AttributeResponseDto() {
	}

	public AttributeResponseDto(final Integer id, final String name, final String value) {
		attributeId = id;
		attributeName = name;
		attributeValue = value;
	}

	public Integer getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(final Integer attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(final String attributeName) {
		this.attributeName = attributeName;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(final String attributeValue) {
		this.attributeValue = attributeValue;
	}

}
