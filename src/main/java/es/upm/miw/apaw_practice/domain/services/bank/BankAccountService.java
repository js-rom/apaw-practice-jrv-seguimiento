package es.upm.miw.apaw_practice.domain.services.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.BankAccountPersistence;

@Service
public class BankAccountService {

    BankAccountPersistence bankAccountPersistence;

    @Autowired
    public BankAccountService(BankAccountPersistence bankAccountPersistence) {
        this.bankAccountPersistence = bankAccountPersistence;
    }

    public BankAccount updateBankAccount(String iban, BankAccount bankAccount) {
        return this.bankAccountPersistence.updateBankAccount(iban,bankAccount);
    }
}
