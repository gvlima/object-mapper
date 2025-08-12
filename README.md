## A simple Java object mapper using reflection

This repository provides a basic implementation of an object mapper, leveraging Java reflection to dynamically map properties between objects. The primary goal is to explore the capabilities of reflection and its application.

- <i>Mapper.class</i>: Using reflection to extract metadata about object properties and copy value between source and destination objects.
- <i>NumericConverter</i>: Handles the conversion of numeric types using reflection and invokes methods with appropriate parameters.
- <i>MapperFieldConfig</i>: A custom annotation for configuring mapping behavior enabling the numeric type converter and custom source attribute mappings.

### Key Mapping Features:
- <i>Automatic Mapping:</i> Attributes with identical names in both source and destination objects are automatically mapped. Attributes with different names can be mapped using the <i>@MapperFieldConfig</i> annotation. Specify the source attribute name using the sourceAttributeName property.
- <i>Numeric Type Conversion:</i> Enable automatic conversion between numeric types for attributes with compatible data types. Use the numericTypeConversion property of the <i>@MapperFieldConfig</i> annotation.


### Example
A folder named example showcases the usage of the object mapper:

- <i>Product.class</i>: The source object containing the original data.
- <i>ProductDTO.class</i>: The destination object to hold the mapped data.
- <i>Main.class</i>: Use of Mapper class for parse source object to an instance of destination class
