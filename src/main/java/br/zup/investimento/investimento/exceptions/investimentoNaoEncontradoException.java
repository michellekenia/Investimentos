package br.zup.investimento.investimento.exceptions;

public class investimentoNaoEncontradoException extends RuntimeException{
    public investimentoNaoEncontradoException(String message) {
        super(message);
    }
}
