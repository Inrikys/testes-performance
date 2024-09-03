package com.cleanarchitecture.exemplo.adapters.out.repository.entity;

import com.cleanarchitecture.exemplo.application.domain.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = true)
    private String complemento;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String localidade;

    @Column(nullable = false)
    private String uf;

    public EnderecoEntity(Endereco endereco) {
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.logradouro = endereco.getLogradouro();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.localidade = endereco.getLocalidade();
        this.uf = endereco.getUf();
    }

    public Endereco toEndereco() {
        return Endereco.builder()
                .setCep(cep)
                .setNumero(numero)
                .setLogradouro(logradouro)
                .setComplemento(complemento)
                .setBairro(bairro)
                .setLocalidade(localidade)
                .setUf(uf)
                .build();
    }
}
