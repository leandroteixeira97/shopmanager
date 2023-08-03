package org.shopManager.model.entity;

import org.shopManager.model.enumeration.CategoryType;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private Long id;
    private String name;
    private CategoryType category;
    private String brand;
    private List<Sku> skus;

    public Product() {
        this.skus = new ArrayList<>();
    }

    public Product(String name, CategoryType category, String brand, List<Sku> skus) {
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.skus = skus;
    }

    public Product(Long id, String name, CategoryType category, String brand, List<Sku> skus) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.skus = skus;
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

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void addSku(Sku sku) {
        this.skus.add(sku);
    }
}
