package es.upm.miw.apaw_practice.domain.services.bank;

import org.springframework.stereotype.Service;

import es.upm.miw.apaw_practice.domain.persistence_ports.bank.InvestmentFundPersistence;

@Service
public class InvestmentFundService {

    InvestmentFundPersistence investmentFundPersistence;

    public InvestmentFundService(InvestmentFundPersistence investmentFundPersistence) {
        this.investmentFundPersistence = investmentFundPersistence;
    }

    public void delete(String name) {
        this.investmentFundPersistence.delete(name);
    }
}
