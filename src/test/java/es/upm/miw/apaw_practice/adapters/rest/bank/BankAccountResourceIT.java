package es.upm.miw.apaw_practice.adapters.rest.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;
import es.upm.miw.apaw_practice.domain.models.bank.Client;

@RestTestConfig
public class BankAccountResourceIT {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void testUpdate() {
        Client client = new Client("11111111A", "jesús", "romero vidal", 111111111, "jesus.RomeroVidal@gmail.com",
                        null);
        BankAccount bankAccount = new BankAccount("iban1", new BigDecimal("200.20"), LocalDate.of(2021, 1, 1),
                true, client);
        this.webTestClient
            .put()
            .uri(BankAccountResource.BANK_ACCOUNT + BankAccountResource.IBAN_ID,"iban1")
            .body(BodyInserters.fromValue(bankAccount))
            .exchange()
            .expectStatus().isOk()
            .expectBody(BankAccount.class)
            .value(Assertions::assertNotNull)
            .value(bankAccountData -> {
                    assertEquals("iban1", bankAccountData.getIban());
                    assertEquals(0, bankAccountData.getBalance().compareTo(new BigDecimal("200.20")));
                    assertEquals(0, bankAccountData.getOpeningDate().compareTo(LocalDate.of(2021, 1, 1)));
                    assertEquals(true, bankAccount.hasInterest());
                });
    }

    @Test
    void testUpdateNotFound() {
        Client client = new Client("11111111A", "jesús", "romero vidal", 111111111, "jesus.RomeroVidal@gmail.com",
                        null);
        BankAccount bankAccount = new BankAccount("iban1", new BigDecimal("200.20"), LocalDate.of(2021, 1, 1),
                true, client);
        this.webTestClient
            .put()
            .uri(BankAccountResource.BANK_ACCOUNT + BankAccountResource.IBAN_ID,"iban8")
            .body(BodyInserters.fromValue(bankAccount))
            .exchange()
            .expectStatus().isNotFound();
            
    }
}
