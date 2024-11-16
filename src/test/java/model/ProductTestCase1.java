package model;

import java.math.BigDecimal;

public class ProductTestCase1 {
    private String name;
    private String description;
    private BigDecimal value;
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
}
