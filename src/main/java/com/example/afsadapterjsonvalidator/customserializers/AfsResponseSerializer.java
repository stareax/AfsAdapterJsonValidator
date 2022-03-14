package com.example.afsadapterjsonvalidator.customserializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.StdConverter;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class AfsResponseSerializer extends StdDelegatingSerializer {

    public AfsResponseSerializer(JavaType javaType, JsonSerializer<?> delegateSerializer) {
        super(new StdConverter<Object, Object>() {
            @Override
            public Object convert(Object value) {
                return value;
            }
        }, javaType, delegateSerializer);
    }

    @Override
    protected StdDelegatingSerializer withDelegate(Converter<Object, ?> converter, JavaType delegateType, JsonSerializer<?> delegateSerializer) {
        return new AfsResponseSerializer(delegateType, delegateSerializer);
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        System.out.println("AfsResponseSerializer");
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("/jsonSchemes/afs_response.json");
        JsonSchema jsonSchema = jsonSchemaFactory.getSchema(is);
        ObjectMapper mapper = new ObjectMapper();
        Set<ValidationMessage> messages = jsonSchema.validate(mapper.readTree(mapper.writeValueAsBytes(value)));
//        if (!messages.isEmpty()) throw new IOException("From AfsResponseSerializer");
        super.serialize(value, gen, provider);
    }
}
