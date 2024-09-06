package com.testesperformance.exemplo.application.usecase;

import com.testesperformance.exemplo.application.domain.Zupper;
import com.testesperformance.exemplo.application.exception.ZupperNaoExisteException;
import com.testesperformance.exemplo.application.ports.in.DetalharZupperInputPort;
import com.testesperformance.exemplo.application.ports.out.DetalharZupperOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class DetalharZupperUseCase implements DetalharZupperInputPort {

    private final DetalharZupperOutputPort detalharZupperOutputPort;
    private static final Logger LOGGER = LoggerFactory.getLogger(DetalharZupperUseCase.class);

    public DetalharZupperUseCase(DetalharZupperOutputPort detalharZupperOutputPort) {
        this.detalharZupperOutputPort = detalharZupperOutputPort;
    }

    public Zupper executar(Long zupperId) {

        LOGGER.info("Detalhando Zupper por id...");

        Optional<Zupper> zupper = detalharZupperOutputPort.detalharPorId(zupperId);
        return zupper.orElseThrow(() -> new ZupperNaoExisteException("Zupper com o id " + zupper + " não existe no banco de dados"));
    }
}
