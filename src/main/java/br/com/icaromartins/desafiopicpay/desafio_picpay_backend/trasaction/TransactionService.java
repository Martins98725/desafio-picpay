package br.com.icaromartins.desafiopicpay.desafio_picpay_backend.trasaction;

import br.com.icaromartins.desafiopicpay.desafio_picpay_backend.wallet.Wallet;
import br.com.icaromartins.desafiopicpay.desafio_picpay_backend.wallet.WalletRepository;
import br.com.icaromartins.desafiopicpay.desafio_picpay_backend.wallet.WalletType;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final WalletRepository walletRepository;

    public TransactionService(TransactionRepository transactionRepository, WalletRepository walletRepository) {
        this.transactionRepository = transactionRepository;
        this.walletRepository = walletRepository;

    }

    public Transaction createTransaction(Transaction transaction) {

        //Validate()

        var newTrasaction = transactionRepository.save(transaction);

        var wallet = walletRepository.findById(transaction.payer()).get();
        walletRepository.save(wallet.debit(transaction.value()));

        return newTrasaction;
    }

    private void Validate(Transaction transaction) {
        walletRepository.findById(transaction.payee())
                .map(payee -> walletRepository.findById(transaction.payer())
                        .map(payer -> isTrasactionValidate(transaction, payer) ? transaction : null));
    }

    private  boolean isTrasactionValidate(Transaction transaction, Wallet payer){
        return payer.type() == WalletType.common.getValue() &&
                payer.balance().compareTo(transaction.value()) >= 0 &&
                !payer.id().equals(transaction.payee());
    }
}
