package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.InvestmentFundEntity;

public interface InvestmentFundRepository extends MongoRepository<InvestmentFundEntity, String> {

    Optional<InvestmentFundEntity> findByName(String name);
}
