package es.upm.miw.apaw_practice.adapters.mongodb.bank.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BankAccountEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String iban;
    private BigDecimal balance;
    private LocalDate openingDate;
    private Boolean hasInterest;
    @DBRef
    private ClientEntity clientEntity;

    public BankAccountEntity() {
        // empty for framework
    }

    public BankAccountEntity(String iban, BigDecimal balance, LocalDate openingDate, Boolean hasInterest,
            ClientEntity clientEntity) {
        this.id = UUID.randomUUID().toString();
        this.iban = iban;
        this.balance = balance;
        this.openingDate = openingDate;
        this.hasInterest = hasInterest;
        this.clientEntity = clientEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public Boolean hasInterest() {
        return hasInterest;
    }

    public void setHasInterest(Boolean hasInterest) {
        this.hasInterest = hasInterest;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BankAccountEntity other = (BankAccountEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BankAccountEntity [id=" + id + ", iban=" + iban + ", balance=" + balance + ", openingDate="
                + openingDate + ", hasInterest=" + hasInterest + ", clientEntity=" + clientEntity + "]";
    }


}
