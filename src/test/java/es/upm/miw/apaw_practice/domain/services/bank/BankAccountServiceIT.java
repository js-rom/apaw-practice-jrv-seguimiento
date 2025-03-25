package es.upm.miw.apaw_practice.domain.services.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;
import es.upm.miw.apaw_practice.domain.models.bank.Client;
import es.upm.miw.apaw_practice.domain.models.bank.InvestmentFund;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.BankAccountPersistence;

@TestConfig
public class BankAccountServiceIT {

    @Autowired
    BankAccountService bankAccountService;

    @Autowired
    BankAccountPersistence bankAccountPersistence;

    @Test
    void testUpdate() {
        InvestmentFund[] investmentFunds = {
                new InvestmentFund("fund 001", new BigDecimal("1000000.10"), 10000000),
                new InvestmentFund("fund 002", new BigDecimal("2000000.20"), 20000000) };
        Client client = new Client("55555555E", "pablo", "romero andrades", 555555555, "pablo@gmail.com",
                List.of(investmentFunds[0], investmentFunds[1]));
        BankAccount bankAccount = new BankAccount("iban1", new BigDecimal("200.00"), LocalDate.of(2010, 10, 10),
                false, client);
        this.bankAccountService.updateBankAccount("iban1", bankAccount);
        assertEquals(0,
                this.bankAccountPersistence.readByIban("iban1").getBalance().compareTo(bankAccount.getBalance()));
        assertEquals(0, this.bankAccountPersistence.readByIban("iban1").getOpeningDate()
                .compareTo(bankAccount.getOpeningDate()));
        assertEquals(false, this.bankAccountPersistence.readByIban("iban1").getHasInterest());
        client = new Client("11111111A", "jesús", "romero vidal", 111111111, "jesus.RomeroVidal@gmail.com",
                List.of(investmentFunds[0], investmentFunds[1]));
        bankAccount = new BankAccount("iban1", new BigDecimal("100.10"), LocalDate.of(2020, 1, 31),
                true, client);
        this.bankAccountService.updateBankAccount("iban1", bankAccount);
    }
}
