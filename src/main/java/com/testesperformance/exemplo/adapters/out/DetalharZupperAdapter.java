package com.testesperformance.exemplo.adapters.out;

import com.testesperformance.exemplo.adapters.out.repository.ZupperRepository;
import com.testesperformance.exemplo.adapters.out.repository.entity.ZupperEntity;
import com.testesperformance.exemplo.application.domain.Zupper;
import com.testesperformance.exemplo.application.ports.out.DetalharZupperOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetalharZupperAdapter implements DetalharZupperOutputPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(DetalharZupperAdapter.class);
    private final ZupperRepository zupperRepository;

    public DetalharZupperAdapter(ZupperRepository zupperRepository) {
        this.zupperRepository = zupperRepository;
    }

    @Override
    public Optional<Zupper> detalharPorId(Long id) {

        LOGGER.info("Consultando detalhes de Zupper na base de dados...");

        Optional<ZupperEntity> possivelZupperEncontrado = zupperRepository.findById(id);

        return possivelZupperEncontrado.map(ZupperEntity::toZupper);
    }
}
