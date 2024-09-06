package com.testesperformance.exemplo.config;

import com.testesperformance.exemplo.application.ports.out.BuscarZuppersOutputPort;
import com.testesperformance.exemplo.application.ports.out.DetalharZupperOutputPort;
import com.testesperformance.exemplo.application.usecase.BuscarZuppersUseCase;
import com.testesperformance.exemplo.application.usecase.DetalharZupperUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DetalharZuppersConfig {

    @Bean
    public DetalharZupperUseCase detalharZupperUseCase(
            DetalharZupperOutputPort detalharZupperOutputPort
    ) {
        return new DetalharZupperUseCase(detalharZupperOutputPort);
    }
}
