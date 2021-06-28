package com.omnirio.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnirio.demo.dto.ProductRequestMappingDto;
import com.omnirio.demo.dto.ProductResponseDto;
import com.omnirio.demo.dto.ResponseJson;
import com.omnirio.demo.entity.Product;
import com.omnirio.demo.repos.CategoryRepository;
import com.omnirio.demo.repos.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	public ResponseJson<ProductResponseDto> saveProduct(final ProductRequestMappingDto productDto) {

		final ResponseJson<ProductResponseDto> response = new ResponseJson<>();
		Product product = new Product();
		// map the dto to attribute entity
		product.setName(productDto.getName());
		product.setCategoryId(productDto.getCategoryId());

		product = productRepo.save(product);
		// map attribute back to product response dto
		// add the category to new product
		product.setCategory(categoryRepo.findById(product.getCategoryId()).orElse(null));
		response.setData(mapProductToProductResponseDto(product));

		return response;
	}

	public ResponseJson<ProductResponseDto> findProductById(final Integer productId) {
		final ResponseJson<ProductResponseDto> response = new ResponseJson<>();
		response.setData(mapProductToProductResponseDto(productRepo.findById(productId).orElse(null)));
		return response;
	}

	public static ProductResponseDto mapProductToProductResponseDto(final Product product) {
		ProductResponseDto productResponseDto = null;
		if (product != null) {
			productResponseDto = new ProductResponseDto();
			productResponseDto.setId(product.getId());
			productResponseDto.setName(product.getName());
			productResponseDto.setCategory(CategoryService.mapAttributeToAttributeResponseDto(product.getCategory()));
		}
		return productResponseDto;
	}

}
