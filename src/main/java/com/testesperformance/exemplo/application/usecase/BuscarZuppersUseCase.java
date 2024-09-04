package com.testesperformance.exemplo.application.usecase;

import com.testesperformance.exemplo.application.domain.PaginatedResult;
import com.testesperformance.exemplo.application.domain.Pagination;
import com.testesperformance.exemplo.application.domain.Zupper;
import com.testesperformance.exemplo.application.ports.in.BuscarZuppersInputPort;
import com.testesperformance.exemplo.application.ports.out.BuscarZuppersOutputPort;

public class BuscarZuppersUseCase implements BuscarZuppersInputPort {

    private final BuscarZuppersOutputPort buscarZuppersOutputPort;

    public BuscarZuppersUseCase(BuscarZuppersOutputPort buscarZuppersOutputPort) {
        this.buscarZuppersOutputPort = buscarZuppersOutputPort;
    }

    @Override
    public PaginatedResult<Zupper> executar(Pagination pagination) {
        return buscarZuppersOutputPort.buscar(pagination);
    }
}
