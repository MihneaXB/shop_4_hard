package com.createq.web_shop.converter;

import com.createq.web_shop.dto.ProductCategoryDTO;
import com.createq.web_shop.model.ProductCategoryModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductCategoryConverter {
    private final ProductConverter productConverter;

    public ProductCategoryConverter(ProductConverter productConverter) {
        this.productConverter = productConverter;
    }

    public ProductCategoryDTO converter(ProductCategoryModel productCategoryModel) {
        if(productCategoryModel == null) return null;
        ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
        productCategoryDTO.setId(productCategoryModel.getId());
        productCategoryDTO.setName(productCategoryModel.getName());
        productCategoryDTO.setProducts(productConverter.convertAll(productCategoryModel.getProducts(productCategoryModel.getId())));
        return productCategoryDTO;
    }

    public List<ProductCategoryDTO> convertAll(List<ProductCategoryModel> productCategoryModels) {
        return productCategoryModels.stream().map(this::converter).collect(Collectors.toList());
    }
}
