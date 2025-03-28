package es.upm.miw.apaw_practice.domain.models.bank;

import java.util.List;

public class ClientsTreeLeaf implements ClientsTree {

    private Client client;

    public ClientsTreeLeaf(Client client) {
        this.client = client;
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void add(ClientsTree clientsTree) {
        throw new UnsupportedOperationException("Cannot add to a leaf");
    }

    @Override
    public void remove(ClientsTree clientsTree) {
        throw new UnsupportedOperationException("Cannot remove from a leaf");
    }

    @Override
    public List<String> getDni() {
        return List.of(this.client.getDni());
    }

    @Override
    public List<String> getName() {
        return List.of(this.client.getName());
    }

    @Override
    public List<String> getSurname() {
        return List.of(this.client.getSurname());
    }

    @Override
    public List<Integer> getPhoneNumber() {
        return List.of(this.client.getPhoneNumber());
    }

    @Override
    public List<String> getEmail() {
        return List.of(this.client.getEmail());
    }

    @Override
    public List<InvestmentFund> getInvestmentFunds() {
        return this.client.getInvestmentFunds();
    }

}
