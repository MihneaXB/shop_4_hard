package com.createq.web_shop.facades;

import com.createq.web_shop.dto.CartItemDTO;
import com.createq.web_shop.dto.ProductDTO;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface CartFacade {
    void addProduct(HttpSession session, ProductDTO productDTO);
    void removeProduct(HttpSession session, ProductDTO productDTO);
    void clearCart(HttpSession session);
    List<CartItemDTO> getCartItems(HttpSession session);
    double getTotalPrice(HttpSession session);
}
