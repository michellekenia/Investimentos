package br.zup.investimento.investimento.model;

import br.zup.investimento.investimento.enuns.Risco;

public class Investimento {

    private int id;
    private String email;
    private String nome;
    private String cpf;
    private Double valorPrevisto;
    private int periodoDeAplicacaoMeses;
    private Risco risco;

    public Investimento() {
    }

    public Investimento(int id, String email, String nome, String cpf, Double valorPrevisto, int periodoDeAplicacaoMeses, Risco risco) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.valorPrevisto = valorPrevisto;
        this.periodoDeAplicacaoMeses = periodoDeAplicacaoMeses;
        this.risco = risco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getValorPrevisto() {
        return valorPrevisto;
    }

    public void setValorPrevisto(Double valorPrevisto) {
        this.valorPrevisto = valorPrevisto;
    }

    public int getPeriodoDeAplicacaoMeses() {
        return periodoDeAplicacaoMeses;
    }

    public void setPeriodoDeAplicacaoMeses(int periodoDeAplicacaoMeses) {
        this.periodoDeAplicacaoMeses = periodoDeAplicacaoMeses;
    }

    public Risco getRisco() {
        return risco;
    }

    public void setRisco(Risco risco) {
        this.risco = risco;
    }

}
