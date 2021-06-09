/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PACO PC
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poste.findAll", query = "SELECT p FROM Poste p"),
    @NamedQuery(name = "Poste.findByIdposte", query = "SELECT p FROM Poste p WHERE p.idposte = :idposte"),
    @NamedQuery(name = "Poste.findByDenomination", query = "SELECT p FROM Poste p WHERE p.denomination = :denomination")})
public class Poste implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idposte;
    @Size(max = 254)
    private String denomination;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idposte", fetch = FetchType.LAZY)
    private List<Employe> employeList;

    public Poste() {
    }

    public Poste(Integer idposte) {
        this.idposte = idposte;
    }

    public Integer getIdposte() {
        return idposte;
    }

    public void setIdposte(Integer idposte) {
        this.idposte = idposte;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    @XmlTransient
    public List<Employe> getEmployeList() {
        return employeList;
    }

    public void setEmployeList(List<Employe> employeList) {
        this.employeList = employeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idposte != null ? idposte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poste)) {
            return false;
        }
        Poste other = (Poste) object;
        if ((this.idposte == null && other.idposte != null) || (this.idposte != null && !this.idposte.equals(other.idposte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Poste[ idposte=" + idposte + " ]";
    }
    
}
