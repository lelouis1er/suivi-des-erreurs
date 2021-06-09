/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PACO PC
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commentaire.findAll", query = "SELECT c FROM Commentaire c"),
    @NamedQuery(name = "Commentaire.findByContenu", query = "SELECT c FROM Commentaire c WHERE c.contenu = :contenu"),
    @NamedQuery(name = "Commentaire.findByHeurearr", query = "SELECT c FROM Commentaire c WHERE c.heurearr = :heurearr"),
    @NamedQuery(name = "Commentaire.findByLu", query = "SELECT c FROM Commentaire c WHERE c.lu = :lu"),
    @NamedQuery(name = "Commentaire.findByDatelu", query = "SELECT c FROM Commentaire c WHERE c.datelu = :datelu"),
    @NamedQuery(name = "Commentaire.findByIdCom", query = "SELECT c FROM Commentaire c WHERE c.idCom = :idCom")})
public class Commentaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 2147483647)
    private String contenu;
    @Temporal(TemporalType.DATE)
    private Date heurearr;
    private Boolean lu;
    @Temporal(TemporalType.DATE)
    private Date datelu;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_com")
    private Long idCom;
    @JoinColumn(name = "iderreur", referencedColumnName = "iderreur")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Erreur iderreur;
    @JoinColumn(name = "idmembre", referencedColumnName = "idmembre")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Membre idmembre;

    public Commentaire() {
    }

    public Commentaire(Long idCom) {
        this.idCom = idCom;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getHeurearr() {
        return heurearr;
    }

    public void setHeurearr(Date heurearr) {
        this.heurearr = heurearr;
    }

    public Boolean getLu() {
        return lu;
    }

    public void setLu(Boolean lu) {
        this.lu = lu;
    }

    public Date getDatelu() {
        return datelu;
    }

    public void setDatelu(Date datelu) {
        this.datelu = datelu;
    }

    public Long getIdCom() {
        return idCom;
    }

    public void setIdCom(Long idCom) {
        this.idCom = idCom;
    }

    public Erreur getIderreur() {
        return iderreur;
    }

    public void setIderreur(Erreur iderreur) {
        this.iderreur = iderreur;
    }

    public Membre getIdmembre() {
        return idmembre;
    }

    public void setIdmembre(Membre idmembre) {
        this.idmembre = idmembre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCom != null ? idCom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commentaire)) {
            return false;
        }
        Commentaire other = (Commentaire) object;
        if ((this.idCom == null && other.idCom != null) || (this.idCom != null && !this.idCom.equals(other.idCom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Commentaire[ idCom=" + idCom + " ]";
    }
    
}
