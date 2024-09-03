package com.testesperformance.exemplo.config;

import com.testesperformance.exemplo.application.usecase.RegistrarZupperUseCase;
import com.testesperformance.exemplo.application.ports.out.BuscarEnderecoPeloCepOutputPort;
import com.testesperformance.exemplo.application.ports.out.NotificarNovoZupperOutputPort;
import com.testesperformance.exemplo.application.ports.out.RegistrarZupperOutputPort;
import com.testesperformance.exemplo.application.ports.out.VerificarExistenciaZupperOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegistrarZupperConfig {

    @Bean
    public RegistrarZupperUseCase registrarZupperUseCase(
            RegistrarZupperOutputPort registrarZupperOutputPort,
            BuscarEnderecoPeloCepOutputPort buscarEnderecoPeloCepOutputPort,
            NotificarNovoZupperOutputPort notificarNovoZupperOutputPort,
            VerificarExistenciaZupperOutputPort verificarExistenciaZupperOutputPort
    ) {
        return new RegistrarZupperUseCase(registrarZupperOutputPort, buscarEnderecoPeloCepOutputPort, notificarNovoZupperOutputPort, verificarExistenciaZupperOutputPort);
    }
}
