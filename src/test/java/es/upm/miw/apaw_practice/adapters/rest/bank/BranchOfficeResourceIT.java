package es.upm.miw.apaw_practice.adapters.rest.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.bank.BranchOffice;
import es.upm.miw.apaw_practice.domain.models.bank.Client;

@RestTestConfig
public class BranchOfficeResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        BranchOffice branchOffice = new BranchOffice("building 5", 10, 5, null);
        this.webTestClient
                .post()
                .uri(BranchOfficeResource.BRANCH_OFFICE)
                .body(BodyInserters.fromValue(branchOffice))
                .exchange()
                .expectStatus().isOk()
                .expectBody(BranchOffice.class)
                .value(Assertions::assertNotNull);

    }

    @Test
    void testCreateConflict() {
        BranchOffice branchOffice = new BranchOffice("building 1", 10, 1, null);
        this.webTestClient
                .post()
                .uri(BranchOfficeResource.BRANCH_OFFICE)
                .body(BodyInserters.fromValue(branchOffice))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }

    @Test
    void testGetAssociatedBalanceByBuildingName() {
        this.webTestClient
        .get()
        .uri(BranchOfficeResource.BRANCH_OFFICE + BranchOfficeResource.BUILDING_NAME + BranchOfficeResource.BALANCE,"building 1")
        .exchange()
        .expectStatus().isOk()
        .expectBody(BigDecimal.class)
        .value(balance -> {
            assertEquals(0, balance.compareTo(new BigDecimal("600.60")));
        });
    }
}
