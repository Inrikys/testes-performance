package com.cleanarchitecture.exemplo.application.ports.out;

import com.cleanarchitecture.exemplo.application.domain.Zupper;

public interface NotificarNovoZupperOutputPort {

    void notificar(Zupper novoZupper);

}
