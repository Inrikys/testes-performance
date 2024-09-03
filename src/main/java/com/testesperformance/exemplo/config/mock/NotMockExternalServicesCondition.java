package com.testesperformance.exemplo.config.mock;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class NotMockExternalServicesCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String enableMock = context.getEnvironment().getProperty("external-services.mock.enabled");
        return !"true".equalsIgnoreCase(enableMock);
    }
}
