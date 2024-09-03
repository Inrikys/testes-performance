package com.testesperformance.exemplo.adapters.out.client.response;

import com.testesperformance.exemplo.application.domain.Endereco;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
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
