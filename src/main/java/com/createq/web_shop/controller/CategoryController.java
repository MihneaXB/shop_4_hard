package com.createq.web_shop.controller;

import com.createq.web_shop.facades.CategoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController {
    private CategoryFacade categoryFacade;

    @Autowired
    public CategoryController(CategoryFacade categoryFacade) {
        this.categoryFacade = categoryFacade;
    }

//    @GetMapping("/categories-page")
//    public String getAllCategories(Model model) {
//        List<ProductCategoryDTO> categories = productCategoryFacade.getAll();
//        model.addAttribute("categories", categories);
//        return "allCategories";
//    }
}
