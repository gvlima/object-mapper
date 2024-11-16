package model;

import org.mapper.configuration.MapperFieldConfig;

import java.math.BigDecimal;

public class ProductTestCase4 {
    private String name;
    private String description;
    @MapperFieldConfig(sourceAttributeName = "value")
    private BigDecimal price;
    private Double stoque;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getStoque() {
        return stoque;
    }

    public void setStoque(Double stoque) {
        this.stoque = stoque;
    }
}
