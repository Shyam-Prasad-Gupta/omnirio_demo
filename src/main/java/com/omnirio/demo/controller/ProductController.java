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

import com.omnirio.demo.dto.ProductRequestMappingDto;
import com.omnirio.demo.dto.ProductResponseDto;
import com.omnirio.demo.dto.ResponseJson;
import com.omnirio.demo.service.ProductService;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(path = "/{productid}")
	public ResponseJson<ProductResponseDto> getProductById(@PathVariable(value = "productid") final Integer productId,
			final HttpServletRequest httpRequest, final HttpServletResponse httpResponse) {
		try {
			final ResponseJson<ProductResponseDto> response = productService.findProductById(productId);
			if (response.getData() == null)
				httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return response;
		} catch (final Exception ex) {
			httpResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			ex.printStackTrace();
		}
		return null;
	}

	@PostMapping
	public ResponseJson<ProductResponseDto> createProduct(@RequestBody final ProductRequestMappingDto product,
			final HttpServletRequest request, final HttpServletResponse response) {
		try {
			return productService.saveProduct(product);
		} catch (final Exception ex) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			ex.printStackTrace();
		}
		return null;
	}

}
