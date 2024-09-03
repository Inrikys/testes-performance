package com.testesperformance.exemplo.adapters.out.client;

import com.testesperformance.exemplo.adapters.out.client.response.BuscarEnderecoPeloCepResponse;
import com.testesperformance.exemplo.config.mock.NotMockExternalServicesCondition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Conditional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "BuscarEnderecoPeloCepClient",
        url = "${buscar-endereco.api.url}"
)
@Conditional(NotMockExternalServicesCondition.class)
public interface BuscarEnderecoPeloCepClient {

    @GetMapping("/{cep}/json")
    BuscarEnderecoPeloCepResponse buscar(@PathVariable String cep);

}
