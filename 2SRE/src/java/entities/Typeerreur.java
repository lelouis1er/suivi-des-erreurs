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
    @NamedQuery(name = "Typeerreur.findAll", query = "SELECT t FROM Typeerreur t"),
    @NamedQuery(name = "Typeerreur.findByIdtype", query = "SELECT t FROM Typeerreur t WHERE t.idtype = :idtype"),
    @NamedQuery(name = "Typeerreur.findByLibele", query = "SELECT t FROM Typeerreur t WHERE t.libele = :libele"),
    @NamedQuery(name = "Typeerreur.findByDescription", query = "SELECT t FROM Typeerreur t WHERE t.description = :description")})
public class Typeerreur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idtype;
    @Size(max = 254)
    private String libele;
    @Size(max = 254)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtype", fetch = FetchType.LAZY)
    private List<Erreur> erreurList;

    public Typeerreur() {
    }

    public Typeerreur(Integer idtype) {
        this.idtype = idtype;
    }

    public Integer getIdtype() {
        return idtype;
    }

    public void setIdtype(Integer idtype) {
        this.idtype = idtype;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Erreur> getErreurList() {
        return erreurList;
    }

    public void setErreurList(List<Erreur> erreurList) {
        this.erreurList = erreurList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtype != null ? idtype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typeerreur)) {
            return false;
        }
        Typeerreur other = (Typeerreur) object;
        if ((this.idtype == null && other.idtype != null) || (this.idtype != null && !this.idtype.equals(other.idtype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Typeerreur[ idtype=" + idtype + " ]";
    }
    
}
