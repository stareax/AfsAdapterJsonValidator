package com.example.afsadapterjsonvalidator.customserializers;

import com.example.afsadapterjsonvalidator.DTO.request.AfsRequestDTO;
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


public class AfsRequestDeserializer extends DelegatingDeserializer {
    public AfsRequestDeserializer(JsonDeserializer<?> delegate) {
        super(delegate);
    }

    @Override
    protected JsonDeserializer<?> newDelegatingInstance(JsonDeserializer<?> jsonDeserializer) {
        return new AfsRequestDeserializer(jsonDeserializer);
    }

    @Override
    public AfsRequestDTO deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {
        System.out.println("AfsRequestDeserializer");

        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("/jsonSchemes/afs_request.json");
        JsonSchema jsonSchema = jsonSchemaFactory.getSchema(is);
        Set<ValidationMessage> messages = jsonSchema.validate(ctxt.readTree(p));

        AfsRequestDTO result = (AfsRequestDTO) super.deserialize(p, ctxt);
        return result;
    }
}
