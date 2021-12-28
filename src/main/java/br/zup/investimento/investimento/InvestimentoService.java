package br.zup.investimento.investimento;

import br.zup.investimento.investimento.dtos.InvestimentoDTO;
import br.zup.investimento.investimento.dtos.InvestimentoSaidaDTO;
import br.zup.investimento.investimento.enuns.Risco;
import br.zup.investimento.investimento.model.Investimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestimentoService {

    @Autowired
    private InvestimentoRepository investimentoRepository;

    public InvestimentoSaidaDTO CalcularInvestimento(InvestimentoDTO investimentoDTO) {

        double taxadeRendimento = investimentoDTO.getRisco().getTaxaDeRendimento();
        double valorInvestido = investimentoDTO.getValorInvestido();
        int periodoDoInvestimento = investimentoDTO.getPeriodoDeAplicacaoMeses();

        double valorDoLucro = 0;
        double valorTotal = valorInvestido;

        for (int i = 0; i < periodoDoInvestimento; i++) {
            valorDoLucro = valorDoLucro + (valorTotal * taxadeRendimento);
            valorTotal = valorInvestido + valorDoLucro;
        }

        InvestimentoSaidaDTO investimentoSaidaDTO = new InvestimentoSaidaDTO(valorInvestido, valorDoLucro, valorTotal);
        return investimentoSaidaDTO;
    }

}
