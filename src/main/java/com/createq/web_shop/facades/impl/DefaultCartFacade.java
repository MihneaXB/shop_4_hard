package com.createq.web_shop.facades.impl;

import com.createq.web_shop.dto.CartItemDTO;
import com.createq.web_shop.dto.ProductDTO;
import com.createq.web_shop.facades.CartFacade;
import com.createq.web_shop.service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultCartFacade implements CartFacade {
    private CartService cartService;

    @Autowired
    public DefaultCartFacade(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public void addProduct(HttpSession session, ProductDTO productDTO) {
        cartService.addToCart(session, productDTO);
    }

    @Override
    public void removeProduct(HttpSession session, ProductDTO productDTO) {
        cartService.removeFromCart(session, productDTO.getId());
    }

    @Override
    public void clearCart(HttpSession session) {
        cartService.clearCart(session);
    }

    @Override
    public List<CartItemDTO> getCartItems(HttpSession session) {
        return cartService.getCartItems(session);
    }

    @Override
    public double getTotalPrice(HttpSession session) {
        return cartService.getTotalPrice(session);
    }
}
