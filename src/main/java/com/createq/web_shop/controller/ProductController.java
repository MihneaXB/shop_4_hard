package com.createq.web_shop.controller;

import com.createq.web_shop.dto.ProductDTO;
import com.createq.web_shop.facades.CategoryFacade;
import com.createq.web_shop.facades.ProductFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Controller
public class ProductController {
    private final ProductFacade productFacade;
    private final CategoryController categoryController;

    @Autowired
    public ProductController(ProductFacade productFacade, CategoryController categoryController) {
        this.productFacade = productFacade;
        this.categoryController = categoryController;
    }

    @GetMapping("/")
    public String allProducts(Model model) {
        Map<String, List<ProductDTO>> productsPerCategory = productFacade.getAllProductsGroupedByCategory();
        model.addAttribute("productsPerCategory", productsPerCategory);
        model.addAttribute("contentPage", "/WEB-INF/jsp/allCategories.jsp");

        return "index";
    }

    @GetMapping("/products/{categoryId}")
    public String productsByCategory(@PathVariable long categoryId, Model model) {
        List<ProductDTO> productDTOList = productFacade.getProductByCategory(categoryId);

        if(productDTOList.isEmpty()) {
           throw new NoSuchElementException("No products in this category!");
        }

        model.addAttribute("productDTOList", productDTOList);
        model.addAttribute("categoryName", categoryController.getCategoryName(categoryId));
        model.addAttribute("contentPage", "/WEB-INF/jsp/productList.jsp");

        return "index";
    }
}
