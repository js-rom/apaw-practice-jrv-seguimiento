package es.upm.miw.apaw_practice.domain.services.bank;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.bank.BankAccount;
import es.upm.miw.apaw_practice.domain.models.bank.BranchOffice;
import es.upm.miw.apaw_practice.domain.models.bank.Client;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.BankAccountPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.BranchOfficePersistence;

@Service
public class BranchOfficeService {

    private final BankAccountPersistence bankAccountPersistence;
    private final BranchOfficePersistence branchOfficePersistence;

    @Autowired
    public BranchOfficeService(BranchOfficePersistence branchOfficePersistence,
            BankAccountPersistence bankAccountPersistence) {
        this.branchOfficePersistence = branchOfficePersistence;
        this.bankAccountPersistence = bankAccountPersistence;
    }

    public BranchOffice create(BranchOffice branchOffice) {
        this.assertAtmNumberNotExist(branchOffice.getAtmNumber());
        return this.branchOfficePersistence.create(branchOffice);
    }

    public void assertAtmNumberNotExist(Integer atmNumber) {
        if (this.branchOfficePersistence.existAtmNumber(atmNumber)) {
            throw new ConflictException("atmNumber exists " + atmNumber);
        }
    }

    public BigDecimal getAssociatedBalanceByBuildingName(String buildingName) {
        List<String> dnis = this.branchOfficePersistence
                .findByBuildingName(buildingName)
                .getClients().stream()
                .map(Client::getDni)
                .collect(Collectors.toList());

        return this.bankAccountPersistence.readAll()
            .filter(bankAccount -> dnis.contains(bankAccount.getClient().getDni()))
            .map(BankAccount::getBalance)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
