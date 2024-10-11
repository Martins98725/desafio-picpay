package br.com.icaromartins.desafiopicpay.desafio_picpay_backend.wallet;

public enum WalletType {
    common(1), LOGIST(2);

    private int value;

    WalletType(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
