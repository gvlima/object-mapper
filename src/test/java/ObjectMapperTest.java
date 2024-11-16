import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapper.ObjectMapper;
import org.mapper.example.Product;

import java.math.BigDecimal;
import java.util.UUID;

public class ObjectMapperTest {

    private Product product;
    private ObjectMapper objectMapper;

    private final String NAME = "Product 01";
    private final String DESCRIPTION = "Product description";
    private final BigDecimal VALUE = BigDecimal.valueOf(100);
    private final Double STOQUE = 100.0;

    @BeforeEach
    public void setup(){
        product = new Product(UUID.randomUUID().toString(), NAME, DESCRIPTION, VALUE, STOQUE);
        objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("Should convert and return full DTO object")
    public void shouldReturnDTO(){
        var result = objectMapper.transform(product, ProductTestCase1.class);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(product.getName(), result.getName());
        Assertions.assertEquals(product.getDescription(), result.getDescription());
        Assertions.assertEquals(product.getValue(), result.getValue());
        Assertions.assertEquals(product.getStoque(), result.getStoque());
    }

    @Test
    @DisplayName("Should automatically convert type from BigDecimal to Double")
    public void shouldAutomaticallyConvertFieldType(){
        var result = objectMapper.transform(product, ProductTestCase2.class);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(product.getName(), result.getName());
        Assertions.assertEquals(product.getDescription(), result.getDescription());
        Assertions.assertEquals(Double.class, result.getValue().getClass());
        Assertions.assertEquals(100.0D, result.getValue());
        Assertions.assertEquals(product.getStoque(), result.getStoque());
    }

    @Test
    @DisplayName("Should return null when source and destination fields are different types")
    public void whenFieldIsDifferentClassShouldNotConvert(){
        var result = objectMapper.transform(product, ProductTestCase3.class);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(product.getName(), result.getName());
        Assertions.assertEquals(product.getDescription(), result.getDescription());
        Assertions.assertNull(result.getValue());
        Assertions.assertEquals(product.getStoque(), result.getStoque());
    }

    @Test
    @DisplayName("Should get field content from annotation")
    public void shouldGetFieldFromAnnotationSourceName(){
        var result = objectMapper.transform(product, ProductTestCase4.class);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(product.getName(), result.getName());
        Assertions.assertEquals(product.getDescription(), result.getDescription());
        Assertions.assertNotNull(result.getPrice());
        Assertions.assertEquals(product.getValue(), result.getPrice());
    }
}