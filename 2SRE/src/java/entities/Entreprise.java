/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Louis Stark
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entreprise.findAll", query = "SELECT e FROM Entreprise e"),
    @NamedQuery(name = "Entreprise.findByIdens", query = "SELECT e FROM Entreprise e WHERE e.idens = :idens"),
    @NamedQuery(name = "Entreprise.findByRaison", query = "SELECT e FROM Entreprise e WHERE e.raison = :raison")})
public class Entreprise implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idens;
    @Size(max = 254)
    private String raison;
    @ManyToMany(mappedBy = "entrepriseList", fetch = FetchType.LAZY)
    private List<Application> applicationList;
    @ManyToMany(mappedBy = "entrepriseList", fetch = FetchType.LAZY)
    private List<Admin> adminList;
    @OneToMany(mappedBy = "idens", fetch = FetchType.LAZY)
    private List<Employe> employeList;

    public Entreprise() {
    }

    public Entreprise(Integer idens) {
        this.idens = idens;
    }

    public Integer getIdens() {
        return idens;
    }

    public void setIdens(Integer idens) {
        this.idens = idens;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    @XmlTransient
    public List<Application> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(List<Application> applicationList) {
        this.applicationList = applicationList;
    }

    @XmlTransient
    public List<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
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
        hash += (idens != null ? idens.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entreprise)) {
            return false;
        }
        Entreprise other = (Entreprise) object;
        if ((this.idens == null && other.idens != null) || (this.idens != null && !this.idens.equals(other.idens))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Entreprise[ idens=" + idens + " ]";
    }
    
}
