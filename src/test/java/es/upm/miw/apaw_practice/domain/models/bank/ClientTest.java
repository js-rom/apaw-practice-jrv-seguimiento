package es.upm.miw.apaw_practice.domain.models.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.upm.miw.apaw_practice.TestConfig;

@TestConfig
public class ClientTest {

    @Test
    void testBuilder() {
        Client client = Client.builder()
            .dni("111111111A")
            .name("jesus")
            .email("jesus@gmail.com")
            .phoneNumber(111111111)
            .surName("romero vidal")
            .investmentFunds(List.of(new InvestmentFund("Fund A", new BigDecimal("1000.0"), 32)))
            .build();

            assertNotNull(client);
            assertEquals("111111111A", client.getDni());
            assertEquals("jesus", client.getName());
            assertEquals("jesus@gmail.com", client.getEmail());
            assertEquals(111111111, client.getPhoneNumber());
            assertNotNull(client.getInvestmentFunds());
    }
}
