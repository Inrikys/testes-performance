package com.cleanarchitecture.exemplo.adapters.in.web.response;

import com.cleanarchitecture.exemplo.application.domain.Zupper;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrarZupperResponse {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("sobrenome")
    private String sobrenome;

    @JsonProperty("data_nascimento")
    private LocalDate dataNascimento;

    @JsonProperty("celular")
    private String celular;

    @JsonProperty("endereco")
    private RegistrarZupperEnderecoResponse endereco;

    @JsonProperty("email")
    private String email;

    public RegistrarZupperResponse(Zupper zupperRegistrado) {
        this.nome = zupperRegistrado.getNome();
        this.sobrenome = zupperRegistrado.getSobrenome();
        this.dataNascimento = zupperRegistrado.getDataNascimento();
        this.celular = zupperRegistrado.getCelular();
        this.endereco = new RegistrarZupperEnderecoResponse(zupperRegistrado.getEndereco());
        this.email = zupperRegistrado.getEmail();
    }
}
