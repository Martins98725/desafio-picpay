package br.com.icaromartins.desafiopicpay.desafio_picpay_backend.authorization;

public class UnauthorizedExeception extends RuntimeException{
    public UnauthorizedExeception(String message) {
        super(message);
    }
}
