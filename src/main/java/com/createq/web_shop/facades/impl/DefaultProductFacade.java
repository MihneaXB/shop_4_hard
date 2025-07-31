package com.createq.web_shop.facades.impl;

import com.createq.web_shop.converter.ProductConverter;
import com.createq.web_shop.dto.ProductDTO;
import com.createq.web_shop.facades.ProductFacade;
import com.createq.web_shop.model.ProductModel;
import com.createq.web_shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DefaultProductFacade implements ProductFacade {
    private final ProductService productService;
    private final ProductConverter productConverter;

    @Autowired
    public DefaultProductFacade(ProductService productService, ProductConverter productConverter) {
        this.productService = productService;
        this.productConverter = productConverter;
    }

    @Override
    public List<ProductDTO> getAll() {
        List<ProductModel> models = productService.getAll();
        return productConverter.convertAll(models);
    }

    @Override
    public List<ProductDTO> getProductByCategory(Long categoryId, String sort) {
        List<ProductModel> models = productService.getProductByCategory(categoryId);
        return productConverter.convertAll(models);
    }

    @Override
    public Map<String, List<ProductDTO>> getAllProductsGroupedByCategory() {
        List<ProductDTO> allProducts = getAll();

        return allProducts.stream().filter(productDTO -> productDTO.getCategory() != null).collect(Collectors.groupingBy(ProductDTO::getCategory));
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        ProductModel model = productService.getProductById(productId);

        return productConverter.converter(model);
    }
}