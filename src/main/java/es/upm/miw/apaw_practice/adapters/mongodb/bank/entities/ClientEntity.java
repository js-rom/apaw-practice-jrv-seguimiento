package es.upm.miw.apaw_practice.adapters.mongodb.bank.entities;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import es.upm.miw.apaw_practice.domain.models.bank.Client;
import es.upm.miw.apaw_practice.domain.models.bank.InvestmentFund;

@Document
public class ClientEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String dni;
    private String name;
    private String surname;
    private Integer phoneNumber;
    private String email;
    @DBRef
    private List<InvestmentFundEntity> investmentFundsEntities;

    public ClientEntity() {
        // empty for framework
    }

    public ClientEntity(String dni, String name, String surname, Integer phoneNumber, String email,
            List<InvestmentFundEntity> investmentFundsEntities) {
        this.id = UUID.randomUUID().toString();
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.investmentFundsEntities = investmentFundsEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setSurname(String surname) {
        this.surname = surname;
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

    public List<InvestmentFundEntity> getInvestmentFundsEntities() {
        return investmentFundsEntities;
    }

    public void setInvestmentFundsEntities(List<InvestmentFundEntity> investmentFundsEntities) {
        this.investmentFundsEntities = investmentFundsEntities;
    }

    public Client toClient() {
        List<InvestmentFund> investmentFunds = this.investmentFundsEntities.stream()
            .map(InvestmentFundEntity::toInvestmentFund)
            .collect(Collectors.toList());
        return new Client(dni, name, surname, phoneNumber, email, investmentFunds);
    }

    public void fromClient(Client client) {
        BeanUtils.copyProperties(client, this);
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
        ClientEntity other = (ClientEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ClientEntity [id=" + id + ", dni=" + dni + ", name=" + name + ", surname=" + surname + ", phoneNumber="
                + phoneNumber + ", email=" + email + ", investmentFundsEntities=" + investmentFundsEntities + "]";
    }

}
