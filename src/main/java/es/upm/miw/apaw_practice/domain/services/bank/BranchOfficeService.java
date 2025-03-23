package es.upm.miw.apaw_practice.domain.services.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.bank.BranchOffice;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.BranchOfficePersistence;

@Service
public class BranchOfficeService {

    private final BranchOfficePersistence branchOfficePersistence;

    @Autowired
    public BranchOfficeService(BranchOfficePersistence branchOfficePersistence) {
        this.branchOfficePersistence = branchOfficePersistence;
    }

    public BranchOffice create(BranchOffice branchOffice) {
        this.assertAtmNumberNotExist(branchOffice.getAtmNumber());
        return this.branchOfficePersistence.create(branchOffice);
    }

    public void assertAtmNumberNotExist(Integer atmNumber) {
        if (this.branchOfficePersistence.existAtmNumber(atmNumber)) {
            throw new ConflictException("atmNumber exists " + atmNumber);
        }
    }
}
