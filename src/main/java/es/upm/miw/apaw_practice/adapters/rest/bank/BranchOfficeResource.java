package es.upm.miw.apaw_practice.adapters.rest.bank;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.upm.miw.apaw_practice.domain.models.bank.BranchOffice;
import es.upm.miw.apaw_practice.domain.services.bank.BranchOfficeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(BranchOfficeResource.BRANCH_OFFICE)
public class BranchOfficeResource {

    static final String BRANCH_OFFICE = "/bank/branch-offices";
    static final String BUILDING_NAME = "/{buildingName}";
    static final String BALANCE = "/balance";

    BranchOfficeService branchOfficeService;

    public BranchOfficeResource(BranchOfficeService branchOfficeService) {
        this.branchOfficeService = branchOfficeService;
    }

    @PostMapping
    public BranchOffice create(@RequestBody BranchOffice branchOffice) {
        return this.branchOfficeService.create(branchOffice);
    }

    @GetMapping(BUILDING_NAME + BALANCE)
    public BigDecimal getAssociatedBalanceByBuildingName(@PathVariable String buildingName) {
        System.out.println(this.branchOfficeService.getAssociatedBalanceByBuildingName(buildingName));
        return this.branchOfficeService.getAssociatedBalanceByBuildingName(buildingName);
    }
    

}
