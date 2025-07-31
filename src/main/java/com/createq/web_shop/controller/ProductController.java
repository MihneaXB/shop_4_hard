package com.createq.web_shop.controller;

import com.createq.web_shop.dto.ProductDTO;
import com.createq.web_shop.facades.CategoryFacade;
import com.createq.web_shop.facades.ProductFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Controller
public class ProductController {
    private final ProductFacade productFacade;
    private final CategoryFacade CategoryFacade;

    @Autowired
    public ProductController(ProductFacade productFacade, CategoryFacade CategoryFacade) {
        this.productFacade = productFacade;
        this.CategoryFacade = CategoryFacade;
    }

    @GetMapping("/")
    public String allProducts(Model model) {
        Map<String, List<ProductDTO>> productsPerCategory = productFacade.getAllProductsGroupedByCategory();

        model.addAttribute("productsPerCategory", productsPerCategory);
        model.addAttribute("contentPage", "/WEB-INF/jsp/allCategories.jsp");

        return "index";
    }

    @GetMapping("/products/{categoryId}")
    public String productsByCategory(
            @PathVariable long categoryId,
            @RequestParam(required = false) String sort,
            Model model) {

        List<ProductDTO> productDTOList = productFacade.getProductByCategory(categoryId, sort);

        if (productDTOList.isEmpty()) {
            throw new NoSuchElementException("Nu exista produse in aceasta categorie!");
        }

        model.addAttribute("productDTOList", productDTOList);
        model.addAttribute("categoryName", CategoryFacade.getCategoryName(categoryId));
        model.addAttribute("contentPage", "/WEB-INF/jsp/productList.jsp");

        return "index";
    }

    @GetMapping("/product/{productId}")
    public String productDetailsPage(@PathVariable long productId, Model model) {
        ProductDTO productDTO = productFacade.getProductById(productId);

        model.addAttribute("productDTO", productDTO);
        model.addAttribute("contentPage", "/WEB-INF/jsp/productDetails.jsp");
        return "index";
    }
}
