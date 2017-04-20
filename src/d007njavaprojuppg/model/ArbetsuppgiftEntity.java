/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d007njavaprojuppg.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author P
 */
@Entity
@Table(name = "ARBETSUPPGIFT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArbetsuppgiftEntity.findAll", query = "SELECT a FROM ArbetsuppgiftEntity a"),
    @NamedQuery(name = "ArbetsuppgiftEntity.findByReferensnummer", query = "SELECT a FROM ArbetsuppgiftEntity a WHERE a.referensnummer = :referensnummer"),
    @NamedQuery(name = "ArbetsuppgiftEntity.findByArbetsuppgiftnr", query = "SELECT a FROM ArbetsuppgiftEntity a WHERE a.arbetsuppgiftnr = :arbetsuppgiftnr"),
    @NamedQuery(name = "ArbetsuppgiftEntity.findByAnsvarig", query = "SELECT a FROM ArbetsuppgiftEntity a WHERE a.ansvarig = :ansvarig"),
    @NamedQuery(name = "ArbetsuppgiftEntity.findByArbetsuppgift", query = "SELECT a FROM ArbetsuppgiftEntity a WHERE a.arbetsuppgift = :arbetsuppgift"),
    @NamedQuery(name = "ArbetsuppgiftEntity.findByKostnadpertimma", query = "SELECT a FROM ArbetsuppgiftEntity a WHERE a.kostnadpertimma = :kostnadpertimma"),
    @NamedQuery(name = "ArbetsuppgiftEntity.findByBudgetteradtimmar", query = "SELECT a FROM ArbetsuppgiftEntity a WHERE a.budgetteradtimmar = :budgetteradtimmar"),
    @NamedQuery(name = "ArbetsuppgiftEntity.findByAntaltimmar", query = "SELECT a FROM ArbetsuppgiftEntity a WHERE a.antaltimmar = :antaltimmar")})
public class ArbetsuppgiftEntity implements Serializable {
    @Column(name = "ARBETSSTATUS")
    private String arbetsstatus;
    private static final long serialVersionUID = 1L;
    @Column(name = "REFERENSNUMMER")
    private Integer referensnummer;
    @Id
    @Basic(optional = false)
    @Column(name = "ARBETSUPPGIFTNR")
    private Integer arbetsuppgiftnr;
    @Column(name = "ANSVARIG")
    private String ansvarig;
    @Column(name = "ARBETSUPPGIFT")
    private String arbetsuppgift;
    @Column(name = "KOSTNADPERTIMMA")
    private Integer kostnadpertimma;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BUDGETTERADTIMMAR")
    private Double budgetteradtimmar;
    @Column(name = "ANTALTIMMAR")
    private Integer antaltimmar;

    public ArbetsuppgiftEntity() {
    }

    public ArbetsuppgiftEntity(Integer arbetsuppgiftnr) {
        this.arbetsuppgiftnr = arbetsuppgiftnr;
    }

    public Integer getReferensnummer() {
        return referensnummer;
    }

    public void setReferensnummer(Integer referensnummer) {
        this.referensnummer = referensnummer;
    }

    public Integer getArbetsuppgiftnr() {
        return arbetsuppgiftnr;
    }

    public void setArbetsuppgiftnr(Integer arbetsuppgiftnr) {
        this.arbetsuppgiftnr = arbetsuppgiftnr;
    }

    public String getAnsvarig() {
        return ansvarig;
    }

    public void setAnsvarig(String ansvarig) {
        this.ansvarig = ansvarig;
    }

    public String getArbetsuppgift() {
        return arbetsuppgift;
    }

    public void setArbetsuppgift(String arbetsuppgift) {
        this.arbetsuppgift = arbetsuppgift;
    }

    public Integer getKostnadpertimma() {
        return kostnadpertimma;
    }

    public void setKostnadpertimma(Integer kostnadpertimma) {
        this.kostnadpertimma = kostnadpertimma;
    }

    public Double getBudgetteradtimmar() {
        return budgetteradtimmar;
    }

    public void setBudgetteradtimmar(Double budgetteradtimmar) {
        this.budgetteradtimmar = budgetteradtimmar;
    }

    public Integer getAntaltimmar() {
        return antaltimmar;
    }

    public void setAntaltimmar(Integer antaltimmar) {
        this.antaltimmar = antaltimmar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (arbetsuppgiftnr != null ? arbetsuppgiftnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArbetsuppgiftEntity)) {
            return false;
        }
        ArbetsuppgiftEntity other = (ArbetsuppgiftEntity) object;
        if ((this.arbetsuppgiftnr == null && other.arbetsuppgiftnr != null) || (this.arbetsuppgiftnr != null && !this.arbetsuppgiftnr.equals(other.arbetsuppgiftnr))) {
            return false;
        }
        return true;
    }

    
        @Override
    public String toString() {
        return (this.arbetsuppgiftnr + "      " + this.arbetsuppgift + "            " + this.kostnadpertimma + "          " + this.arbetsstatus + "        " + this.antaltimmar + "            " + this.ansvarig);
    }

    public String getArbetsstatus() {
        return arbetsstatus;
    }

    public void setArbetsstatus(String arbetsstatus) {
        this.arbetsstatus = arbetsstatus;
    }
}
