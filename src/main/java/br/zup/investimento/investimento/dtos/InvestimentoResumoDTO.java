package br.zup.investimento.investimento.dtos;

import br.zup.investimento.investimento.enuns.Risco;

public class InvestimentoResumoDTO {

    private String nome;
    private String cpf;
    private Risco risco;

    public InvestimentoResumoDTO(String nome, String cpf, Risco risco) {
        this.nome = nome;
        this.cpf = cpf;
        this.risco = risco;
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

    public Risco getRisco() {
        return risco;
    }

    public void setRisco(Risco risco) {
        this.risco = risco;
    }

}
