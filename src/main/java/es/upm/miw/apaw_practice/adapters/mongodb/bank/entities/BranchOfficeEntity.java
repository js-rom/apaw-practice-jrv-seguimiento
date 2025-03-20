package es.upm.miw.apaw_practice.adapters.mongodb.bank.entities;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BranchOfficeEntity {

    @Id
    private String id;
    private String buildingName;
    private Integer employees;
    @Indexed(unique = true)
    private Integer atmNumber;
    @DBRef
    private List<ClientEntity> clientsEntities;

    public BranchOfficeEntity() {
        // empty for framework
    }

    public BranchOfficeEntity(String buildingName, Integer employees, Integer atmNumber,
            List<ClientEntity> clientsEntities) {
        this.id = UUID.randomUUID().toString();
        this.buildingName = buildingName;
        this.employees = employees;
        this.atmNumber = atmNumber;
        this.clientsEntities = clientsEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<ClientEntity> getClientsEntities() {
        return clientsEntities;
    }

    public void setClientsEntities(List<ClientEntity> clientsEntities) {
        this.clientsEntities = clientsEntities;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BranchOfficeEntity other = (BranchOfficeEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BranchOfficeEntity [id=" + id + ", buildingName=" + buildingName + ", employees=" + employees
                + ", atmNumber=" + atmNumber + ", clientsEntities=" + clientsEntities + "]";
    }

}
