package com.cleanarchitecture.exemplo.adapters.out;

import com.cleanarchitecture.exemplo.adapters.out.repository.ZupperRepository;
import com.cleanarchitecture.exemplo.application.ports.out.VerificarExistenciaZupperOutputPort;
import org.springframework.stereotype.Component;

@Component
public class VerificarExistenciaZupperAdapter implements VerificarExistenciaZupperOutputPort {

    private final ZupperRepository zupperRepository;

    public VerificarExistenciaZupperAdapter(ZupperRepository zupperRepository) {
        this.zupperRepository = zupperRepository;
    }

    public boolean isZupperCadastrado(String email) {
        return zupperRepository.existsByEmail(email);
    }
}
