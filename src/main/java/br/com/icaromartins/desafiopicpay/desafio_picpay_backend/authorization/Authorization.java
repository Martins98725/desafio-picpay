package br.com.icaromartins.desafiopicpay.desafio_picpay_backend.authorization;

public record Authorization(String message) {

    public boolean isAuthorized() {
        return message.equals("Autorizado");
    }
}
