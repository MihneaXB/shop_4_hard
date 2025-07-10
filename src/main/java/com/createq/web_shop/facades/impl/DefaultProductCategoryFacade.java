package com.createq.web_shop.facades.impl;

import com.createq.web_shop.converter.ProductCategoryConverter;
import com.createq.web_shop.dto.ProductCategoryDTO;
import com.createq.web_shop.facades.ProductCategoryFacade;
import com.createq.web_shop.model.ProductCategoryModel;
import com.createq.web_shop.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public class DefaultProductCategoryFacade implements ProductCategoryFacade {
    private final ProductCategoryService productCategoryService;
    private final ProductCategoryConverter productCategoryConverter;

    @Autowired
    public DefaultProductCategoryFacade(ProductCategoryService productCategoryService, ProductCategoryConverter productCategoryConverter) {
        this.productCategoryService = productCategoryService;
        this.productCategoryConverter = productCategoryConverter;
    }

    @Override
    public List<ProductCategoryDTO> getAll(){
        List<ProductCategoryModel> models = productCategoryService.getAll();
        return productCategoryConverter.convertAll(models);
    }

    @Override
    public String getCategoryName(@PathVariable long categoryId) {
        return productCategoryService.getCategoryName(categoryId);
    }
}
