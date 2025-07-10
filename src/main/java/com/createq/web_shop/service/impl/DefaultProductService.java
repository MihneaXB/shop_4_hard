package com.createq.web_shop.service.impl;

import com.createq.web_shop.converter.ProductConverter;
import com.createq.web_shop.dto.ProductDTO;
import com.createq.web_shop.model.ProductModel;
import com.createq.web_shop.repository.ProductRepository;
import com.createq.web_shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultProductService implements ProductService {
    private final ProductRepository productRepository;

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    @Autowired
    public DefaultProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductModel> getAll(){
        return productRepository.findAll();
    }

    @Override
    public List<ProductModel> getProductByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }
}
