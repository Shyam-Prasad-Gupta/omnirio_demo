package com.omnirio.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnirio.demo.dto.AttributeRequestMappingDto;
import com.omnirio.demo.dto.AttributeResponseDto;
import com.omnirio.demo.dto.ResponseJson;
import com.omnirio.demo.entity.Attribute;
import com.omnirio.demo.repos.AttributeRepository;

@Service
public class AttributeService {

	@Autowired
	private AttributeRepository attributeRepo;

	public ResponseJson<AttributeResponseDto> saveAttribute(final AttributeRequestMappingDto attributeRequestDto) {

		final ResponseJson<AttributeResponseDto> response = new ResponseJson<>();
		Attribute attribute = new Attribute();
		// map the dto to attribute entity
		attribute.setName(attributeRequestDto.getAttributeName());
		attribute.setValue(attributeRequestDto.getAttributeValue());

		attribute = attributeRepo.save(attribute);
		// map attribute back to response dto
		response.setData(new AttributeResponseDto(attribute.getId(), attribute.getName(), attribute.getValue()));

		return response;
	}

	public List<Attribute> findAttributesById(final Iterable<Integer> attributeIds) {
		return attributeRepo.findAllById(attributeIds);

	}

}
