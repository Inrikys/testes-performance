package com.testesperformance.exemplo.adapters.out;

import com.testesperformance.exemplo.adapters.out.repository.ZupperRepository;
import com.testesperformance.exemplo.adapters.out.repository.entity.ZupperEntity;
import com.testesperformance.exemplo.application.domain.PaginatedResult;
import com.testesperformance.exemplo.application.domain.Pagination;
import com.testesperformance.exemplo.application.domain.Zupper;
import com.testesperformance.exemplo.application.ports.out.BuscarZuppersOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuscarZuppersAdapter implements BuscarZuppersOutputPort {

    private final ZupperRepository zupperRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(BuscarZuppersAdapter.class);

    public BuscarZuppersAdapter(ZupperRepository zupperRepository) {
        this.zupperRepository = zupperRepository;
    }

    @Override
    public PaginatedResult<Zupper> buscar(Pagination pagination) {

        Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getSize(),
                Sort.by(Sort.Direction.fromString(pagination.getDirection()), pagination.getSortBy()));

        LOGGER.info("Buscando zuppers na base de dados");

        Page<ZupperEntity> zuppersEntityPaginados = zupperRepository.findAll(pageable);

        List<Zupper> zuppersPaginados = zuppersEntityPaginados.getContent().stream()
                .map(ZupperEntity::toZupper)
                .collect(Collectors.toList());

        return new PaginatedResult<>(zuppersPaginados, zuppersEntityPaginados.getTotalPages(), zuppersEntityPaginados.getTotalElements());
    }
}
