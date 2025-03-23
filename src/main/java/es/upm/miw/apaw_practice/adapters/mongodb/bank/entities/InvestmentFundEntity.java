package es.upm.miw.apaw_practice.adapters.mongodb.bank.entities;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import es.upm.miw.apaw_practice.domain.models.bank.InvestmentFund;

@Document
public class InvestmentFundEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private BigDecimal totalCapital;
    private Integer assets;

    public InvestmentFundEntity() {
        // empty for framework
    }

    public InvestmentFundEntity(InvestmentFund investmentFund) {
        BeanUtils.copyProperties(investmentFund, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotalCapital() {
        return totalCapital;
    }

    public void setTotalCapital(BigDecimal totalCapital) {
        this.totalCapital = totalCapital;
    }

    public Integer getAssets() {
        return assets;
    }

    public void setAssets(Integer assets) {
        this.assets = assets;
    }

    public InvestmentFund toInvestmentFund() {
        return new InvestmentFund(name, totalCapital, assets);
    }

    @Override
    public String toString() {
        return "InvestmentFundEntity [id=" + id + ", name=" + name + ", totalCapital=" + totalCapital + ", assets="
                + assets + "]";
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
        InvestmentFundEntity other = (InvestmentFundEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
