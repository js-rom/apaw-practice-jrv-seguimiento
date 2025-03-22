package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BranchOfficeEntity;

@TestConfig
class BranchOfficeRepositoryIT {

    @Autowired
    BranchOfficeRepository branchOfficeRepository;

    @Test
    void testFindByAtmNumber() {
        assertTrue(this.branchOfficeRepository.findByAtmNumber(2).isPresent());
        BranchOfficeEntity branchOffice = this.branchOfficeRepository.findByAtmNumber(2).get();
        assertNotNull(branchOffice.getId());
        assertEquals("building 2", branchOffice.getBuildingName());
        assertEquals(20, branchOffice.getEmployees());
        assertEquals(3, branchOffice.getClientsEntities().size());
    }
}
