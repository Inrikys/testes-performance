package com.testesperformance.exemplo.adapters.out;

import com.testesperformance.exemplo.adapters.out.repository.ZupperRepository;
import com.testesperformance.exemplo.application.ports.out.VerificarExistenciaZupperOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class VerificarExistenciaZupperAdapter implements VerificarExistenciaZupperOutputPort {

    private final ZupperRepository zupperRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(VerificarExistenciaZupperAdapter.class);

    public VerificarExistenciaZupperAdapter(ZupperRepository zupperRepository) {
        this.zupperRepository = zupperRepository;
    }

    public boolean isZupperCadastrado(String email) {

        LOGGER.info("Verificando existência de zupper por e-mail na base de dados");

        return zupperRepository.existsByEmail(email);
    }
}
