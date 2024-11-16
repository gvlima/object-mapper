package org.mapper;

import org.mapper.exception.ObjectMapperException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NumericConverter {

    public static Object convert(Object number, Class<?> targetType) {
        Logger logger = Logger.getLogger(NumericConverter.class.getName());

        try {
            if(Objects.isNull(number)){
                return null;
            }

            if (!Number.class.isAssignableFrom(targetType) && !targetType.isPrimitive()) {
                logger.log(Level.WARNING, "Invalid destination type");
                throw new ObjectMapperException("Invalid destination type");
            }

            if(!Number.class.isAssignableFrom(number.getClass())){
                logger.log(Level.WARNING, "Invalid source type");
                throw new ObjectMapperException("Invalid source type");
            }

            if (targetType.isPrimitive()) {
                targetType = getWrapperClass(targetType);
            }

            Method valueOfMethod = targetType.getMethod("valueOf", String.class);

            if(number.getClass().equals(Double.class) || number.getClass().equals(Float.class)){
                return valueOfMethod.invoke(null, String.format("%.0f", number));
            }

            return valueOfMethod.invoke(null, number.toString());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            logger.log(Level.INFO, "Could not convert types: " + e.getMessage());
            return null;
        }
    }

    private static Class<?> getWrapperClass(Class<?> primitiveType) {
        if (primitiveType == int.class) return Integer.class;
        if (primitiveType == long.class) return Long.class;
        if (primitiveType == double.class) return Double.class;
        if (primitiveType == float.class) return Float.class;
        if (primitiveType == short.class) return Short.class;
        if (primitiveType == byte.class) return Byte.class;
        return primitiveType;
    }
}
