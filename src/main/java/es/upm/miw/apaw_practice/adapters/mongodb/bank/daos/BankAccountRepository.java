package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankAccountEntity;

public interface BankAccountRepository extends MongoRepository<BankAccountEntity, String> {

    Optional<BankAccountEntity> findByIban(String iban);
}
