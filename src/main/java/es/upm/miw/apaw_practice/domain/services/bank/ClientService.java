package es.upm.miw.apaw_practice.domain.services.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.upm.miw.apaw_practice.domain.models.bank.Client;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.ClientPersistence;

@Service
public class ClientService {

    private final ClientPersistence clientPersistence;

    @Autowired
    public ClientService(ClientPersistence clientPersistence) {
        this.clientPersistence = clientPersistence;
    }

    public Client read(String dni) {
        return this.clientPersistence.readByDni(dni);
    }
}
