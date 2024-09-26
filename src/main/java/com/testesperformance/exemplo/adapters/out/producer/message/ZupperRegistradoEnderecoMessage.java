package com.testesperformance.exemplo.adapters.out.producer.message;

import com.testesperformance.exemplo.application.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ZupperRegistradoEnderecoMessage implements Serializable {

    private String cep;
    private String numero;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public ZupperRegistradoEnderecoMessage(Endereco endereco) {
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.logradouro = endereco.getLogradouro();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.localidade = endereco.getLocalidade();
        this.uf = endereco.getUf();
    }
}
