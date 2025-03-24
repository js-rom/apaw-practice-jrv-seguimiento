package es.upm.miw.apaw_practice.adapters.rest.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;
import es.upm.miw.apaw_practice.domain.services.bank.BankAccountService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(BankAccountResource.BANK_ACCOUNT)
public class BankAccountResource {

    static final String BANK_ACCOUNT = "/bank/bankAccounts"; 
    static final String IBAN_ID = "/{iban}";

    BankAccountService bankAccountService;

    @Autowired
    public BankAccountResource(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PutMapping(IBAN_ID)
    public BankAccount updateBankAccount(@PathVariable String iban, @RequestBody BankAccount bankAccount) {
        return this.bankAccountService.updateBankAccount(iban, bankAccount);
    }
}
