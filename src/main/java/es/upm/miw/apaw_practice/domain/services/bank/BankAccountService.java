package es.upm.miw.apaw_practice.domain.services.bank;

import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;
import es.upm.miw.apaw_practice.domain.models.bank.Client;
import es.upm.miw.apaw_practice.domain.models.bank.InvestmentFund;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.BankAccountPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.ClientPersistence;

@Service
public class BankAccountService {

    BankAccountPersistence bankAccountPersistence;
    ClientPersistence clientPersistence;

    @Autowired
    public BankAccountService(BankAccountPersistence bankAccountPersistence, ClientPersistence clientPersistence) {
        this.bankAccountPersistence = bankAccountPersistence;
        this.clientPersistence = clientPersistence;
    }

    public BankAccount updateBankAccount(String iban, BankAccount bankAccount) {
        BankAccount newBankAccount = this.bankAccountPersistence.readByIban(iban);
        BeanUtils.copyProperties(bankAccount, newBankAccount);
        Client client = this.clientPersistence.readByDni(bankAccount.getClientDni());
        newBankAccount.setClient(client);
        return this.bankAccountPersistence.updateBankAccount(newBankAccount);
    }

    public Stream<InvestmentFund> getAssociatedInvestmentFunds(String iban) {
        return this.bankAccountPersistence.getAssociatedInvestmentFunds(iban);

    }
}
