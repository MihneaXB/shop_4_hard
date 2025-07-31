package com.createq.web_shop.controller;


import com.createq.web_shop.service.ProductService;
import com.createq.web_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    private UserService userService;
    private ProductService productService;

    @Autowired
    public AdminController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/admin")
    public String adminDashboard(Model model) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("products", productService.getAll());
        return "admin";
    }

    @PostMapping("/admin/createUser")
    public String createUser(@RequestParam String username, @RequestParam String password, @RequestParam String role) {
        userService.createNewUser(username, password, role);
        return "redirect:/admin";
    }

    @PostMapping("/admin/deleteUser")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @PostMapping("/admin/addProduct")
    public String addProduct(@RequestParam String name, @RequestParam String description, @RequestParam double price, @RequestParam long category, @RequestParam String image, @RequestParam String specificatii, @RequestParam int stock) {
        productService.addProduct(name, description, price, category, image, specificatii, stock);
        return "redirect:/admin";
    }

    @PostMapping("/admin/deleteProduct")
    public String deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin";
    }
}
