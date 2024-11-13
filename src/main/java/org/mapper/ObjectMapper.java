package org.mapper;

import org.mapper.configuration.MapperFieldConfig;
import org.mapper.exception.ObjectMapperException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectMapper {
    public <I, O> O transform(I input, Class<O> outputClass) {

        Logger logger = Logger.getLogger(ObjectMapper.class.getName());

        try {
            Class<?> inputClass = input.getClass();
            List<Field> outputFields = List.of(outputClass.getDeclaredFields());

            HashMap<String, Field> inputFields = new HashMap<>();
            for(Field field : inputClass.getDeclaredFields()){
                inputFields.put(field.getName(), field);
            }

            Constructor<O> constructor = outputClass.getDeclaredConstructor();
            O output = constructor.newInstance();

            for (Field outputField: outputFields){
                outputField.setAccessible(true);
                MapperFieldConfig fieldAnnotation = outputField.getAnnotation(MapperFieldConfig.class);

                if(inputFields.containsKey(outputField.getName())){
                    Field inputField = inputFields.get(outputField.getName());
                    inputField.setAccessible(true);

                    if(outputField.getType().equals(inputField.getType())){
                        outputField.set(output, inputField.get(input));
                        continue;
                    }

                    if(fieldAnnotation != null && fieldAnnotation.numericTypeConversion()){
                        outputField.set(output, NumericConverter.convert(inputField.get(input), outputField.getType()));
                        continue;
                    }

                    outputField.set(output, null);
                    continue;
                }

                if(fieldAnnotation.sourceAttributeName() != null && inputFields.containsKey(fieldAnnotation.sourceAttributeName())){
                    Field inputField = inputFields.get(fieldAnnotation.sourceAttributeName());
                    inputField.setAccessible(true);

                    if(outputField.getType().equals(inputField.getType())){
                        outputField.set(output, inputField.get(input));
                        continue;
                    }

                    if(fieldAnnotation.numericTypeConversion()){
                        outputField.set(output, NumericConverter.convert(inputField.get(input), outputField.getType()));
                        continue;
                    }
                }

                outputField.set(output, null);
            }

            return output;
        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalArgumentException e) {
            logger.log(Level.WARNING, "Error occurred during object mapping");
            throw new ObjectMapperException(e);
        }
    }
}
