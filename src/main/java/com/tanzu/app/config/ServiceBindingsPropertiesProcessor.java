package com.tanzu.app.config;

import org.springframework.cloud.bindings.Binding;
import org.springframework.cloud.bindings.Bindings;
import org.springframework.cloud.bindings.boot.BindingsPropertiesProcessor;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.Map;

//https://github.com/spring-cloud/spring-cloud-bindings#extending-spring-boot-configuration
public class ServiceBindingsPropertiesProcessor implements BindingsPropertiesProcessor {

    public static final String TYPE = "config";

    @Override
    public void process(Environment environment, Bindings bindings, Map<String, Object> properties) {
        bindings.filterBindings(TYPE).forEach(binding -> {
            properties.put("tanzu.super-feature.enabled", binding.getSecret().get("super-feature"));
        });
    }
}
