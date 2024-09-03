package com.cleanarchitecture.exemplo.application.domain;

import java.time.LocalDate;

public class Zupper {

    private Long id;

    private String nome;

    private String sobrenome;

    private LocalDate dataNascimento;

    private String celular;

    private Endereco endereco;

    private String email;

    public Zupper(Long id, String nome, String sobrenome, LocalDate dataNascimento, String celular, Endereco endereco, String email) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.celular = celular;
        this.endereco = endereco;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getCelular() {
        return celular;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco, String numero) {
        this.endereco = endereco;
        this.endereco.setNumero(numero);
    }

    public String getEmail() {
        return email;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Long id;

        private String nome;

        private String sobrenome;

        private LocalDate dataNascimento;

        private String celular;

        private Endereco endereco;

        private String email;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder setSobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
            return this;
        }

        public Builder setDataNascimento(LocalDate dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public Builder setCelular(String celular) {
            this.celular = celular;
            return this;
        }

        public Builder setEndereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Zupper build() {
            return new Zupper(id, nome, sobrenome, dataNascimento, celular, endereco, email);
        }
    }
}
