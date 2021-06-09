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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Employe.findAll", query = "SELECT e FROM Employe e"),
    @NamedQuery(name = "Employe.findByIdemp", query = "SELECT e FROM Employe e WHERE e.idemp = :idemp"),
    @NamedQuery(name = "Employe.findByNom", query = "SELECT e FROM Employe e WHERE e.nom = :nom"),
    @NamedQuery(name = "Employe.findByPrenom", query = "SELECT e FROM Employe e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Employe.findByLogin", query = "SELECT e FROM Employe e WHERE e.login = :login"),
    @NamedQuery(name = "Employe.findByMdp", query = "SELECT e FROM Employe e WHERE e.mdp = :mdp")})
public class Employe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idemp;
    @Size(max = 254)
    private String nom;
    @Size(max = 254)
    private String prenom;
    @Size(max = 254)
    private String login;
    @Size(max = 254)
    private String mdp;
    @OneToMany(mappedBy = "idemp", fetch = FetchType.LAZY)
    private List<Membre> membreList;
    @JoinColumn(name = "idens", referencedColumnName = "idens")
    @ManyToOne(fetch = FetchType.LAZY)
    private Entreprise idens;
    @JoinColumn(name = "idposte", referencedColumnName = "idposte")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Poste idposte;
    @OneToMany(mappedBy = "idemp", fetch = FetchType.LAZY)
    private List<Erreur> erreurList;

    public Employe() {
    }

    public Employe(Integer idemp) {
        this.idemp = idemp;
    }

    public Integer getIdemp() {
        return idemp;
    }

    public void setIdemp(Integer idemp) {
        this.idemp = idemp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @XmlTransient
    public List<Membre> getMembreList() {
        return membreList;
    }

    public void setMembreList(List<Membre> membreList) {
        this.membreList = membreList;
    }

    public Entreprise getIdens() {
        return idens;
    }

    public void setIdens(Entreprise idens) {
        this.idens = idens;
    }

    public Poste getIdposte() {
        return idposte;
    }

    public void setIdposte(Poste idposte) {
        this.idposte = idposte;
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
        hash += (idemp != null ? idemp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employe)) {
            return false;
        }
        Employe other = (Employe) object;
        if ((this.idemp == null && other.idemp != null) || (this.idemp != null && !this.idemp.equals(other.idemp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Employe[ idemp=" + idemp + " ]";
    }
    
}
