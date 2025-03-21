package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.ClientEntity;

public interface ClientRepository extends MongoRepository<ClientEntity, String> {

}
