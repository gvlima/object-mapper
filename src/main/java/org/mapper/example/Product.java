package org.mapper.example;

import java.math.BigDecimal;

public class Product {
    private String id;
    private String name;
    private String description;
    private BigDecimal value;
    private Double stoque;

    public Product(String id, String name, String description, BigDecimal value, Double stoque) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.stoque = stoque;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", stoque=" + stoque +
                '}';
    }
}