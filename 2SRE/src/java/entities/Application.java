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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
 * @author PACO PC
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Application.findAll", query = "SELECT a FROM Application a"),
    @NamedQuery(name = "Application.findByIdappli", query = "SELECT a FROM Application a WHERE a.idappli = :idappli"),
    @NamedQuery(name = "Application.findByNom", query = "SELECT a FROM Application a WHERE a.nom = :nom"),
    @NamedQuery(name = "Application.findByDescription", query = "SELECT a FROM Application a WHERE a.description = :description")})
public class Application implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idappli;
    @Size(max = 254)
    private String nom;
    @Size(max = 2147483647)
    private String description;
    @JoinTable(name = "pocede", joinColumns = {
        @JoinColumn(name = "idappli", referencedColumnName = "idappli")}, inverseJoinColumns = {
        @JoinColumn(name = "idens", referencedColumnName = "idens")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Entreprise> entrepriseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idappli", fetch = FetchType.LAZY)
    private List<Erreur> erreurList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "application", fetch = FetchType.LAZY)
    private List<Gerer> gererList;

    public Application() {
    }

    public Application(Integer idappli) {
        this.idappli = idappli;
    }

    public Integer getIdappli() {
        return idappli;
    }

    public void setIdappli(Integer idappli) {
        this.idappli = idappli;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Entreprise> getEntrepriseList() {
        return entrepriseList;
    }

    public void setEntrepriseList(List<Entreprise> entrepriseList) {
        this.entrepriseList = entrepriseList;
    }

    @XmlTransient
    public List<Erreur> getErreurList() {
        return erreurList;
    }

    public void setErreurList(List<Erreur> erreurList) {
        this.erreurList = erreurList;
    }

    @XmlTransient
    public List<Gerer> getGererList() {
        return gererList;
    }

    public void setGererList(List<Gerer> gererList) {
        this.gererList = gererList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idappli != null ? idappli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Application)) {
            return false;
        }
        Application other = (Application) object;
        if ((this.idappli == null && other.idappli != null) || (this.idappli != null && !this.idappli.equals(other.idappli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Application[ idappli=" + idappli + " ]";
    }
    
}
