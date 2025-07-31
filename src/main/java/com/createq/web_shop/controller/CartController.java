package com.createq.web_shop.controller;

import com.createq.web_shop.dto.CartItemDTO;
import com.createq.web_shop.dto.ProductDTO;
import com.createq.web_shop.facades.ProductFacade;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class CartController {
    private ProductFacade productFacade;

    @Autowired
    public CartController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @GetMapping("/cart")
    public String viewCart(Model model, HttpSession session){
        List<CartItemDTO> cart = (List<CartItemDTO>) session.getAttribute("cart");
        if(cart == null){
           cart = new ArrayList<>();
        }
        double totalPrice = cart.stream().mapToDouble(CartItemDTO::getTotalPrice).sum();
        model.addAttribute("cart", cart);
        model.addAttribute("totalPrice", totalPrice);
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addCart(Model model, @RequestParam("id") long productId, HttpSession session){
        ProductDTO product = productFacade.getProductById(productId);
        if (product != null) {
            List<CartItemDTO> cart = (List<CartItemDTO>) session.getAttribute("cart");
            if (cart == null) {
                cart = new ArrayList<>();
            }
            Optional<CartItemDTO> existingItem = cart.stream().filter(item -> item.getProduct().getId() == productId).findFirst();

            if (existingItem.isPresent()) {
                existingItem.get().setQuantity(existingItem.get().getQuantity() + 1);
            } else {
                cart.add(new CartItemDTO(product, 1));
            }
            session.setAttribute("cart", cart);
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/remove")
    public String removeCart(Model model, @RequestParam("id") long productId, HttpSession session){
        List<CartItemDTO> cart = (List<CartItemDTO>) session.getAttribute("cart");
        if(cart == null){
            throw new NoSuchElementException("Nu exista cos de cumparaturi!");
        }
        cart.removeIf(p -> p.getProduct().getId() == productId);
        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    @GetMapping("/cart/clear")
    public String clearCart(Model model, HttpSession session){
        session.removeAttribute("cart");
        return "redirect:/cart";
    }

    @PostMapping("/cart/update")
    public String updateQuantities(@RequestParam Map<String, String> quantities, HttpSession session) {
        List<CartItemDTO> cart = (List<CartItemDTO>) session.getAttribute("cart");
        if (cart != null) {
            for (CartItemDTO item : cart) {
                String key = "quantities[" + item.getProduct().getId() + "]";
                if (quantities.containsKey(key)) {
                    try {
                        int qty = Integer.parseInt(quantities.get(key));
                        if (qty > 0) {
                            item.setQuantity(qty);
                        } else {
                            cart.remove(item);
                        }
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
            cart.removeIf(item -> item.getQuantity() <= 0);
            session.setAttribute("cart", cart);
        }
        return "redirect:/cart";
    }
}
