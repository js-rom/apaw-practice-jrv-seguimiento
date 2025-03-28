package es.upm.miw.apaw_practice.domain.models.bank;

import java.util.List;

public interface ClientBuilders {

    public interface Dni {  
        ClientBuilders.Name dni(String dni);
    }

    public interface Name {
        ClientBuilders.Optionals name(String name);
    }

    public interface Optionals {
        ClientBuilders.Optionals surName(String surName);
        ClientBuilders.Optionals phoneNumber(int phoneNumber);
        ClientBuilders.Optionals email(String email);
        ClientBuilders.Optionals investmentFunds(List<InvestmentFund> investmentFunds);
        Client build();
    }
}
