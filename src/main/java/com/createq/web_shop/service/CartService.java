package com.createq.web_shop.service;

import com.createq.web_shop.dto.CartItemDTO;
import com.createq.web_shop.dto.ProductDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CartService {
    void addToCart(HttpSession session, ProductDTO productDTO);
    void removeFromCart(HttpSession session, @PathVariable long productId);
    void clearCart(HttpSession session);
    List<CartItemDTO> getCartItems(HttpSession session);
    double getTotalPrice(HttpSession session);
}
