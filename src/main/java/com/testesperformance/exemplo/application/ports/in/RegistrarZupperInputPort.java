package com.testesperformance.exemplo.application.ports.in;

import com.testesperformance.exemplo.application.domain.Zupper;

public interface RegistrarZupperInputPort {

    Zupper executar(Zupper novoZupper, String cep, String numero);

}
