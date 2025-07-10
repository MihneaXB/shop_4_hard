package com.createq.web_shop.facades.impl;

import com.createq.web_shop.converter.ProductConverter;
import com.createq.web_shop.dto.ProductDTO;
import com.createq.web_shop.facades.ProductFacade;
import com.createq.web_shop.model.ProductModel;
import com.createq.web_shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
    public List<ProductDTO> getProductByCategory(Long categoryId) {
        List<ProductModel> models = productService.getProductByCategory(categoryId);
        return productConverter.convertAll(models);
    }
}