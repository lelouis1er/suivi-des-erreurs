/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Erreur.findAll", query = "SELECT e FROM Erreur e"),
    @NamedQuery(name = "Erreur.findByIderreur", query = "SELECT e FROM Erreur e WHERE e.iderreur = :iderreur"),
    @NamedQuery(name = "Erreur.findByTitre", query = "SELECT e FROM Erreur e WHERE e.titre = :titre"),
    @NamedQuery(name = "Erreur.findByDescription", query = "SELECT e FROM Erreur e WHERE e.description = :description"),
    @NamedQuery(name = "Erreur.findByDatedeclarer", query = "SELECT e FROM Erreur e WHERE e.datedeclarer = :datedeclarer"),
    @NamedQuery(name = "Erreur.findByResolu", query = "SELECT e FROM Erreur e WHERE e.resolu = :resolu"),
    @NamedQuery(name = "Erreur.findByDateresolu", query = "SELECT e FROM Erreur e WHERE e.dateresolu = :dateresolu"),
    @NamedQuery(name = "Erreur.findByLu", query = "SELECT e FROM Erreur e WHERE e.lu = :lu"),
    @NamedQuery(name = "Erreur.findByDatelu", query = "SELECT e FROM Erreur e WHERE e.datelu = :datelu")})
public class Erreur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Long iderreur;
    @Size(max = 254)
    private String titre;
    @Size(max = 2147483647)
    private String description;
    @Temporal(TemporalType.DATE)
    private Date datedeclarer;
    private Boolean resolu;
    @Temporal(TemporalType.DATE)
    private Date dateresolu;
    private Boolean lu;
    @Temporal(TemporalType.DATE)
    private Date datelu;
    @JoinColumn(name = "idadmin", referencedColumnName = "idadmin")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Admin idadmin;
    @JoinColumn(name = "idappli", referencedColumnName = "idappli")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Application idappli;
    @JoinColumn(name = "idemp", referencedColumnName = "idemp")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employe idemp;
    @JoinColumn(name = "idgravite", referencedColumnName = "idgravite")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Gravite idgravite;
    @JoinColumn(name = "idstatut", referencedColumnName = "idstatut")
    @ManyToOne(fetch = FetchType.LAZY)
    private Statut idstatut;
    @JoinColumn(name = "idtype", referencedColumnName = "idtype")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Typeerreur idtype;
    @OneToMany(mappedBy = "iderreur", fetch = FetchType.LAZY)
    private List<Piece> pieceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "erreur", fetch = FetchType.LAZY)
    private List<Transfert> transfertList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iderreur", fetch = FetchType.LAZY)
    private List<Commentaire> commentaireList;

    public Erreur() {
    }

    public Erreur(Long iderreur) {
        this.iderreur = iderreur;
    }

    public Long getIderreur() {
        return iderreur;
    }

    public void setIderreur(Long iderreur) {
        this.iderreur = iderreur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatedeclarer() {
        return datedeclarer;
    }

    public void setDatedeclarer(Date datedeclarer) {
        this.datedeclarer = datedeclarer;
    }

    public Boolean getResolu() {
        return resolu;
    }

    public void setResolu(Boolean resolu) {
        this.resolu = resolu;
    }

    public Date getDateresolu() {
        return dateresolu;
    }

    public void setDateresolu(Date dateresolu) {
        this.dateresolu = dateresolu;
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

    public Admin getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(Admin idadmin) {
        this.idadmin = idadmin;
    }

    public Application getIdappli() {
        return idappli;
    }

    public void setIdappli(Application idappli) {
        this.idappli = idappli;
    }

    public Employe getIdemp() {
        return idemp;
    }

    public void setIdemp(Employe idemp) {
        this.idemp = idemp;
    }

    public Gravite getIdgravite() {
        return idgravite;
    }

    public void setIdgravite(Gravite idgravite) {
        this.idgravite = idgravite;
    }

    public Statut getIdstatut() {
        return idstatut;
    }

    public void setIdstatut(Statut idstatut) {
        this.idstatut = idstatut;
    }

    public Typeerreur getIdtype() {
        return idtype;
    }

    public void setIdtype(Typeerreur idtype) {
        this.idtype = idtype;
    }

    @XmlTransient
    public List<Piece> getPieceList() {
        return pieceList;
    }

    public void setPieceList(List<Piece> pieceList) {
        this.pieceList = pieceList;
    }

    @XmlTransient
    public List<Transfert> getTransfertList() {
        return transfertList;
    }

    public void setTransfertList(List<Transfert> transfertList) {
        this.transfertList = transfertList;
    }

    @XmlTransient
    public List<Commentaire> getCommentaireList() {
        return commentaireList;
    }

    public void setCommentaireList(List<Commentaire> commentaireList) {
        this.commentaireList = commentaireList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iderreur != null ? iderreur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Erreur)) {
            return false;
        }
        Erreur other = (Erreur) object;
        if ((this.iderreur == null && other.iderreur != null) || (this.iderreur != null && !this.iderreur.equals(other.iderreur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Erreur[ iderreur=" + iderreur + " ]";
    }
    
}
