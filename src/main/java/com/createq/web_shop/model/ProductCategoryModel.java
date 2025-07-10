package com.createq.web_shop.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class ProductCategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<ProductModel> products;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductModel> getProducts(int id) {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }
}
