package com.createq.web_shop.facades;

import com.createq.web_shop.dto.ProductCategoryDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductCategoryFacade {
    List<ProductCategoryDTO> getAll();
    public String getCategoryName(@PathVariable long categoryId);
}
