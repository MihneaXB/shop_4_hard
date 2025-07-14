package com.createq.web_shop.converter;

import com.createq.web_shop.dto.CategoryDTO;
import com.createq.web_shop.model.CategoryModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryConverter {
    private final ProductConverter productConverter;

    public CategoryConverter(ProductConverter productConverter) {
        this.productConverter = productConverter;
    }

    public CategoryDTO converter(CategoryModel categoryModel) {
        if(categoryModel == null) return null;
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryModel.getId());
        categoryDTO.setName(categoryModel.getName());
        categoryDTO.setProducts(productConverter.convertAll(categoryModel.getProducts(categoryModel.getId())));
        return categoryDTO;
    }

    public List<CategoryDTO> convertAll(List<CategoryModel> categoryModels) {
        return categoryModels.stream().map(this::converter).collect(Collectors.toList());
    }
}
