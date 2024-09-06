package com.testesperformance.exemplo.adapters.in.web.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testesperformance.exemplo.application.domain.Zupper;

import java.time.LocalDate;

public class DetalharZupperResponse {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("sobrenome")
    private String sobrenome;

    @JsonProperty("data_nascimento")
    private LocalDate dataNascimento;

    @JsonProperty("celular")
    private String celular;

    @JsonProperty("endereco")
    private DetalharZupperEnderecoResponse endereco;

    @JsonProperty("email")
    private String email;

    public DetalharZupperResponse(Zupper zupper) {
        this.nome = zupper.getNome();
        this.sobrenome = zupper.getSobrenome();
        this.dataNascimento = zupper.getDataNascimento();
        this.celular = zupper.getCelular();
        this.endereco = new DetalharZupperEnderecoResponse(zupper.getEndereco());
        this.email = zupper.getEmail();
    }

}
