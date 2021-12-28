package br.zup.investimento.investimento;

import br.zup.investimento.investimento.enuns.Risco;
import br.zup.investimento.investimento.model.Investimento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvestimentoRepository extends CrudRepository <Investimento, Integer> {
    List<Investimento> findAllByRisco (Risco risco);
}
