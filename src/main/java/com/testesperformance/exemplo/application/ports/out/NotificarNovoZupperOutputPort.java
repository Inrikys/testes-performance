package com.testesperformance.exemplo.application.ports.out;

import com.testesperformance.exemplo.application.domain.Zupper;

public interface NotificarNovoZupperOutputPort {

    void notificar(Zupper novoZupper);

}
