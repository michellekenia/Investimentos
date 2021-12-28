package br.zup.investimento.investimento.config;

import br.zup.investimento.investimento.exceptions.periodoInferiorAoPermitidoException;
import br.zup.investimento.investimento.exceptions.valorNaoPermitidoParaRiscoAltoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<ErroDeValidacao> manipularErrosDeValidacao(MethodArgumentNotValidException exception) {
        List<ErroDeValidacao> erros = new ArrayList<>();

        for (FieldError fieldError : exception.getFieldErrors()) {
            ErroDeValidacao erroDeValidacao = new ErroDeValidacao(fieldError.getField(),
                    fieldError.getDefaultMessage());
            erros.add(erroDeValidacao);
        }

        return erros;
    }

    @ExceptionHandler(valorNaoPermitidoParaRiscoAltoException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErro manipularExcecaoDeValorNaoPermitidoParaRiscoAlto(valorNaoPermitidoParaRiscoAltoException exception) {
        return new MensagemDeErro(exception.getMessage());
    }

    @ExceptionHandler(periodoInferiorAoPermitidoException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErro manipularExcecaoDePeriodoInferiorAoPermitido(periodoInferiorAoPermitidoException exception) {
        return new MensagemDeErro(exception.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro manipularExcecaoDeEnumInvalido(HttpMessageNotReadableException exception) {
        if (exception.getLocalizedMessage().contains("br.zup.investimento.investimento.enuns.Risco")) {
            return new MensagemDeErro("Esse tipo de risco não é válido.");
        }
        return new MensagemDeErro(exception.getLocalizedMessage());
    }

}
