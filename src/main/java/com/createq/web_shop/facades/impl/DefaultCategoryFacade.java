package com.createq.web_shop.facades.impl;

import com.createq.web_shop.converter.CategoryConverter;
import com.createq.web_shop.dto.CategoryDTO;
import com.createq.web_shop.facades.CategoryFacade;
import com.createq.web_shop.model.CategoryModel;
import com.createq.web_shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public class DefaultCategoryFacade implements CategoryFacade {
    private final CategoryService categoryService;
    private final CategoryConverter categoryConverter;

    @Autowired
    public DefaultCategoryFacade(CategoryService categoryService, CategoryConverter categoryConverter) {
        this.categoryService = categoryService;
        this.categoryConverter = categoryConverter;
    }

    @Override
    public List<CategoryDTO> getAll(){
        List<CategoryModel> models = categoryService.getAll();
        return categoryConverter.convertAll(models);
    }

    @Override
    public String getCategoryName(@PathVariable long categoryId) {
        return categoryService.getCategoryName(categoryId);
    }
}
