package com.cleanarchitecture.exemplo.application.domain;

public class Endereco {

    private String cep;

    private String numero;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String localidade;

    private String uf;

    public Endereco(String cep, String numero, String logradouro, String complemento, String bairro, String localidade, String uf) {
        this.cep = cep;
        this.numero = numero;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String cep;

        private String numero;

        private String logradouro;

        private String complemento;

        private String bairro;

        private String localidade;

        private String uf;

        public Builder setCep(String cep) {
            this.cep = cep;
            return this;
        }

        public Builder setNumero(String numero) {
            this.numero = numero;
            return this;
        }

        public Builder setLogradouro(String logradouro) {
            this.logradouro = logradouro;
            return this;
        }

        public Builder setComplemento(String complemento) {
            this.complemento = complemento;
            return this;
        }

        public Builder setBairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public Builder setLocalidade(String localidade) {
            this.localidade = localidade;
            return this;
        }

        public Builder setUf(String uf) {
            this.uf = uf;
            return this;
        }

        public Endereco build() {
            return new Endereco(cep, numero, logradouro, complemento, bairro, localidade, uf);
        }
    }
}
