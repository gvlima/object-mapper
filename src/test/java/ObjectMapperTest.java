import org.junit.Assert;
import org.junit.Test;
import org.mapper.ObjectMapper;
import org.mapper.example.Product;
import org.mapper.example.ProductDTO;

import java.math.BigDecimal;
import java.util.UUID;

public class ObjectMapperTest {


    @Test
    public void shouldReturn(){
        ObjectMapper objectMapper = new ObjectMapper();
        var result = objectMapper.transform(buildProduct(), ProductDTO.class);
        Assert.assertNotNull(result);
    }

    private Product buildProduct(){
        return new Product(UUID.randomUUID().toString(), "Product Name", "Product description", BigDecimal.valueOf(199), 100.0);
    }
}
