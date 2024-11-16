package model;

import org.mapper.configuration.MapperFieldConfig;

public class ProductTestCase2 {
    private String name;
    private String description;
    @MapperFieldConfig(numericTypeConversion = true)
    private Double value;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getStoque() {
        return stoque;
    }

    public void setStoque(Double stoque) {
        this.stoque = stoque;
    }
}
