/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author PACO PC
 */
@Embeddable
public class GererPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    private int idadmin;
    @Basic(optional = false)
    @NotNull
    private int idappli;

    public GererPK() {
    }

    public GererPK(int idadmin, int idappli) {
        this.idadmin = idadmin;
        this.idappli = idappli;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    public int getIdappli() {
        return idappli;
    }

    public void setIdappli(int idappli) {
        this.idappli = idappli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idadmin;
        hash += (int) idappli;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GererPK)) {
            return false;
        }
        GererPK other = (GererPK) object;
        if (this.idadmin != other.idadmin) {
            return false;
        }
        if (this.idappli != other.idappli) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.GererPK[ idadmin=" + idadmin + ", idappli=" + idappli + " ]";
    }
    
}
