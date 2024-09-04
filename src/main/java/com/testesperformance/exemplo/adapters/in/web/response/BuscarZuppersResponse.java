package com.testesperformance.exemplo.adapters.in.web.response;

import com.testesperformance.exemplo.application.domain.Zupper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BuscarZuppersResponse {

    private Long id;

    private String nome;

    private String sobrenome;

    private String celular;

    private String email;

    public BuscarZuppersResponse(Zupper zupperBuscado) {
        this.id = zupperBuscado.getId();
        this.nome = zupperBuscado.getNome();
        this.sobrenome = zupperBuscado.getSobrenome();
        this.celular = zupperBuscado.getCelular();
        this.email = zupperBuscado.getEmail();
    }
}
