package es.upm.miw.apaw_practice.adapters.rest.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.bank.Client;
import es.upm.miw.apaw_practice.domain.models.bank.ClientNameUpdating;

@RestTestConfig
public class ClientEntityResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(ClientResource.CLIENT + ClientResource.DNI_ID, "11111111A")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Client.class)
                .value(Assertions::assertNotNull)
                .value(clientData -> {
                    assertEquals("jesús", clientData.getName());
                    assertEquals("romero vidal", clientData.getSurname());
                    assertEquals(111111111, clientData.getPhoneNumber());
                    assertEquals("jesus.RomeroVidal@gmail.com", clientData.getEmail());
                    assertEquals("fund 002", clientData.getInvestmentFunds().get(1).getName());
                });
    }

    @Test
    void testReadNotFound() {

        this.webTestClient
                .get()
                .uri(ClientResource.CLIENT + ClientResource.DNI_ID, "asd")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testUpdateName() {
        ClientNameUpdating clientNameUpdating = new ClientNameUpdating("11111111A", "pepito");
        this.webTestClient
            .patch()
            .uri(ClientResource.CLIENT + ClientResource.DNI_ID, "11111111A")
            .body(BodyInserters.fromValue(clientNameUpdating))
            .exchange()
            .expectStatus().isOk();
    }
}
