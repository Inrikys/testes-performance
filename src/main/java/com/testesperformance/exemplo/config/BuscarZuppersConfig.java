package com.testesperformance.exemplo.config;

import com.testesperformance.exemplo.application.ports.out.BuscarZuppersOutputPort;
import com.testesperformance.exemplo.application.usecase.BuscarZuppersUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarZuppersConfig {

    @Bean
    public BuscarZuppersUseCase buscarZuppersUseCase(
            BuscarZuppersOutputPort buscarZuppersOutputPort
    ) {
        return new BuscarZuppersUseCase(buscarZuppersOutputPort);
    }

}
