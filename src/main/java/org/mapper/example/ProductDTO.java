package org.mapper.example;

import org.mapper.configuration.MapperFieldConfig;

public class ProductDTO {
    private String name;
    private String description;
    @MapperFieldConfig(sourceAttributeName = "value", numericTypeConversion = true)
    private Double price;
    @MapperFieldConfig(numericTypeConversion = true)
    private Integer stoque;

    @Override
    public String toString() {
        return "ProductDTO={" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stoque=" + stoque +
                '}';
    }
}
