package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.ClientEntity;

@TestConfig
class ClientRepositoryIT {

    @Autowired
    ClientRepository clientRepository;

    @Test
    void testfindByDni() {
        assertTrue(this.clientRepository.findByDni("11111111A").isPresent());
        ClientEntity client = this.clientRepository.findByDni("11111111A").get();
        assertNotNull(client.getId());
        assertEquals("jesús", client.getName());
        assertEquals("romero vidal", client.getSurname());
        assertEquals(111111111, client.getPhoneNumber());
        assertEquals("jesus.RomeroVidal@gmail.com", client.getEmail());
        assertEquals(2, client.getInvestmentFundsEntities().size());

    }
}
