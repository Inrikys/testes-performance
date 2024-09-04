package com.testesperformance.exemplo.application.ports.in;

import com.testesperformance.exemplo.application.domain.PaginatedResult;
import com.testesperformance.exemplo.application.domain.Pagination;
import com.testesperformance.exemplo.application.domain.Zupper;

public interface BuscarZuppersInputPort {

    PaginatedResult<Zupper> executar(Pagination pagination);

}
