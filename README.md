## A simple Java object mapper using reflection

This repository provides a basic implementation of an object mapper, leveraging Java reflection to dynamically map properties between objects. The primary goal is to explore the capabilities of reflection and its application.

- Mapper.class: Using reflection to extract metadata about object properties and copy value between source and destination objects.
- NumericConverter: Handles the conversion of numeric types using reflection and invokes methods with appropriate parameters.
- MapperFieldConfig: A custom annotation for configuring mapping behavior enabling the numeric type converter and custom source attribute mappings.

### Key Mapping Features:
- <b>Automatic Mapping:</b> Attributes with identical names in both source and destination objects are automatically mapped. Attributes with different names can be mapped using the <i>@MapperFieldConfig</i> annotation. Specify the source attribute name using the sourceAttributeName property.
- <b>Numeric Type Conversion:</b> Enable automatic conversion between numeric types for attributes with compatible data types. Use the numericTypeConversion property of the <i>@MapperFieldConfig</i> annotation.


### Example
A folder named example showcases the usage of the object mapper:

- Product.class: The source object containing the original data.
- ProductDTO.class: The destination object to hold the mapped data.
- Main.class: Use of Mapper class for parse source object to an instance of destination class
