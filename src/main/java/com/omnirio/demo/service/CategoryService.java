package com.omnirio.demo.service;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnirio.demo.dto.AttributeResponseDto;
import com.omnirio.demo.dto.CategoryRequestMappingDto;
import com.omnirio.demo.dto.CategoryResponseDto;
import com.omnirio.demo.dto.ResponseJson;
import com.omnirio.demo.entity.Category;
import com.omnirio.demo.repos.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private AttributeService attributeService;

	public ResponseJson<CategoryResponseDto> saveCategory(final CategoryRequestMappingDto categoryRequestDto) {

		final ResponseJson<CategoryResponseDto> response = new ResponseJson<>();
		Category category = new Category();
		// map the dto to category entity
		category.setName(categoryRequestDto.getName());
		if (StringUtils.isNotBlank(categoryRequestDto.getAttributeIds())) {
			final String[] attributeIds = categoryRequestDto.getAttributeIds().split(",");
			category.setAttributes(attributeService.findAttributesById(Arrays.asList(attributeIds).stream()
					.map(str -> Integer.valueOf(str)).collect(Collectors.toList())));
		}

		// save category to DB
		category = categoryRepo.save(category);

		response.setData(mapAttributeToAttributeResponseDto(category));

		return response;
	}

	public ResponseJson<CategoryResponseDto> getCategoryById(final Integer categoryId) {
		final ResponseJson<CategoryResponseDto> response = new ResponseJson<>();
		final Category category = categoryRepo.findById(categoryId).orElse(null);

		// map category to category dto
		response.setData(mapAttributeToAttributeResponseDto(category));
		return response;
	}

	public static CategoryResponseDto mapAttributeToAttributeResponseDto(final Category category) {
		CategoryResponseDto categoryResponseDto = null;
		if (category != null) {
			categoryResponseDto = new CategoryResponseDto();
			categoryResponseDto.setId(category.getId());
			categoryResponseDto.setName(category.getName());

			categoryResponseDto.setAttributes(category.getAttributes().stream().map(
					attribute -> new AttributeResponseDto(attribute.getId(), attribute.getName(), attribute.getValue()))
					.collect(Collectors.toList()));

		}
		return categoryResponseDto;
	}

}
