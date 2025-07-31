package com.createq.web_shop.service;

import com.createq.web_shop.dto.ProductDTO;
import com.createq.web_shop.model.ProductModel;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductService {
    List<ProductModel> getAll();

    List<ProductModel> getProductByCategory(Long categoryId);

    List<ProductModel> getProductByCategorySorted(Long categoryId, String sort);

    ProductModel getProductById(Long productId);

    void addProduct(String name, String description, double price, Long categoryId, String image, String specificatii, int stock);

    void deleteProduct(Long productId);
}
