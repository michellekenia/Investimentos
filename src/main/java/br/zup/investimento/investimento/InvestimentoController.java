package br.zup.investimento.investimento;

import br.zup.investimento.investimento.dtos.InvestimentoDTO;
import br.zup.investimento.investimento.dtos.InvestimentoSaidaDTO;
import br.zup.investimento.investimento.dtos.InvestimentoResumoDTO;
import br.zup.investimento.investimento.enuns.Risco;
import br.zup.investimento.investimento.model.Investimento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/investimentos")
public class InvestimentoController {
    @Autowired
    private InvestimentoService investimentoService;

    @Autowired
    private ModelMapper modelMapper;

    @PutMapping
    public InvestimentoSaidaDTO realizarInvestimento (@RequestBody @Valid InvestimentoDTO investimentoDTO) {
        InvestimentoSaidaDTO investimentoSaidaDTO = investimentoService.salvarInvestimento(investimentoDTO);

        return investimentoSaidaDTO;
    }
    @GetMapping
    public List <InvestimentoResumoDTO> exibirTodosOsInvestimentos (@RequestParam (required = false) Risco risco){

        List<InvestimentoResumoDTO> investimentosDTOS = new ArrayList<>();
        for (Investimento investimento: investimentoService.exibirTodosOsinvestimentos(risco)){
            InvestimentoResumoDTO resumoDTO = modelMapper.map(investimento, InvestimentoResumoDTO.class);
            investimentosDTOS.add(resumoDTO);
        }

        return investimentosDTOS;
    }

}
