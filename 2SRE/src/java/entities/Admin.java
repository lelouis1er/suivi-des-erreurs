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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
    @NamedQuery(name = "Admin.findByIdadmin", query = "SELECT a FROM Admin a WHERE a.idadmin = :idadmin"),
    @NamedQuery(name = "Admin.findByLogin", query = "SELECT a FROM Admin a WHERE a.login = :login"),
    @NamedQuery(name = "Admin.findByMdp", query = "SELECT a FROM Admin a WHERE a.mdp = :mdp"),
    @NamedQuery(name = "Admin.findByNom", query = "SELECT a FROM Admin a WHERE a.nom = :nom"),
    @NamedQuery(name = "Admin.findByTel", query = "SELECT a FROM Admin a WHERE a.tel = :tel"),
    @NamedQuery(name = "Admin.findByEmail", query = "SELECT a FROM Admin a WHERE a.email = :email")})
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idadmin;
    @Size(max = 254)
    private String login;
    @Size(max = 254)
    private String mdp;
    @Size(max = 254)
    private String nom;
    @Size(max = 254)
    private String tel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 254)
    private String email;
    @JoinTable(name = "affecter", joinColumns = {
        @JoinColumn(name = "idadmin", referencedColumnName = "idadmin")}, inverseJoinColumns = {
        @JoinColumn(name = "idens", referencedColumnName = "idens")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Entreprise> entrepriseList;
    @OneToMany(mappedBy = "idadmin", fetch = FetchType.LAZY)
    private List<Membre> membreList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idadmin", fetch = FetchType.LAZY)
    private List<Erreur> erreurList;
    @OneToMany(mappedBy = "receveur", fetch = FetchType.LAZY)
    private List<Transfert> transfertList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admin", fetch = FetchType.LAZY)
    private List<Transfert> transfertList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admin", fetch = FetchType.LAZY)
    private List<Gerer> gererList;

    public Admin() {
    }

    public Admin(Integer idadmin) {
        this.idadmin = idadmin;
    }

    public Integer getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(Integer idadmin) {
        this.idadmin = idadmin;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Entreprise> getEntrepriseList() {
        return entrepriseList;
    }

    public void setEntrepriseList(List<Entreprise> entrepriseList) {
        this.entrepriseList = entrepriseList;
    }

    @XmlTransient
    public List<Membre> getMembreList() {
        return membreList;
    }

    public void setMembreList(List<Membre> membreList) {
        this.membreList = membreList;
    }

    @XmlTransient
    public List<Erreur> getErreurList() {
        return erreurList;
    }

    public void setErreurList(List<Erreur> erreurList) {
        this.erreurList = erreurList;
    }

    @XmlTransient
    public List<Transfert> getTransfertList() {
        return transfertList;
    }

    public void setTransfertList(List<Transfert> transfertList) {
        this.transfertList = transfertList;
    }

    @XmlTransient
    public List<Transfert> getTransfertList1() {
        return transfertList1;
    }

    public void setTransfertList1(List<Transfert> transfertList1) {
        this.transfertList1 = transfertList1;
    }

    @XmlTransient
    public List<Gerer> getGererList() {
        return gererList;
    }

    public void setGererList(List<Gerer> gererList) {
        this.gererList = gererList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadmin != null ? idadmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.idadmin == null && other.idadmin != null) || (this.idadmin != null && !this.idadmin.equals(other.idadmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Admin[ idadmin=" + idadmin + " ]";
    }
    
}
