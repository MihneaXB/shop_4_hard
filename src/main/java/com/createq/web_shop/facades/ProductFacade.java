package com.createq.web_shop.facades;

import com.createq.web_shop.dto.ProductDTO;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

public interface ProductFacade {
    List<ProductDTO> getAll();
    List<ProductDTO> getProductByCategory(Long categoryId, String sort);
    public Map<String, List<ProductDTO>> getAllProductsGroupedByCategory();
    ProductDTO getProductById(Long id);
}
