package com.omnirio.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omnirio.demo.dto.CategoryRequestMappingDto;
import com.omnirio.demo.dto.CategoryResponseDto;
import com.omnirio.demo.dto.ResponseJson;
import com.omnirio.demo.repos.CategoryRepository;
import com.omnirio.demo.service.CategoryService;

@RestController
@RequestMapping(value = "/api/category", produces = { "application/json" })
public class CategoryController {

	@Autowired
	private CategoryRepository repo;

	@Autowired
	private CategoryService categoryService;

	@GetMapping(path = "/{categoryid}")
	public ResponseJson<CategoryResponseDto> getCategoryById(
			@PathVariable(value = "categoryid") final Integer categoryId, final HttpServletRequest httpRequest,
			final HttpServletResponse httpResponse) {
		ResponseJson<CategoryResponseDto> response = null;
		try {
			response = categoryService.getCategoryById(categoryId);
			if (response.getData() == null) {
				httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
			}
		} catch (final Exception ex) {
			httpResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			ex.printStackTrace();
		}
		return response;
	}

	@PostMapping
	public ResponseJson<CategoryResponseDto> createCategory(@RequestBody final CategoryRequestMappingDto category,
			final HttpServletRequest httpRequest, final HttpServletResponse httpResponse) {

		try {
			return categoryService.saveCategory(category);
		} catch (final Exception ex) {
			httpResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			ex.printStackTrace();
		}
		return null;
	}

}
