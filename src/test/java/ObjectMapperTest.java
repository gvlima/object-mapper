import model.ProductTestCase1DTO;
import model.ProductTestCase2DTO;
import model.ProductTestCase3DTO;
import model.ProductTestCase4DTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mapper.ObjectMapper;
import org.mapper.example.Product;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public class ObjectMapperTest {

    private Product product;
    private ObjectMapper objectMapper;

    private final String NAME = "Product 01";
    private final String DESCRIPTION = "Product description";
    private final BigDecimal VALUE = BigDecimal.valueOf(100);
    private final Double STOQUE = 100.0;

    @Before
    public void setUp(){
        product = new Product(UUID.randomUUID().toString(), NAME, DESCRIPTION, VALUE, STOQUE);
        objectMapper = new ObjectMapper();
    }

    @Test
    public void shouldReturnDTO(){
        var result = objectMapper.transform(product, ProductTestCase1DTO.class);

        Assert.assertNotNull(result);
        Assert.assertEquals(NAME, result.getName());
        Assert.assertEquals(DESCRIPTION, result.getDescription());
        Assert.assertEquals(VALUE, result.getValue());
        Assert.assertEquals(STOQUE, result.getStoque());
    }

    @Test
    public void shouldConvertValueFieldToDouble(){
        var result = objectMapper.transform(product, ProductTestCase2DTO.class);

        Assert.assertNotNull(result);
        Assert.assertEquals(Optional.of(product.getValue().doubleValue()).get(), result.getValue());
        Assert.assertEquals(Double.class, result.getValue().getClass());
    }

    @Test
    public void whenFieldIsDifferentClassShouldNotConvertAndSetFieldToNull(){
        var result = objectMapper.transform(product, ProductTestCase3DTO.class);

        Assert.assertNotNull(result);
        Assert.assertNull(result.getValue());
    }

    @Test
    public void shouldGetFieldFromAnnotationSourceName(){
        var result = objectMapper.transform(product, ProductTestCase4DTO.class);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPrice());
        Assert.assertEquals(product.getValue(), result.getPrice());
    }

}
