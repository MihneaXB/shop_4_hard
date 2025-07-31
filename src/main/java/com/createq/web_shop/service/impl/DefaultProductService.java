package com.createq.web_shop.service.impl;

import com.createq.web_shop.model.CategoryModel;
import com.createq.web_shop.model.ProductModel;
import com.createq.web_shop.repository.ProductRepository;
import com.createq.web_shop.service.CategoryService;
import com.createq.web_shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultProductService implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    @Autowired
    public DefaultProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<ProductModel> getAll(){
        return productRepository.findAll();
    }

    @Override
    public List<ProductModel> getProductByCategory(Long categoryId) {
        return productRepository.findByCategory_Id(categoryId, Sort.unsorted());
    }

    @Override
    public List<ProductModel> getProductByCategorySorted(Long categoryId, String sort) {
        Sort sortOption = Sort.unsorted();

        if ("asc".equalsIgnoreCase(sort)) {
            sortOption = Sort.by(Sort.Direction.ASC, "price");
        } else if ("desc".equalsIgnoreCase(sort)) {
            sortOption = Sort.by(Sort.Direction.DESC, "price");
        }

        return productRepository.findByCategory_Id(categoryId, sortOption);
    }

    @Override
    public ProductModel getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void addProduct(String name, String description, double price, Long categoryId, String image, String specificatii, int stock){
        ProductModel productModel = new ProductModel();
        productModel.setName(name);
        productModel.setDescription(description);
        productModel.setPrice(price);
        productModel.setCategory(categoryService.getCategoryById(categoryId));
        productModel.setImageURL(image);
        productModel.setSpecification(specificatii);
        productModel.setStock(stock);
        productRepository.save(productModel);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
