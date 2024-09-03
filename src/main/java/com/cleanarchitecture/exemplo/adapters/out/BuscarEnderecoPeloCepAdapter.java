package com.cleanarchitecture.exemplo.adapters.out;

import com.cleanarchitecture.exemplo.adapters.out.client.BuscarEnderecoPeloCepClient;
import com.cleanarchitecture.exemplo.adapters.out.client.response.BuscarEnderecoPeloCepResponse;
import com.cleanarchitecture.exemplo.application.domain.Endereco;
import com.cleanarchitecture.exemplo.application.ports.out.BuscarEnderecoPeloCepOutputPort;
import org.springframework.stereotype.Component;

@Component
public class BuscarEnderecoPeloCepAdapter implements BuscarEnderecoPeloCepOutputPort {

    private final BuscarEnderecoPeloCepClient buscarEnderecoPeloCepClient;

    public BuscarEnderecoPeloCepAdapter(BuscarEnderecoPeloCepClient buscarEnderecoPeloCepClient) {
        this.buscarEnderecoPeloCepClient = buscarEnderecoPeloCepClient;
    }

    @Override
    public Endereco buscar(String cep) {

        BuscarEnderecoPeloCepResponse buscar = buscarEnderecoPeloCepClient.buscar(cep);

        return buscar.toEndereco();
    }
}
