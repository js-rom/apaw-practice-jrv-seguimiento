package es.upm.miw.apaw_practice.domain.models.bank;

import java.util.List;

import es.upm.miw.apaw_practice.domain.models.bank.ClientBuilders.Optionals;

public class Client {

    private String dni;
    private String name;
    private String surname;
    private Integer phoneNumber;
    private String email;
    private List<InvestmentFund> investmentFunds;

    public Client() {
        // empty for framework
    }

    public Client(String dni, String name, String surName, Integer phoneNumber, String email,
            List<InvestmentFund> investmentFunds) {
        this.dni = dni;
        this.name = name;
        this.surname = surName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.investmentFunds = investmentFunds;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surName) {
        this.surname = surName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<InvestmentFund> getInvestmentFunds() {
        return investmentFunds;
    }

    public void setInvestmentFunds(List<InvestmentFund> investmentFunds) {
        this.investmentFunds = investmentFunds;
    }

    public static ClientBuilders.Dni builder() {
        return new Builder();
    }

    public static class Builder implements ClientBuilders.Dni, ClientBuilders.Name, ClientBuilders.Optionals {

        private Client client;

        public Builder() {
            this.client = new Client();
        }

        @Override
        public Optionals surName(String surName) {
            this.client.surname = surName;
            return this;
        }

        @Override
        public Optionals phoneNumber(int phoneNumber) {
            this.client.phoneNumber = phoneNumber;
            return this;
        }

        @Override
        public Optionals email(String email) {
            this.client.email = email;
            return this;
        }

        @Override
        public Optionals investmentFunds(List<InvestmentFund> investmentFunds) {
            this.client.investmentFunds = investmentFunds;
            return this;
        }

        @Override
        public Optionals name(String name) {
            this.client.name = name;
            return this;
        }

        @Override
        public ClientBuilders.Name dni(String dni) {
            this.client.dni = dni;
            return this;
        }

        @Override
        public Client build() {
            return this.client;
        }

    }

    @Override
    public String toString() {
        return "Client [dni=" + dni + ", name=" + name + ", surname=" + surname + ", phoneNumber=" + phoneNumber
                + ", email=" + email + ", investmentFunds=" + investmentFunds + "]";
    }

}
