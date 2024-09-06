package com.testesperformance.exemplo.adapters.out;

import com.testesperformance.exemplo.adapters.out.repository.ZupperRepository;
import com.testesperformance.exemplo.adapters.out.repository.entity.ZupperEntity;
import com.testesperformance.exemplo.application.domain.Zupper;
import com.testesperformance.exemplo.application.ports.out.RegistrarZupperOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RegistrarZupperAdapter implements RegistrarZupperOutputPort {

    private final ZupperRepository zupperRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificarNovoZupperAdapter.class);

    public RegistrarZupperAdapter(ZupperRepository zupperRepository) {
        this.zupperRepository = zupperRepository;
    }

    @Override
    public Zupper registrar(Zupper novoZupper) {

        ZupperEntity zupperEntity = new ZupperEntity(novoZupper);

        LOGGER.info("Registrando um novo zuper...");

        ZupperEntity zupperEntitySalvo = this.zupperRepository.save(zupperEntity);

        return zupperEntitySalvo.toZupper();
    }
}
