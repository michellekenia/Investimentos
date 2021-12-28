package br.zup.investimento.investimento.dtos;

public class ResumoDTO {

    private String nome;
    private String cpf;
    private double valorInvestido;


    public ResumoDTO(String nome, String cpf, double valorInvestido) {
        this.nome = nome;
        this.cpf = cpf;
        this.valorInvestido = valorInvestido;
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

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }
}
