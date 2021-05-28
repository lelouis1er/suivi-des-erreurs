/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MKVL
 */
@Entity
@Table(name = "piece")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Piece.findAll", query = "SELECT p FROM Piece p"),
    @NamedQuery(name = "Piece.findByIdpiece", query = "SELECT p FROM Piece p WHERE p.idpiece = :idpiece"),
    @NamedQuery(name = "Piece.findByComIderreur", query = "SELECT p FROM Piece p WHERE p.comIderreur = :comIderreur"),
    @NamedQuery(name = "Piece.findByIdmembre", query = "SELECT p FROM Piece p WHERE p.idmembre = :idmembre"),
    @NamedQuery(name = "Piece.findByNom", query = "SELECT p FROM Piece p WHERE p.nom = :nom"),
    @NamedQuery(name = "Piece.findByType", query = "SELECT p FROM Piece p WHERE p.type = :type"),
    @NamedQuery(name = "Piece.findByEmplacement", query = "SELECT p FROM Piece p WHERE p.emplacement = :emplacement")})
public class Piece implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpiece")
    private Integer idpiece;
    @Column(name = "com_iderreur")
    private BigInteger comIderreur;
    @Column(name = "idmembre")
    private BigInteger idmembre;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Size(max = 254)
    @Column(name = "type")
    private String type;
    @Size(max = 254)
    @Column(name = "emplacement")
    private String emplacement;
    @JoinColumn(name = "iderreur", referencedColumnName = "iderreur")
    @ManyToOne(fetch = FetchType.LAZY)
    private Erreur iderreur;

    public Piece() {
    }

    public Piece(Integer idpiece) {
        this.idpiece = idpiece;
    }

    public Integer getIdpiece() {
        return idpiece;
    }

    public void setIdpiece(Integer idpiece) {
        this.idpiece = idpiece;
    }

    public BigInteger getComIderreur() {
        return comIderreur;
    }

    public void setComIderreur(BigInteger comIderreur) {
        this.comIderreur = comIderreur;
    }

    public BigInteger getIdmembre() {
        return idmembre;
    }

    public void setIdmembre(BigInteger idmembre) {
        this.idmembre = idmembre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public Erreur getIderreur() {
        return iderreur;
    }

    public void setIderreur(Erreur iderreur) {
        this.iderreur = iderreur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpiece != null ? idpiece.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Piece)) {
            return false;
        }
        Piece other = (Piece) object;
        if ((this.idpiece == null && other.idpiece != null) || (this.idpiece != null && !this.idpiece.equals(other.idpiece))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Piece[ idpiece=" + idpiece + " ]";
    }
    
}
