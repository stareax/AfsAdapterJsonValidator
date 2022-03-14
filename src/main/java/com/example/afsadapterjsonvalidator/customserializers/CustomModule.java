package com.example.afsadapterjsonvalidator.customserializers;

import com.fasterxml.jackson.databind.module.SimpleModule;

public class CustomModule extends SimpleModule {
    public CustomModule() {
        super("CustomModule");
        this.setSerializerModifier(new CustomBeanSerializerModifier());
        this.setDeserializerModifier(new CustomBeanDeserializerModifier());
    }

}
