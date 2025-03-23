package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.BranchOfficeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BranchOfficeEntity;
import es.upm.miw.apaw_practice.domain.models.bank.BranchOffice;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.BranchOfficePersistence;

@Repository("branchOfficePersistence")
public class BranchOfficePersistenceMongodb implements BranchOfficePersistence {

    private final BranchOfficeRepository branchOfficeRepository;

    @Autowired
    public BranchOfficePersistenceMongodb(BranchOfficeRepository branchOfficeRepository) {
        this.branchOfficeRepository = branchOfficeRepository;
    }

    @Override
    public boolean existAtmNumber(Integer atmNumber) {
        return this.branchOfficeRepository
                .findByAtmNumber(atmNumber)
                .isPresent();
    }

    @Override
    public BranchOffice create(BranchOffice branchOffice) {
        return this.branchOfficeRepository.save(new BranchOfficeEntity(branchOffice)).toBranchOffice();
    }

}
