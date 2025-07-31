package com.createq.web_shop.service.impl;

import com.createq.web_shop.model.CategoryModel;
import com.createq.web_shop.repository.CategoryRepository;
import com.createq.web_shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class DefaultCategoryService implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryRepository getProductCategoryRepository() {
        return categoryRepository;
    }

    @Autowired
    public DefaultCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryModel> getAll(){
        return categoryRepository.findAll();
    }

    @Override
    public String getCategoryName(@PathVariable long categoryId) {
        return categoryRepository.findById(categoryId).get().getName();
    }

    @Override
    public CategoryModel getCategoryById(@PathVariable long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }
}
