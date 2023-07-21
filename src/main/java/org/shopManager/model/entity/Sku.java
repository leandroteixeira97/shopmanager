package org.shopManager.model.entity;

import org.shopManager.model.enumeration.Color;
import org.shopManager.model.enumeration.Size;

public class Sku {

    private int id;
    private String code;
    private Color color;
    private Size size;
    private int productId;
    private Double price;

    public Sku() {

    }

    public Sku(String code, Color color, Size size, int productId, Double price) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.productId = productId;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
