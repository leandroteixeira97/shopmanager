package org.shopManager.model.entity;

import org.shopManager.model.enumeration.Color;
import org.shopManager.model.enumeration.Size;

public class Sku {

    private int id;
    private String code;
    private Color color;
    private Size size;
    private Long productId;
    private float price;
    private int amount;

    public Sku() {

    }

    public Sku(String code, Color color, Size size, Long productId, float price, int amount) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.productId = productId;
        this.price = price;
        this.amount = amount;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
