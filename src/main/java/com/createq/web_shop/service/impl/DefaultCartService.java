package com.createq.web_shop.service.impl;

import com.createq.web_shop.dto.CartItemDTO;
import com.createq.web_shop.dto.ProductDTO;
import com.createq.web_shop.service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Iterator;
import java.util.List;


@Service
public class DefaultCartService implements CartService {
    private static final String CART_SESSION_KEY = "cart";

    @Override
    public void addToCart(HttpSession session, ProductDTO productDTO){
        List<CartItemDTO> cartItemDTOList = getCartItems(session);
        for (CartItemDTO cartItemDTO : cartItemDTOList) {
            if(cartItemDTO.getProduct().getId() == productDTO.getId()){
                cartItemDTO.setQuantity(cartItemDTO.getQuantity() + 1);
                session.setAttribute(CART_SESSION_KEY, cartItemDTOList);
                return;
            }
        }
        cartItemDTOList.add(new CartItemDTO(productDTO, 1));
        session.setAttribute(CART_SESSION_KEY, cartItemDTOList);
    }

    @Override
    public void removeFromCart(HttpSession session, @PathVariable long productId) {
        List<CartItemDTO> cartItemDTOList = getCartItems(session);
        Iterator<CartItemDTO> iterator = cartItemDTOList.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getProduct().getId() == productId){
                iterator.remove();
                break;
            }
        }
        session.setAttribute(CART_SESSION_KEY, cartItemDTOList);
    }

    @Override
    public void clearCart(HttpSession session) {
        session.removeAttribute(CART_SESSION_KEY);
    }

    @Override
    public List<CartItemDTO> getCartItems(HttpSession session) {
        List<CartItemDTO> cartItemDTOList = (List<CartItemDTO>) session.getAttribute(CART_SESSION_KEY);
        return cartItemDTOList;
    }

    @Override
    public double getTotalPrice(HttpSession session) {
        return getCartItems(session).stream().mapToDouble(CartItemDTO::getTotalPrice).sum();
    }
}
