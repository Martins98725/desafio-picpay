package br.com.icaromartins.desafiopicpay.desafio_picpay_backend.trasaction;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TransactionExeceptionHandler {
    @ExceptionHandler(InvalidTransactionException.class)
    public ResponseEntity<Object> handleInvalidTransactionException(InvalidTransactionException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
