package com.createq.web_shop.service;

import com.createq.web_shop.model.ProductCategoryModel;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategoryModel> getAll();
    public String getCategoryName(@PathVariable long categoryId);
}
