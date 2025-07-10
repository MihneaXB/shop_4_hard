package com.createq.web_shop.service.impl;

import com.createq.web_shop.model.ProductCategoryModel;
import com.createq.web_shop.repository.ProductCategoryRepository;
import com.createq.web_shop.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class DefaultProductCategoryService implements ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryRepository getProductCategoryRepository() {
        return productCategoryRepository;
    }

    @Autowired
    public DefaultProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public List<ProductCategoryModel> getAll(){
        return productCategoryRepository.findAll();
    }

    @Override
    public String getCategoryName(@PathVariable long categoryId) {
        return productCategoryRepository.findById(categoryId).get().getName();
    }
}
