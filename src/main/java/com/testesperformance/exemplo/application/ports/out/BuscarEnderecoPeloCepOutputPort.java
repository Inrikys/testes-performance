package com.testesperformance.exemplo.application.ports.out;

import com.testesperformance.exemplo.application.domain.Endereco;

public interface BuscarEnderecoPeloCepOutputPort {

    Endereco buscar(String cep);

}
