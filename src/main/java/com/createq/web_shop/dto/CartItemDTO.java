package com.createq.web_shop.dto;

public class CartItemDTO {
    private ProductDTO product;
    private int quantity;

    public CartItemDTO(ProductDTO product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}
