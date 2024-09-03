package com.cleanarchitecture.exemplo.adapters.out.producer.message;

import com.cleanarchitecture.exemplo.application.domain.Zupper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ZupperRegistradoMessage implements Serializable {

    private Long id;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String celular;
    private ZupperRegistradoEnderecoMessage endereco;
    private String email;

    public ZupperRegistradoMessage(Zupper zupper) {
        this.id = zupper.getId();
        this.nome = zupper.getNome();
        this.sobrenome = zupper.getSobrenome();
        this.dataNascimento = zupper.getDataNascimento();
        this.celular = zupper.getCelular();
        this.endereco = new ZupperRegistradoEnderecoMessage(zupper.getEndereco());
        this.email = zupper.getEmail();
    }
}
