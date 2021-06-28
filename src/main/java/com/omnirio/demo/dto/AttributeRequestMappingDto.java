package com.omnirio.demo.dto;

import java.io.Serializable;

public class AttributeRequestMappingDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String attributeName;

	private String attributeValue;

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
