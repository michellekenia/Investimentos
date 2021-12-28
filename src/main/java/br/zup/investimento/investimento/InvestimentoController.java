package br.zup.investimento.investimento;

import br.zup.investimento.investimento.dtos.InvestimentoDTO;
import br.zup.investimento.investimento.dtos.InvestimentoSaidaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/investimentos")
public class InvestimentoController {
    @Autowired
    private InvestimentoService investimentoService;

    @PutMapping
    public InvestimentoSaidaDTO realizarInvestimento (@RequestBody @Valid InvestimentoDTO investimentoDTO) {
        InvestimentoSaidaDTO investimentoSaidaDTO = investimentoService.salvarInvestimento(investimentoDTO);

        return investimentoSaidaDTO;
    }




}
