/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PACO PC
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transfert.findAll", query = "SELECT t FROM Transfert t"),
    @NamedQuery(name = "Transfert.findByIdadmin", query = "SELECT t FROM Transfert t WHERE t.transfertPK.idadmin = :idadmin"),
    @NamedQuery(name = "Transfert.findByIderreur", query = "SELECT t FROM Transfert t WHERE t.transfertPK.iderreur = :iderreur"),
    @NamedQuery(name = "Transfert.findByDatetransfert", query = "SELECT t FROM Transfert t WHERE t.datetransfert = :datetransfert"),
    @NamedQuery(name = "Transfert.findByMotif", query = "SELECT t FROM Transfert t WHERE t.motif = :motif")})
public class Transfert implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransfertPK transfertPK;
    @Temporal(TemporalType.DATE)
    private Date datetransfert;
    @Size(max = 254)
    private String motif;
    @JoinColumn(name = "receveur", referencedColumnName = "idadmin")
    @ManyToOne(fetch = FetchType.LAZY)
    private Admin receveur;
    @JoinColumn(name = "idadmin", referencedColumnName = "idadmin", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Admin admin;
    @JoinColumn(name = "iderreur", referencedColumnName = "iderreur", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Erreur erreur;

    public Transfert() {
    }

    public Transfert(TransfertPK transfertPK) {
        this.transfertPK = transfertPK;
    }

    public Transfert(int idadmin, long iderreur) {
        this.transfertPK = new TransfertPK(idadmin, iderreur);
    }

    public TransfertPK getTransfertPK() {
        return transfertPK;
    }

    public void setTransfertPK(TransfertPK transfertPK) {
        this.transfertPK = transfertPK;
    }

    public Date getDatetransfert() {
        return datetransfert;
    }

    public void setDatetransfert(Date datetransfert) {
        this.datetransfert = datetransfert;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Admin getReceveur() {
        return receveur;
    }

    public void setReceveur(Admin receveur) {
        this.receveur = receveur;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Erreur getErreur() {
        return erreur;
    }

    public void setErreur(Erreur erreur) {
        this.erreur = erreur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transfertPK != null ? transfertPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transfert)) {
            return false;
        }
        Transfert other = (Transfert) object;
        if ((this.transfertPK == null && other.transfertPK != null) || (this.transfertPK != null && !this.transfertPK.equals(other.transfertPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Transfert[ transfertPK=" + transfertPK + " ]";
    }
    
}
