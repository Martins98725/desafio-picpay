package br.com.icaromartins.desafiopicpay.desafio_picpay_backend.trasaction;

public class InvalidTransactionException extends RuntimeException {
    public InvalidTransactionException(String message) {
        super(message);
    }
}
