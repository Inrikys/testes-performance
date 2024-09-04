package com.testesperformance.exemplo.application.ports.out;

import com.testesperformance.exemplo.application.domain.PaginatedResult;
import com.testesperformance.exemplo.application.domain.Pagination;
import com.testesperformance.exemplo.application.domain.Zupper;

public interface BuscarZuppersOutputPort {

    PaginatedResult<Zupper> buscar(Pagination pagination);

}
