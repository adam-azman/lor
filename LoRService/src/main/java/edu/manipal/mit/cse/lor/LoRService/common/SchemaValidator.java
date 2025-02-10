package edu.manipal.mit.cse.lor.LoRService.common;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

import java.io.InputStream;
import java.util.Set;

public class SchemaValidator {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final JsonSchema schema;

    static {
        try {
            InputStream schemaStream = SchemaValidator.class
                    .getClassLoader()
                    .getResourceAsStream("schemas/lor-request-schema.json");

            JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);
            schema = factory.getSchema(schemaStream);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load JSON Schema", e);
        }
    }

    public static void validateLorRequest(String jsonRequest) {
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonRequest);
            Set<ValidationMessage> violations = schema.validate(jsonNode);

            if (!violations.isEmpty()) {
                throw new RuntimeException("Schema validation failed: " + violations);
            }
        } catch (Exception e) {
            throw new RuntimeException("Invalid JSON format: " + e.getMessage());
        }
    }
}
