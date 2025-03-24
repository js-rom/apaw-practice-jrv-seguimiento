package es.upm.miw.apaw_practice.adapters.rest.bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;

@RestTestConfig
public class InvestmentFundResourceIT {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void testDelete() {
        this.webTestClient
            .delete()
            .uri(InvestmentFundResource.INVESTMENT_FUNDS + InvestmentFundResource.NAME, "fund 005")
            .exchange()
            .expectStatus().isOk();
    }
}
