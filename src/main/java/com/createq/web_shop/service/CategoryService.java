package com.createq.web_shop.service;

import com.createq.web_shop.model.CategoryModel;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CategoryService {
    List<CategoryModel> getAll();
    public String getCategoryName(@PathVariable long categoryId);
    public CategoryModel getCategoryById(@PathVariable long categoryId);
}
