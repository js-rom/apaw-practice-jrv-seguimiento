package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BranchOfficeEntity;

public interface BranchOfficeRepository extends MongoRepository<BranchOfficeEntity, String> {

    Optional<BranchOfficeEntity> findByAtmNumber(Integer atmNumber);
    Optional<BranchOfficeEntity> findByBuildingName(String buildingName);
}
