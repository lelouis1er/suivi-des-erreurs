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
    @NamedQuery(name = "Statut.findAll", query = "SELECT s FROM Statut s"),
    @NamedQuery(name = "Statut.findByIdstatut", query = "SELECT s FROM Statut s WHERE s.idstatut = :idstatut"),
    @NamedQuery(name = "Statut.findByLibele", query = "SELECT s FROM Statut s WHERE s.libele = :libele"),
    @NamedQuery(name = "Statut.findByDescription", query = "SELECT s FROM Statut s WHERE s.description = :description"),
    @NamedQuery(name = "Statut.findByStyle", query = "SELECT s FROM Statut s WHERE s.style = :style")})
public class Statut implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idstatut;
    @Size(max = 254)
    private String libele;
    @Size(max = 2147483647)
    private String description;
    @Size(max = 254)
    private String style;
    @OneToMany(mappedBy = "idstatut", fetch = FetchType.LAZY)
    private List<Erreur> erreurList;

    public Statut() {
    }

    public Statut(Integer idstatut) {
        this.idstatut = idstatut;
    }

    public Integer getIdstatut() {
        return idstatut;
    }

    public void setIdstatut(Integer idstatut) {
        this.idstatut = idstatut;
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

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
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
        hash += (idstatut != null ? idstatut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statut)) {
            return false;
        }
        Statut other = (Statut) object;
        if ((this.idstatut == null && other.idstatut != null) || (this.idstatut != null && !this.idstatut.equals(other.idstatut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Statut[ idstatut=" + idstatut + " ]";
    }
    
}
