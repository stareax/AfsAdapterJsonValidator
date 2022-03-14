package com.example.afsadapterjsonvalidator.customserializers;

import com.example.afsadapterjsonvalidator.DTO.request.AfsRequestDTO;
import com.example.afsadapterjsonvalidator.DTO.response.AfsResponseDTO;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.DelegatingDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class AfsResponseDeserializer extends DelegatingDeserializer{
    public AfsResponseDeserializer(JsonDeserializer<?> delegate) {
        super(delegate);
    }

    @Override
    protected JsonDeserializer<?> newDelegatingInstance(JsonDeserializer<?> jsonDeserializer) {
        return new AfsResponseDeserializer(jsonDeserializer);
    }

    @Override
    public AfsResponseDTO deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {
        System.out.println("AfsResponseDeserializer");
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("/jsonSchemes/afs_response.json");
        JsonSchema jsonSchema = jsonSchemaFactory.getSchema(is);
        Set<ValidationMessage> messages = jsonSchema.validate(ctxt.readTree(p));
        if (!messages.isEmpty()){
            throw new IOException("Error in response format");
        }
        AfsResponseDTO result = (AfsResponseDTO) super.deserialize(p, ctxt);
        return result;
    }
}
