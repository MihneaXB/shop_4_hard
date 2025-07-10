package com.createq.web_shop.controller;

import com.createq.web_shop.dto.ProductDTO;
import com.createq.web_shop.facades.ProductCategoryFacade;
import com.createq.web_shop.facades.ProductFacade;
import com.createq.web_shop.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ProductController {
    private final ProductFacade productFacade;
    private final ProductCategoryFacade productCategoryFacade;

    @Autowired
    public ProductController(ProductFacade productFacade, ProductCategoryRepository productCategoryRepository, ProductCategoryFacade productCategoryFacade) {
        this.productFacade = productFacade;
        this.productCategoryFacade = productCategoryFacade;
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
        model.addAttribute("productDTOList", productDTOList);
        model.addAttribute("categoryName", productCategoryFacade.getCategoryName(categoryId));
        model.addAttribute("contentPage", "/WEB-INF/jsp/productList.jsp");

        return "index";
    }
}
