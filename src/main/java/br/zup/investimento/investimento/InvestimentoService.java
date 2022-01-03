package br.zup.investimento.investimento;

import br.zup.investimento.investimento.dtos.InvestimentoDTO;
import br.zup.investimento.investimento.dtos.InvestimentoSaidaDTO;
import br.zup.investimento.investimento.enuns.Risco;
import br.zup.investimento.investimento.exceptions.investimentoNaoEncontradoException;
import br.zup.investimento.investimento.exceptions.periodoInferiorAoPermitidoException;
import br.zup.investimento.investimento.exceptions.valorNaoPermitidoParaRiscoAltoException;
import br.zup.investimento.investimento.model.Investimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestimentoService {

    @Autowired
    private InvestimentoRepository investimentoRepository;

    public InvestimentoSaidaDTO calcularInvestimento(InvestimentoDTO investimentoDTO) {

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

    public void verificarRiscoEValorInvestido(InvestimentoDTO investimentoDTO) {
        if (investimentoDTO.getRisco() == Risco.ALTO && investimentoDTO.getValorInvestido() < 5000.00) {
            throw new valorNaoPermitidoParaRiscoAltoException("Esse valor está abaixo do permitido para risco alto.");
        }
    }

    public void verificarMesesDoInvestimento(InvestimentoDTO investimentoDTO) {
        if (investimentoDTO.getPeriodoDeAplicacaoMeses() < 2) {
            throw new periodoInferiorAoPermitidoException("O período de meses não pode ser inferior a dois.");
        }
    }

    public void cadastrarInvestimento(InvestimentoDTO investimentoDTO) {
        verificarMesesDoInvestimento(investimentoDTO);
        verificarRiscoEValorInvestido(investimentoDTO);

        Investimento investimento = new Investimento();
        investimento.setEmail(investimentoDTO.getEmail());
        investimento.setNome(investimentoDTO.getNome());
        investimento.setCpf(investimentoDTO.getCpf());
        investimento.setValorInvestido(investimentoDTO.getValorInvestido());
        investimento.setPeriodoDeAplicacaoMeses(investimentoDTO.getPeriodoDeAplicacaoMeses());
        investimento.setRisco(investimentoDTO.getRisco());

        investimentoRepository.save(investimento);
    }

    public InvestimentoSaidaDTO salvarInvestimento(InvestimentoDTO investimentoDTO) {
        cadastrarInvestimento(investimentoDTO);
        return calcularInvestimento(investimentoDTO);
    }

    public List<Investimento> exibirTodosOsinvestimentos(Risco risco) {
        if (risco != null) {
            return investimentoRepository.findAllByRisco(risco);
        }
        List<Investimento> investimentos = (List<Investimento>) investimentoRepository.findAll();
        return investimentos;

    }

    public Investimento buscarInvestimentoPorId(int id) {
        Optional<Investimento> investimento = investimentoRepository.findById(id);
        if (investimento.isEmpty()) {
            throw new investimentoNaoEncontradoException("Esse investimento não existe.");
        }
        return investimento.get();
    }

}
