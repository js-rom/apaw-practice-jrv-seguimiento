package es.upm.miw.apaw_practice.domain.persistence_ports.bank;

import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;

@Repository
public interface BankAccountPersistence {
    public BankAccount readByIban(String iban);
    public BankAccount updateBankAccount(BankAccount bankAccount);
    public Stream<BankAccount> readAll();
}
