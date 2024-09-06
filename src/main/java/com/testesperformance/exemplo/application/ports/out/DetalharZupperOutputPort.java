package com.testesperformance.exemplo.application.ports.out;

import com.testesperformance.exemplo.application.domain.Zupper;

import java.util.Optional;

public interface DetalharZupperOutputPort {

    Optional<Zupper> detalharPorId(Long id);

}
