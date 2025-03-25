package es.upm.miw.apaw_practice.adapters.rest.bank;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.upm.miw.apaw_practice.domain.services.bank.InvestmentFundService;

@RestController
@RequestMapping(InvestmentFundResource.INVESTMENT_FUNDS)
public class InvestmentFundResource {

    static final String INVESTMENT_FUNDS = "/bank/investment-funds";
    static final String NAME = "/{name}";

    InvestmentFundService investmentFundService;

    public InvestmentFundResource(InvestmentFundService investmentFundService) {
        this.investmentFundService = investmentFundService;
    }

    @DeleteMapping(NAME)
    public void delete(@PathVariable String name) {
        this.investmentFundService.delete(name);
    }
}
