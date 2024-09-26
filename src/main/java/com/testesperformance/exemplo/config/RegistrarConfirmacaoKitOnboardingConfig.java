package com.testesperformance.exemplo.config;

import com.testesperformance.exemplo.application.usecase.RegistrarConfirmacaoKitOnboardingUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegistrarConfirmacaoKitOnboardingConfig {

    @Bean
    public RegistrarConfirmacaoKitOnboardingUseCase registrarConfirmacaoKitOnboardingUseCase() {
        return new RegistrarConfirmacaoKitOnboardingUseCase();
    }

}
