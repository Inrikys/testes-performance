package com.testesperformance.exemplo.application.usecase;

import com.testesperformance.exemplo.application.domain.Zupper;
import com.testesperformance.exemplo.application.exception.ZupperNaoExisteException;
import com.testesperformance.exemplo.application.ports.in.ExcluirZupperInputPort;
import com.testesperformance.exemplo.application.ports.out.DetalharZupperOutputPort;
import com.testesperformance.exemplo.application.ports.out.ExcluirZupperOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class ExcluirZupperUseCase implements ExcluirZupperInputPort {

    private final DetalharZupperOutputPort detalharZupperOutputPort;
    private final ExcluirZupperOutputPort excluirZupperOutputPort;
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcluirZupperUseCase.class);

    public ExcluirZupperUseCase(DetalharZupperOutputPort detalharZupperOutputPort, ExcluirZupperOutputPort excluirZupperOutputPort) {
        this.detalharZupperOutputPort = detalharZupperOutputPort;
        this.excluirZupperOutputPort = excluirZupperOutputPort;
    }

    public void executar(Long zupperId) {

        LOGGER.info("Excluindo Zupper por id...");

        Optional<Zupper> zupper = detalharZupperOutputPort.detalharPorId(zupperId);
        Zupper zupperASerExcluido = zupper.orElseThrow(() -> new ZupperNaoExisteException("Zupper com o id " + zupper + " não existe no banco de dados"));

        excluirZupperOutputPort.excluir(zupperASerExcluido);
    }
}
