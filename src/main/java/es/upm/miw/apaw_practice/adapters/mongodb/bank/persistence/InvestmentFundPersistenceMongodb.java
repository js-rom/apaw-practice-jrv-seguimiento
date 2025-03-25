package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;

import org.springframework.stereotype.Repository;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.InvestmentFundRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.InvestmentFundPersistence;

@Repository("investmentFundPersistence")
public class InvestmentFundPersistenceMongodb implements InvestmentFundPersistence {

    InvestmentFundRepository investmentFundRepository;

    public InvestmentFundPersistenceMongodb(InvestmentFundRepository investmentFundRepository) {
        this.investmentFundRepository = investmentFundRepository;
    }

    @Override
    public void delete(String name) {
        this.investmentFundRepository.deleteByName(name);
    }

}
