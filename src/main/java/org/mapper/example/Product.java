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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Double getStoque() {
        return stoque;
    }

    public void setStoque(Double stoque) {
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