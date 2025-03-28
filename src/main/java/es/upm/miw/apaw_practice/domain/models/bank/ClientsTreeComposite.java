package es.upm.miw.apaw_practice.domain.models.bank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ClientsTreeComposite implements ClientsTree {

    List<ClientsTree> clientsTreeList;

    public ClientsTreeComposite() {
        this.clientsTreeList = new ArrayList<>();
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void add(ClientsTree clientsTree) {
        this.clientsTreeList.add(clientsTree);
    }

    @Override
    public void remove(ClientsTree clientsTree) {
        this.clientsTreeList.remove(clientsTree);
    }

    @Override
    public List<String> getDni() {
        return this.clientsTreeList.stream()
                .map(ClientsTree::getDni)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getName() {
        return this.clientsTreeList.stream()
                .map(ClientsTree::getName)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getSurname() {
        return this.clientsTreeList.stream()
                .map(ClientsTree::getSurname)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> getPhoneNumber() {
        return this.clientsTreeList.stream()
                .map(ClientsTree::getPhoneNumber)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getEmail() {
        return this.clientsTreeList.stream()
                .map(ClientsTree::getEmail)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public List<InvestmentFund> getInvestmentFunds() {
        return this.clientsTreeList.stream()
                .map(ClientsTree::getInvestmentFunds)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

}
