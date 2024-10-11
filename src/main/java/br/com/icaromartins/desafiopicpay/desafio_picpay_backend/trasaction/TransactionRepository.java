package br.com.icaromartins.desafiopicpay.desafio_picpay_backend.trasaction;

import org.springframework.data.repository.ListCrudRepository;

public interface TransactionRepository extends ListCrudRepository<Transaction, Long> {
}
