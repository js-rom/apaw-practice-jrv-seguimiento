package es.upm.miw.apaw_practice.domain.models.bank;

import java.util.List;

public interface ClientsTree {

    boolean isComposite();

    void add(ClientsTree clientsTree);

    void remove(ClientsTree clientsTree);

    List<String> getDni();

    List<String> getName();

    List<String> getSurname();

    List<Integer> getPhoneNumber();

    List<String> getEmail();

    List<InvestmentFund> getInvestmentFunds();
}
