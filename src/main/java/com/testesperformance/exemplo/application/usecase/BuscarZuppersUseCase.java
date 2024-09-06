package com.testesperformance.exemplo.application.usecase;

import com.testesperformance.exemplo.adapters.out.DetalharZupperAdapter;
import com.testesperformance.exemplo.application.domain.PaginatedResult;
import com.testesperformance.exemplo.application.domain.Pagination;
import com.testesperformance.exemplo.application.domain.Zupper;
import com.testesperformance.exemplo.application.ports.in.BuscarZuppersInputPort;
import com.testesperformance.exemplo.application.ports.out.BuscarZuppersOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuscarZuppersUseCase implements BuscarZuppersInputPort {

    private final BuscarZuppersOutputPort buscarZuppersOutputPort;
    private static final Logger LOGGER = LoggerFactory.getLogger(BuscarZuppersUseCase.class);

    public BuscarZuppersUseCase(BuscarZuppersOutputPort buscarZuppersOutputPort) {
        this.buscarZuppersOutputPort = buscarZuppersOutputPort;
    }

    @Override
    public PaginatedResult<Zupper> executar(Pagination pagination) {

        LOGGER.info("Buscando lista paginada de Zuppers...");

        return buscarZuppersOutputPort.buscar(pagination);
    }
}
