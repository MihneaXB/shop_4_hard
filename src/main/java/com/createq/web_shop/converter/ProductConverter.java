package com.createq.web_shop.converter;

import com.createq.web_shop.dto.ProductDTO;
import com.createq.web_shop.model.ProductModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter {
    public ProductDTO converter(ProductModel productModel){
        if(productModel == null) return null;
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productModel.getId());
        productDTO.setTitle(productModel.getTitle());
        productDTO.setPrice(productModel.getPrice());
        productDTO.setDescription(productModel.getDescription());
        productDTO.setImageURL(productModel.getImageURL());
        productDTO.setCategory(productModel.getCategory().getName());
        return productDTO;
    }

    public List<ProductDTO> convertAll(List<ProductModel> productsModel){
        return productsModel.stream().map(this::converter).collect(Collectors.toList());
    }
}
