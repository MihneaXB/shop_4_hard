package com.createq.web_shop.facades;

import com.createq.web_shop.dto.ProductDTO;
import java.util.List;
import java.util.Map;

public interface ProductFacade {
    List<ProductDTO> getAll();
    List<ProductDTO> getProductByCategory(Long categoryId);
    public Map<String, List<ProductDTO>> getAllProductsGroupedByCategory();
}
