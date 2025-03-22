package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankAccountEntity;

@TestConfig
class BankAccountRepositoryIT {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Test
    void testFindByIban() {
        assertTrue(this.bankAccountRepository.findByIban("iban2").isPresent());
        BankAccountEntity bankAccount = this.bankAccountRepository.findByIban("iban2").get();
        assertNotNull(bankAccount.getId());
        assertEquals(0, new BigDecimal("200.20").compareTo(bankAccount.getBalance()));
        assertEquals(0, LocalDate.of(2021, 12, 1).compareTo(bankAccount.getOpeningDate()));
        assertFalse(bankAccount.hasInterest());
        assertEquals("11111111A", bankAccount.getClientEntity().getDni());
    }
}
