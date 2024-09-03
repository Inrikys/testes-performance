package com.cleanarchitecture.exemplo.application.ports.in;

import com.cleanarchitecture.exemplo.application.domain.Zupper;

public interface RegistrarZupperInputPort {

    Zupper executar(Zupper novoZupper, String cep, String numero);

}
