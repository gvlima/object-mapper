
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapper.NumericConverter;
import org.mapper.exception.ObjectMapperException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumericConverterTest {

    @Test
    @DisplayName("Should return null when parameter is null")
    public void shouldReturnNull(){
        var result = NumericConverter.convert(null, Integer.class);
        Assertions.assertNull(result);
    }

    @Test
    @DisplayName("Should thrown exception when invalid source field")
    void shouldThrownExceptionWhenInvalidSource() {
        Exception exception = assertThrows(ObjectMapperException.class, () -> {
            NumericConverter.convert("input", Integer.class);
        });

        String expectedMessage = "Invalid source type";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Should thrown exception when invalid destination type")
    void shouldThrownExceptionWhenInvalidDestination() {
        Exception exception = assertThrows(ObjectMapperException.class, () -> {
            NumericConverter.convert(100, String.class);
        });

        String expectedMessage = "Invalid destination type";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void shouldConvertDoubleToInteger(){
        Integer expected = 100;
        Double sourceValue = 100.0;
        var result = NumericConverter.convert(sourceValue, Integer.class);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(Integer.class, result.getClass());
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void shouldConvertFloatToInteger(){
        Integer expected = 100;
        Float sourceValue = 100.0F;
        var result = NumericConverter.convert(sourceValue, Integer.class);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(Integer.class, result.getClass());
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void shouldConvertLongToInteger(){
        Integer expected = 100;
        Long souceValue = 100L;
        var result = NumericConverter.convert(souceValue, Integer.class);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(Integer.class, result.getClass());
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void shouldConvertShortToInteger(){
        Integer expected = 100;
        Short sourceValue = 100;
        var result = NumericConverter.convert(sourceValue, Integer.class);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(Integer.class, result.getClass());
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void shouldConvertByteToInteger(){
        Integer expected = 100;
        Byte sourceValue = 100;
        var result = NumericConverter.convert(sourceValue, Integer.class);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(Integer.class, result.getClass());
        Assertions.assertEquals(expected, result);
    }
}
