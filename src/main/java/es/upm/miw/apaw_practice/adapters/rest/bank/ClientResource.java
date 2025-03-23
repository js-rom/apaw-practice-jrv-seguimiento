package es.upm.miw.apaw_practice.adapters.rest.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.upm.miw.apaw_practice.domain.models.bank.Client;
import es.upm.miw.apaw_practice.domain.services.bank.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(ClientResource.CLIENT)
public class ClientResource {

    static final String CLIENT = "/bank/clients";

    static final String DNI_ID = "/{dni}";

    ClientService clientService;

    @Autowired
    public ClientResource( ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(DNI_ID)
    public Client read(@PathVariable String dni) {
        return this.clientService.read(dni); 
    }
    
}
