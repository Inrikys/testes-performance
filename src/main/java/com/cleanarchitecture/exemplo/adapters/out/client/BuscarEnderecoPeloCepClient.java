package com.cleanarchitecture.exemplo.adapters.out.client;

import com.cleanarchitecture.exemplo.adapters.out.client.response.BuscarEnderecoPeloCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "BuscarEnderecoPeloCepClient",
        url = "${buscar-endereco.api.url}"
)
public interface BuscarEnderecoPeloCepClient {

    @GetMapping("/{cep}/json")
    BuscarEnderecoPeloCepResponse buscar(@PathVariable String cep);

}
