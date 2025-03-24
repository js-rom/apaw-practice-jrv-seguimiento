package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.BankAccountRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.ClientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankAccountEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.ClientEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.BankAccountPersistence;

@Repository("bankAccountPersistence")
public class BankAccountPersistenceMongodb implements BankAccountPersistence {

    BankAccountRepository bankAccountRepository;
    ClientRepository clientRepository;

    public BankAccountPersistenceMongodb(BankAccountRepository bankAccountRepository,
            ClientRepository clientRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public BankAccount readByIban(String iban) {
        return this.bankAccountRepository.findByIban(iban)
                .orElseThrow(() -> new NotFoundException("BankAccount iban:" + iban))
                .toBankAccount();
    }

    @Override
    public BankAccount updateBankAccount(String iban, BankAccount bankAccount) {
        BankAccountEntity bankAccountEntity = this.bankAccountRepository
                .findByIban(iban)
                .orElseThrow(() -> new NotFoundException("BankAccount iban" + iban));
        BeanUtils.copyProperties(bankAccount, bankAccountEntity);
        ClientEntity clientEntity = this.clientRepository
                .findByDni(bankAccount.getClientDni())
                .orElseThrow(() -> new NotFoundException("Client dni:" + bankAccount.getClientDni()));
        bankAccountEntity.setClientEntity(clientEntity);
        return this.bankAccountRepository.save(bankAccountEntity).toBankAccount();
    }

}
