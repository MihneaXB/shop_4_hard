package com.createq.web_shop.facades;

import com.createq.web_shop.dto.CategoryDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CategoryFacade {
    List<CategoryDTO> getAll();
    public String getCategoryName(@PathVariable long categoryId);
}
