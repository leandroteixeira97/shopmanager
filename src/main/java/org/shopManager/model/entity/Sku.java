package org.shopManager.model.entity;

import org.shopManager.model.enumeration.Color;
import org.shopManager.model.enumeration.Size;

public class Sku {

    private String code;
    private Color color;
    private Size size;
    private Product product;

    public Sku() {

    }

    public Sku(String code, Color color, Size size, Product product) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
