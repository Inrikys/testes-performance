package com.testesperformance.exemplo.adapters.in.web;

import com.testesperformance.exemplo.adapters.in.web.response.BuscarZuppersResponse;
import com.testesperformance.exemplo.adapters.in.web.response.ResultadoPaginadoResponse;
import com.testesperformance.exemplo.adapters.out.VerificarExistenciaZupperAdapter;
import com.testesperformance.exemplo.application.domain.PaginatedResult;
import com.testesperformance.exemplo.application.domain.Pagination;
import com.testesperformance.exemplo.application.domain.Zupper;
import com.testesperformance.exemplo.application.ports.in.BuscarZuppersInputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/zuppers")
public class BuscarZuppersController {

    private final BuscarZuppersInputPort buscarZuppersInputPort;

    private static final Logger LOGGER = LoggerFactory.getLogger(BuscarZuppersController.class);

    public BuscarZuppersController(BuscarZuppersInputPort buscarZuppersInputPort) {
        this.buscarZuppersInputPort = buscarZuppersInputPort;
    }

    @GetMapping
    public ResponseEntity<ResultadoPaginadoResponse<BuscarZuppersResponse>> buscar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {

        Pagination pagination = new Pagination(page, size, sortBy, direction);

        LOGGER.info("Iniciando busca de Zuppers...");

        PaginatedResult<Zupper> zuppersPaginados = buscarZuppersInputPort.executar(pagination);

        List<BuscarZuppersResponse> zuppersResponseList = zuppersPaginados.getData().stream()
                .map(BuscarZuppersResponse::new)
                .collect(Collectors.toList());

        ResultadoPaginadoResponse<BuscarZuppersResponse> buscarZuppersPaginadoResponse =
                new ResultadoPaginadoResponse<>(zuppersResponseList, zuppersPaginados.getTotalPages(), zuppersPaginados.getTotalElements());

        return ResponseEntity.ok(buscarZuppersPaginadoResponse);
    }

}
