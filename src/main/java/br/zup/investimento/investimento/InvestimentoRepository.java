package br.zup.investimento.investimento;

import br.zup.investimento.investimento.model.Investimento;
import org.springframework.data.repository.CrudRepository;

public interface InvestimentoRepository extends CrudRepository <Investimento, Integer> {
}
