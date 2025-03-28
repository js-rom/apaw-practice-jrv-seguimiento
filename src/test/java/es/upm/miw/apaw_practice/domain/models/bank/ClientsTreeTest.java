package es.upm.miw.apaw_practice.domain.models.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.miw.apaw_practice.TestConfig;

@TestConfig
class ClientsTreeTest {

    private ClientsTreeLeaf clientsTreeLeaf1;
    private ClientsTreeLeaf clientsTreeLeaf2;
    private ClientsTreeLeaf clientsTreeLeaf3;
    private ClientsTreeComposite clientsTreeComposite1;
    private ClientsTreeComposite clientsTreeComposite2;
    InvestmentFund investmentFund1;
    Client client1;
    InvestmentFund investmentFund2;
    Client client2;
    InvestmentFund investmentFund3;
    Client client3;

    @BeforeEach
    void initContext() {
        this.investmentFund1 = new InvestmentFund("fund 001", new BigDecimal("1000000.10"), 10000000);
        this.client1 = new Client("11111111A", "jesús", "romero vidal", 111111111, "jesus.RomeroVidal@gmail.com",
                List.of(investmentFund1));
        this.investmentFund2 = new InvestmentFund("fund 002", new BigDecimal("2000000.20"), 20000000);
        this.client2 = new Client("22222222B", "alba", "saborido velázquez", 222222222, "alba@gmail.com",
                List.of(investmentFund2));
        this.investmentFund3 = new InvestmentFund("fund 003", new BigDecimal("3000000.30"), 30000000);
        this.client3 = new Client("33333333C", "inmaculada", "romero vidal", 33333333, "inmaculada@gmail.com",
                List.of(investmentFund3));
        this.clientsTreeLeaf1 = new ClientsTreeLeaf(client1);
        this.clientsTreeLeaf2 = new ClientsTreeLeaf(client2);
        this.clientsTreeLeaf3 = new ClientsTreeLeaf(client3);
        this.clientsTreeComposite2 = new ClientsTreeComposite();
        this.clientsTreeComposite2.add(this.clientsTreeLeaf2);
        this.clientsTreeComposite2.add(this.clientsTreeLeaf3);
        this.clientsTreeComposite1 = new ClientsTreeComposite();
        this.clientsTreeComposite1.add(this.clientsTreeLeaf1);
        this.clientsTreeComposite1.add(clientsTreeComposite2);
    }

    @Test
    void testLeaf() {
        assertFalse(this.clientsTreeLeaf1.isComposite());
        assertEquals(List.of(this.client1.getDni()), this.clientsTreeLeaf1.getDni());
        assertEquals(List.of(this.client1.getName()), this.clientsTreeLeaf1.getName());
        assertEquals(List.of(this.client1.getSurname()), this.clientsTreeLeaf1.getSurname());
        assertEquals(List.of(this.client1.getPhoneNumber()), this.clientsTreeLeaf1.getPhoneNumber());
        assertEquals(List.of(this.client1.getEmail()), this.clientsTreeLeaf1.getEmail());
        assertEquals(this.client1.getInvestmentFunds().get(0).getName(), this.clientsTreeLeaf1.getInvestmentFunds().get(0).getName());
        assertThrows(UnsupportedOperationException.class, () -> this.clientsTreeLeaf1.add(this.clientsTreeLeaf2));
        assertThrows(UnsupportedOperationException.class, () -> this.clientsTreeLeaf1.remove(this.clientsTreeLeaf2));
    }

    @Test
    void testComposite() {
        assertTrue(this.clientsTreeComposite1.isComposite());
        assertEquals(List.of("11111111A", "22222222B", "33333333C"), clientsTreeComposite1.getDni());
        assertEquals(List.of("jesús", "alba", "inmaculada"), clientsTreeComposite1.getName());
        assertEquals(List.of("romero vidal", "saborido velázquez", "romero vidal"), clientsTreeComposite1.getSurname());
        assertEquals(List.of(111111111, 222222222, 33333333), clientsTreeComposite1.getPhoneNumber());
        assertEquals(List.of("jesus.RomeroVidal@gmail.com", "alba@gmail.com", "inmaculada@gmail.com"), clientsTreeComposite1.getEmail());
        assertEquals(3, clientsTreeComposite1.getInvestmentFunds().size());
    }
}
