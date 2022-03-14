package com.example.afsadapterjsonvalidator.customserializers;

import com.example.afsadapterjsonvalidator.DTO.request.AfsRequestDTO;
import com.example.afsadapterjsonvalidator.DTO.response.AfsResponseDTO;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

public class CustomBeanSerializerModifier extends BeanSerializerModifier {

    @Override
    public JsonSerializer<?> modifySerializer(
            SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {
        if (beanDesc.getBeanClass().equals(AfsRequestDTO.class)) {
            return new AfsRequestSerializer(beanDesc.getType(), (JsonSerializer<Object>) serializer);
        }
        if (beanDesc.getBeanClass().equals(AfsResponseDTO.class)) {
            return new AfsResponseSerializer(beanDesc.getType(), (JsonSerializer<Object>) serializer);
        }


        return serializer;
    }
}
