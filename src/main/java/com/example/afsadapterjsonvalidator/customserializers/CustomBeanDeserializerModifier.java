package com.example.afsadapterjsonvalidator.customserializers;

import com.example.afsadapterjsonvalidator.DTO.request.AfsRequestDTO;
import com.example.afsadapterjsonvalidator.DTO.response.AfsResponseDTO;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;

public class CustomBeanDeserializerModifier extends BeanDeserializerModifier {
    @Override
    public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
        if (beanDesc.getBeanClass().equals(AfsRequestDTO.class)) {
            return new AfsRequestDeserializer((JsonDeserializer<Object>) deserializer);
        }
        if (beanDesc.getBeanClass().equals(AfsResponseDTO.class)) {
            return new AfsResponseDeserializer((JsonDeserializer<Object>) deserializer);
        }
        return deserializer;
    }
}
