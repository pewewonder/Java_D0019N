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
@Table(name = "ARENDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArendeEntity.findAll", query = "SELECT a FROM ArendeEntity a"),
    @NamedQuery(name = "ArendeEntity.findByReferensnummer", query = "SELECT a FROM ArendeEntity a WHERE a.referensnummer = :referensnummer"),
    @NamedQuery(name = "ArendeEntity.findBySkapaddatum", query = "SELECT a FROM ArendeEntity a WHERE a.skapaddatum = :skapaddatum"),
    @NamedQuery(name = "ArendeEntity.findByKlardatum", query = "SELECT a FROM ArendeEntity a WHERE a.klardatum = :klardatum"),
    @NamedQuery(name = "ArendeEntity.findByArendetyp", query = "SELECT a FROM ArendeEntity a WHERE a.arendetyp = :arendetyp"),
    @NamedQuery(name = "ArendeEntity.findByArbetsstatus", query = "SELECT a FROM ArendeEntity a WHERE a.arbetsstatus = :arbetsstatus"),
    @NamedQuery(name = "ArendeEntity.findByKommentar", query = "SELECT a FROM ArendeEntity a WHERE a.kommentar = :kommentar"),
    @NamedQuery(name = "ArendeEntity.findByBudgettimmar", query = "SELECT a FROM ArendeEntity a WHERE a.budgettimmar = :budgettimmar")})
public class ArendeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "REFERENSNUMMER")
    private Integer referensnummer;
    @Column(name = "SKAPADDATUM")
    private String skapaddatum;
    @Column(name = "KLARDATUM")
    private String klardatum;
    @Column(name = "ARENDETYP")
    private String arendetyp;
    @Column(name = "ARBETSSTATUS")
    private String arbetsstatus;
    @Column(name = "KOMMENTAR")
    private String kommentar;
    @Column(name = "BUDGETTIMMAR")
    private Integer budgettimmar;

    public ArendeEntity() {
    }

    public ArendeEntity(Integer referensnummer) {
        this.referensnummer = referensnummer;
    }

    public Integer getReferensnummer() {
        return referensnummer;
    }

    public void setReferensnummer(Integer referensnummer) {
        this.referensnummer = referensnummer;
    }

    public String getSkapaddatum() {
        return skapaddatum;
    }

    public void setSkapaddatum(String skapaddatum) {
        this.skapaddatum = skapaddatum;
    }

    public String getKlardatum() {
        return klardatum;
    }

    public void setKlardatum(String klardatum) {
        this.klardatum = klardatum;
    }

    public String getArendetyp() {
        return arendetyp;
    }

    public void setArendetyp(String arendetyp) {
        this.arendetyp = arendetyp;
    }

    public String getArbetsstatus() {
        return arbetsstatus;
    }

    public void setArbetsstatus(String arbetsstatus) {
        this.arbetsstatus = arbetsstatus;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public Integer getBudgettimmar() {
        return budgettimmar;
    }

    public void setBudgettimmar(Integer budgettimmar) {
        this.budgettimmar = budgettimmar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (referensnummer != null ? referensnummer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArendeEntity)) {
            return false;
        }
        ArendeEntity other = (ArendeEntity) object;
        if ((this.referensnummer == null && other.referensnummer != null) || (this.referensnummer != null && !this.referensnummer.equals(other.referensnummer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return (this.referensnummer + "                   " + this.klardatum + "   " + this.arbetsstatus + " " + this.kommentar);
    }
    
}
