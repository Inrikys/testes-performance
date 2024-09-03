package com.cleanarchitecture.exemplo.adapters.out.repository.entity;

import com.cleanarchitecture.exemplo.application.domain.Zupper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ZupperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String celular;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id")
    private EnderecoEntity endereco;

    @Column(nullable = false, unique = true)
    private String email;

    public ZupperEntity(Zupper zupper) {
        this.nome = zupper.getNome();
        this.sobrenome = zupper.getSobrenome();
        this.dataNascimento = zupper.getDataNascimento();
        this.celular = zupper.getCelular();
        this.endereco = new EnderecoEntity(zupper.getEndereco());
        this.email = zupper.getEmail();
    }

    public Zupper toZupper() {
        return Zupper.builder()
                .setId(id)
                .setNome(nome)
                .setSobrenome(sobrenome)
                .setDataNascimento(dataNascimento)
                .setCelular(celular)
                .setEndereco(endereco.toEndereco())
                .setEmail(email)
                .build();
    }
}
