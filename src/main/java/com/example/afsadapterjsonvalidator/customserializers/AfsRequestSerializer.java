package com.example.afsadapterjsonvalidator.customserializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.StdConverter;

import java.io.IOException;

public class AfsRequestSerializer extends StdDelegatingSerializer {

    public AfsRequestSerializer(JavaType javaType, JsonSerializer<?> delegateSerializer) {
        super(new StdConverter<Object, Object>() {
            @Override
            public Object convert(Object value) {
                return value;
            }
        }, javaType, delegateSerializer);
    }

    @Override
    protected StdDelegatingSerializer withDelegate(Converter<Object, ?> converter, JavaType delegateType, JsonSerializer<?> delegateSerializer) {
        return new AfsRequestSerializer(delegateType, delegateSerializer);
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        System.out.println("AfsRequestSerializer");
        super.serialize(value, gen, provider);
    }
}
