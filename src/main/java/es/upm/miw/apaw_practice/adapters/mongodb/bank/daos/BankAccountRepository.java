package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankAccountEntity;

public interface BankAccountRepository extends MongoRepository<BankAccountEntity, String> {

}
