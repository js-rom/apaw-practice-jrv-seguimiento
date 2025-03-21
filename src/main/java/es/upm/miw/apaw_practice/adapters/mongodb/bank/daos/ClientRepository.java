package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.ClientEntity;

public interface ClientRepository extends MongoRepository<ClientEntity, String> {

    Optional<ClientEntity> findByDni(String dni);
}
