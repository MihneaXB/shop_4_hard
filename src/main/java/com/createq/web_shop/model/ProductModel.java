package com.createq.web_shop.model;

import jakarta.persistence.*;

@Entity
@Table
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private double price;
    private String imageURL;
    @ManyToOne
    private CategoryModel category;
    private int stock;
    private String specification;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public int getStock() { return stock;}

    public void setStock(int stock) { this.stock = stock;}

    public String getSpecification() { return specification;}

    public void setSpecification(String specification) { this.specification = specification;}

    public String getCategoryName(){
        return category.getName();
    }

}