/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PACO PC
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gerer.findAll", query = "SELECT g FROM Gerer g"),
    @NamedQuery(name = "Gerer.findByIdadmin", query = "SELECT g FROM Gerer g WHERE g.gererPK.idadmin = :idadmin"),
    @NamedQuery(name = "Gerer.findByIdappli", query = "SELECT g FROM Gerer g WHERE g.gererPK.idappli = :idappli"),
    @NamedQuery(name = "Gerer.findByRole", query = "SELECT g FROM Gerer g WHERE g.role = :role")})
public class Gerer implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GererPK gererPK;
    @Size(max = 254)
    private String role;
    @JoinColumn(name = "idadmin", referencedColumnName = "idadmin", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Admin admin;
    @JoinColumn(name = "idappli", referencedColumnName = "idappli", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Application application;

    public Gerer() {
    }

    public Gerer(GererPK gererPK) {
        this.gererPK = gererPK;
    }

    public Gerer(int idadmin, int idappli) {
        this.gererPK = new GererPK(idadmin, idappli);
    }

    public GererPK getGererPK() {
        return gererPK;
    }

    public void setGererPK(GererPK gererPK) {
        this.gererPK = gererPK;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gererPK != null ? gererPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gerer)) {
            return false;
        }
        Gerer other = (Gerer) object;
        if ((this.gererPK == null && other.gererPK != null) || (this.gererPK != null && !this.gererPK.equals(other.gererPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Gerer[ gererPK=" + gererPK + " ]";
    }
    
}
