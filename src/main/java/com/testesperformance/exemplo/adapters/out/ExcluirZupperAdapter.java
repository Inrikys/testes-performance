package com.testesperformance.exemplo.adapters.out;

import com.testesperformance.exemplo.adapters.out.repository.ZupperRepository;
import com.testesperformance.exemplo.adapters.out.repository.entity.ZupperEntity;
import com.testesperformance.exemplo.application.domain.Zupper;
import com.testesperformance.exemplo.application.ports.out.DetalharZupperOutputPort;
import com.testesperformance.exemplo.application.ports.out.ExcluirZupperOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ExcluirZupperAdapter implements ExcluirZupperOutputPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcluirZupperAdapter.class);
    private final ZupperRepository zupperRepository;

    public ExcluirZupperAdapter(ZupperRepository zupperRepository) {
        this.zupperRepository = zupperRepository;
    }

    @Override
    public void excluir(Zupper zupper) {

        LOGGER.info("Excluindo Zupper da base de dados...");

        ZupperEntity zupperEntity = new ZupperEntity(zupper);

        zupperRepository.delete(zupperEntity);
    }
}
