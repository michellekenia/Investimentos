package br.zup.investimento.investimento;

public class InvestimentoSaidaDTO {

    private double valorInvestido;
    private double valorTotalDoLucro;
    private double valorTotal;

    public InvestimentoSaidaDTO() {
    }

    public InvestimentoSaidaDTO(double valorInvestido, double valorTotalDoLucro, double valorTotal) {
        this.valorInvestido = valorInvestido;
        this.valorTotalDoLucro = valorTotalDoLucro;
        this.valorTotal = valorTotal;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public double getValorTotalDoLucro() {
        return valorTotalDoLucro;
    }

    public void setValorTotalDoLucro(double valorTotalDoLucro) {
        this.valorTotalDoLucro = valorTotalDoLucro;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
