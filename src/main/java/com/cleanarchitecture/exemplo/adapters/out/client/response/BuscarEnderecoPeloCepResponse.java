package com.cleanarchitecture.exemplo.adapters.out.client.response;

import com.cleanarchitecture.exemplo.application.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BuscarEnderecoPeloCepResponse {

    private String cep;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String localidade;

    private String uf;

    public Endereco toEndereco() {
        return Endereco.builder()
                .setCep(cep)
                .setLogradouro(logradouro)
                .setComplemento(complemento)
                .setBairro(bairro)
                .setLocalidade(localidade)
                .setUf(uf)
                .build();
    }

}
