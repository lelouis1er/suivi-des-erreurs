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
 * @author Louis Stark
 */
@Embeddable
public class TransfertPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    private int idadmin;
    @Basic(optional = false)
    @NotNull
    private long iderreur;

    public TransfertPK() {
    }

    public TransfertPK(int idadmin, long iderreur) {
        this.idadmin = idadmin;
        this.iderreur = iderreur;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    public long getIderreur() {
        return iderreur;
    }

    public void setIderreur(long iderreur) {
        this.iderreur = iderreur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idadmin;
        hash += (int) iderreur;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransfertPK)) {
            return false;
        }
        TransfertPK other = (TransfertPK) object;
        if (this.idadmin != other.idadmin) {
            return false;
        }
        if (this.iderreur != other.iderreur) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TransfertPK[ idadmin=" + idadmin + ", iderreur=" + iderreur + " ]";
    }
    
}
