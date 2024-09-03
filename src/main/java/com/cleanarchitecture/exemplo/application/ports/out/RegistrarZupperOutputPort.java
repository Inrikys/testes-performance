package com.cleanarchitecture.exemplo.application.ports.out;

import com.cleanarchitecture.exemplo.application.domain.Zupper;

public interface RegistrarZupperOutputPort {

    Zupper registrar(Zupper zupper);

}
