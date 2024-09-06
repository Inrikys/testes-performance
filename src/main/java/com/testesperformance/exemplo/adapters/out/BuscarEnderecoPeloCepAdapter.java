package com.testesperformance.exemplo.adapters.out;

import com.testesperformance.exemplo.adapters.out.client.BuscarEnderecoPeloCepClient;
import com.testesperformance.exemplo.adapters.out.client.response.BuscarEnderecoPeloCepResponse;
import com.testesperformance.exemplo.application.domain.Endereco;
import com.testesperformance.exemplo.application.ports.out.BuscarEnderecoPeloCepOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BuscarEnderecoPeloCepAdapter implements BuscarEnderecoPeloCepOutputPort {

    private final BuscarEnderecoPeloCepClient buscarEnderecoPeloCepClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(BuscarEnderecoPeloCepAdapter.class);

    public BuscarEnderecoPeloCepAdapter(BuscarEnderecoPeloCepClient buscarEnderecoPeloCepClient) {
        this.buscarEnderecoPeloCepClient = buscarEnderecoPeloCepClient;
    }

    @Override
    public Endereco buscar(String cep) {

        LOGGER.info("Buscando endereço através do CEP");

        BuscarEnderecoPeloCepResponse buscar = buscarEnderecoPeloCepClient.buscar(cep);

        return buscar.toEndereco();
    }
}
