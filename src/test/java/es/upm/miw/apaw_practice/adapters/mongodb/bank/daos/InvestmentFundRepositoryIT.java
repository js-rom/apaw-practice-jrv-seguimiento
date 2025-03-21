package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.InvestmentFundEntity;

@TestConfig
class InvestmentFundRepositoryIT {

    @Autowired
    InvestmentFundRepository investmentFundRepository;

    @Test
    void testFindByName() {
        assertTrue(this.investmentFundRepository.findByName("fund 001").isPresent());
        InvestmentFundEntity investmentFund = this.investmentFundRepository.findByName("fund 001").get();
        assertEquals(0, new BigDecimal("1000000.10").compareTo(investmentFund.getTotalCapital()));
        assertEquals(10000000, investmentFund.getAssets());
    }

    @Test
    void testCreateAndRead() {
        assertTrue(this.investmentFundRepository.findAll().stream()
                .anyMatch(investmentFund -> "fund 005".equals(investmentFund.getName()) &&
                        investmentFund.getId() != null &&
                        0 == new BigDecimal("5000000.50").compareTo(investmentFund.getTotalCapital()) &&
                        50000000 == investmentFund.getAssets()));

    }
}
