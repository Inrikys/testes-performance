package com.testesperformance.exemplo.application.ports.in;

import com.testesperformance.exemplo.application.domain.Zupper;

public interface DetalharZupperInputPort {

    Zupper executar(Long id);

}
