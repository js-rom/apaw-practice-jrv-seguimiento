package es.upm.miw.apaw_practice.domain.persistence_ports.bank;

import org.springframework.stereotype.Repository;

import es.upm.miw.apaw_practice.domain.models.bank.BranchOffice;

@Repository
public interface BranchOfficePersistence {

    public boolean existAtmNumber(Integer atmNumber);
    public BranchOffice create(BranchOffice branchOffice);
}
