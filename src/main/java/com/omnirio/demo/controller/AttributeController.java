package com.omnirio.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omnirio.demo.dto.AttributeRequestMappingDto;
import com.omnirio.demo.dto.AttributeResponseDto;
import com.omnirio.demo.dto.ResponseJson;
import com.omnirio.demo.service.AttributeService;

@RestController
@RequestMapping(value = "/api/attribute", produces = { "application/json" })
public class AttributeController {

	@Autowired
	private AttributeService attributeService;

	@PostMapping
	public ResponseJson<AttributeResponseDto> createCategory(
			@RequestBody final AttributeRequestMappingDto attribute, final HttpServletRequest httpRequest,
			final HttpServletResponse httpResponse) {
		try {
			return attributeService.saveAttribute(attribute);
		} catch (final Exception ex) {
			httpResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			ex.printStackTrace();
		}
		return null;
	}

}
