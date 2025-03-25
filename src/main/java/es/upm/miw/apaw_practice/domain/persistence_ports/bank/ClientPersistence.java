package es.upm.miw.apaw_practice.domain.persistence_ports.bank;

import org.springframework.stereotype.Repository;

import es.upm.miw.apaw_practice.domain.models.bank.Client;

@Repository
public interface ClientPersistence {

    Client readByDni(String dni);

    Client update(Client client);
}
