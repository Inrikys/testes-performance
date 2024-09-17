package com.testesperformance.exemplo.config;

import com.testesperformance.exemplo.application.ports.out.DetalharZupperOutputPort;
import com.testesperformance.exemplo.application.ports.out.ExcluirZupperOutputPort;
import com.testesperformance.exemplo.application.usecase.ExcluirZupperUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExcluirZupperConfig {

    @Bean
    public ExcluirZupperUseCase excluirZupperUseCase(
            DetalharZupperOutputPort detalharZupperOutputPort,
            ExcluirZupperOutputPort excluirZupperOutputPort
    ) {
        return new ExcluirZupperUseCase(detalharZupperOutputPort, excluirZupperOutputPort);
    }
}
