package es.upm.miw.apaw_practice.adapters.mongodb.bank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.BankAccountRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.BranchOfficeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.ClientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.InvestmentFundRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BankAccountEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.BranchOfficeEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.ClientEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.InvestmentFundEntity;
import es.upm.miw.apaw_practice.domain.models.bank.InvestmentFund;

@Service
public class BankSeederService {

    @Autowired
    private InvestmentFundRepository investmentFundRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private BranchOfficeRepository branchOfficeRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Bank Initial Load -----------");

        InvestmentFundEntity[] investmentFunds = {
                new InvestmentFundEntity(new InvestmentFund("fund 001", new BigDecimal("1000000.10"), 10000000)),
                new InvestmentFundEntity(new InvestmentFund("fund 002", new BigDecimal("2000000.20"), 20000000)),
                new InvestmentFundEntity(new InvestmentFund("fund 003", new BigDecimal("3000000.30"), 30000000)),
                new InvestmentFundEntity(new InvestmentFund("fund 004", new BigDecimal("4000000.40"), 40000000)),
                new InvestmentFundEntity(new InvestmentFund("fund 005", new BigDecimal("5000000.50"), 50000000))
        };
        this.investmentFundRepository.saveAll(Arrays.asList(investmentFunds));
        ClientEntity[] clients = {
                new ClientEntity("11111111A", "jesús", "romero vidal", 111111111, "jesus.RomeroVidal@gmail.com",
                        List.of(investmentFunds[0], investmentFunds[1])),
                new ClientEntity("22222222B", "alba", "saborido velázquez", 222222222, "alba@gmail.com",
                        List.of(investmentFunds[2])),
                new ClientEntity("33333333C", "inmaculada", "romero vidal", 33333333, "inmaculada@gmail.com",
                        List.of(investmentFunds[3])),
                new ClientEntity("44444444D", "juan francisco", "romero vidal", 444444444, "juan@gmail.com",
                        List.of(investmentFunds[4])),
                new ClientEntity("55555555E", "pablo", "romero andrades", 555555555, "pablo@gmail.com",
                        null),
        };
        this.clientRepository.saveAll(Arrays.asList(clients));
        BankAccountEntity[] bankAccounts = {
                new BankAccountEntity("iban1", new BigDecimal("100.10"), LocalDate.of(2020, 1, 31),
                        true, clients[0]),
                new BankAccountEntity("iban2", new BigDecimal("200.20"), LocalDate.of(2021, 12, 1),
                        false, clients[0]),
                new BankAccountEntity("iban3", new BigDecimal("300.30"), LocalDate.of(2022, 6, 30),
                        true, clients[1]),
                new BankAccountEntity("iban4", new BigDecimal("400.40"), LocalDate.of(2024, 3, 14),
                        true, clients[2]),
                new BankAccountEntity("iban5", new BigDecimal("500.50"), LocalDate.of(2024, 3, 14),
                        false, clients[3]),
                new BankAccountEntity("iban6", new BigDecimal("600.60"), LocalDate.of(2024, 3, 14),
                        true, clients[4]),
                new BankAccountEntity("iban7", new BigDecimal("700.70"), LocalDate.of(2024, 3, 14),
                        true, null),
        };
        this.bankAccountRepository.saveAll(Arrays.asList(bankAccounts));
        BranchOfficeEntity[] branchOffices = {
                new BranchOfficeEntity("building 1", 10, 1, List.of(clients[0], clients[1])),
                new BranchOfficeEntity("building 2", 20, 2, List.of(clients[0], clients[1], clients[2])),
                new BranchOfficeEntity("building 3", 30, 3, List.of(clients[3], clients[4])),
                new BranchOfficeEntity("building 4", 40, 4, null)
        };
        this.branchOfficeRepository.saveAll(Arrays.asList(branchOffices));
    }

    public void deleteAll() {
        this.branchOfficeRepository.deleteAll();
        this.bankAccountRepository.deleteAll();
        this.clientRepository.deleteAll();
        this.investmentFundRepository.deleteAll();
    }
}
