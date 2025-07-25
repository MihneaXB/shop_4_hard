package com.createq.web_shop.service;

import com.createq.web_shop.dto.ProductDTO;
import com.createq.web_shop.model.ProductModel;

import java.util.List;

public interface ProductService {
    List<ProductModel> getAll();

    List<ProductModel> getProductByCategory(Long categoryId);
}
