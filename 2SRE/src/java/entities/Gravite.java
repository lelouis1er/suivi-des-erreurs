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
 * @author Louis Stark
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gravite.findAll", query = "SELECT g FROM Gravite g"),
    @NamedQuery(name = "Gravite.findByIdgravite", query = "SELECT g FROM Gravite g WHERE g.idgravite = :idgravite"),
    @NamedQuery(name = "Gravite.findByLibele", query = "SELECT g FROM Gravite g WHERE g.libele = :libele"),
    @NamedQuery(name = "Gravite.findByDescgravite", query = "SELECT g FROM Gravite g WHERE g.descgravite = :descgravite"),
    @NamedQuery(name = "Gravite.findByBackground", query = "SELECT g FROM Gravite g WHERE g.background = :background")})
public class Gravite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idgravite;
    @Size(max = 254)
    private String libele;
    @Size(max = 254)
    private String descgravite;
    @Size(max = 200)
    private String background;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgravite", fetch = FetchType.LAZY)
    private List<Erreur> erreurList;

    public Gravite() {
    }

    public Gravite(Integer idgravite) {
        this.idgravite = idgravite;
    }

    public Integer getIdgravite() {
        return idgravite;
    }

    public void setIdgravite(Integer idgravite) {
        this.idgravite = idgravite;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public String getDescgravite() {
        return descgravite;
    }

    public void setDescgravite(String descgravite) {
        this.descgravite = descgravite;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
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
        hash += (idgravite != null ? idgravite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gravite)) {
            return false;
        }
        Gravite other = (Gravite) object;
        if ((this.idgravite == null && other.idgravite != null) || (this.idgravite != null && !this.idgravite.equals(other.idgravite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Gravite[ idgravite=" + idgravite + " ]";
    }
    
}
