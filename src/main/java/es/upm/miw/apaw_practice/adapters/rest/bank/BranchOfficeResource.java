package es.upm.miw.apaw_practice.adapters.rest.bank;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.upm.miw.apaw_practice.domain.models.bank.BranchOffice;
import es.upm.miw.apaw_practice.domain.services.bank.BranchOfficeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(BranchOfficeResource.BRANCH_OFFICE)
public class BranchOfficeResource {

    static final String BRANCH_OFFICE = "/bank/branchOffices";

    BranchOfficeService branchOfficeService;

    public BranchOfficeResource(BranchOfficeService branchOfficeService) {
        this.branchOfficeService = branchOfficeService;
    }

    @PostMapping
    public BranchOffice create(@RequestBody BranchOffice branchOffice) {
        return this.branchOfficeService.create(branchOffice);
    }

}
