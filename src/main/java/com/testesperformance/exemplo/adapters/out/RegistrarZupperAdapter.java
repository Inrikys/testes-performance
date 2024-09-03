package com.testesperformance.exemplo.adapters.out;

import com.testesperformance.exemplo.adapters.out.repository.ZupperRepository;
import com.testesperformance.exemplo.adapters.out.repository.entity.ZupperEntity;
import com.testesperformance.exemplo.application.domain.Zupper;
import com.testesperformance.exemplo.application.ports.out.RegistrarZupperOutputPort;
import org.springframework.stereotype.Component;

@Component
public class RegistrarZupperAdapter implements RegistrarZupperOutputPort {

    private final ZupperRepository zupperRepository;

    public RegistrarZupperAdapter(ZupperRepository zupperRepository) {
        this.zupperRepository = zupperRepository;
    }

    @Override
    public Zupper registrar(Zupper zupper) {

        ZupperEntity zupperEntity = new ZupperEntity(zupper);
        ZupperEntity zupperEntitySalvo = this.zupperRepository.save(zupperEntity);

        return zupperEntitySalvo.toZupper();
    }
}
