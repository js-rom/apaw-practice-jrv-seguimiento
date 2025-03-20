package es.upm.miw.apaw_practice.domain.models.bank;

import java.util.List;

public class BranchOffice {

    private String buildingName;
    private Integer employees;
    private Integer atmNumber;
    private List<Client> clients;

    public BranchOffice() {
        // empty for framework
    }

    public BranchOffice(String buildingName, Integer employees, Integer atmNumber, List<Client> clients) {
        this.buildingName = buildingName;
        this.employees = employees;
        this.atmNumber = atmNumber;
        this.clients = clients;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees(Integer employees) {
        this.employees = employees;
    }

    public Integer getAtmNumber() {
        return atmNumber;
    }

    public void setAtmNumber(Integer atmNumber) {
        this.atmNumber = atmNumber;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "BranchOffice [buildingName=" + buildingName + ", employees=" + employees + ", atmNumber=" + atmNumber
                + ", clients=" + clients + "]";
    }

}
