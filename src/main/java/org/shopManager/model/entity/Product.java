package org.shopManager.model.entity;

import org.shopManager.model.enumeration.CategoryType;

import java.util.List;

public class Product {

    private Long id;
    private String name;
    private CategoryType category;
    private Double price;
    private String image;
    private List<Sku> skus;

    public Product() {

    }

    public Product(String name, CategoryType category, Double price, String image, List<Sku> skus) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.image = image;
    }

    public Product(Long id, String name, CategoryType category, Double price, String image, List<Sku> skus) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }
}
