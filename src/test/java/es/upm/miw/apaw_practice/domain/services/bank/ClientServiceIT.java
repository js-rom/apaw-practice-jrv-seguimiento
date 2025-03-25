package es.upm.miw.apaw_practice.domain.services.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.bank.Client;
import es.upm.miw.apaw_practice.domain.models.bank.ClientNameUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.ClientPersistence;

@TestConfig
public class ClientServiceIT {

    @Autowired
    ClientService clientService;

    @Autowired
    ClientPersistence clientPersistence;

    @Test
    void updateName() {
        ClientNameUpdating clientNameUpdating = new ClientNameUpdating("11111111A", "pepito");
        this.clientService.updateName("11111111A", clientNameUpdating);
        assertEquals(clientNameUpdating.getName(), this.clientPersistence.readByDni("11111111A").getName());
        clientNameUpdating = new ClientNameUpdating("11111111A", "jesús");
        this.clientService.updateName("11111111A", clientNameUpdating);

    }
}
