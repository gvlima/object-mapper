package org.mapper.example;

import org.mapper.ObjectMapper;

import java.math.BigDecimal;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Product product = new Product(UUID.randomUUID().toString(), "Product Name", "Full Product Description", BigDecimal.valueOf(400.00), 100.0);

        ProductDTO dto = objectMapper.transform(product, ProductDTO.class);

        System.out.println(product.toString());
        System.out.println(dto.toString());
    }
}