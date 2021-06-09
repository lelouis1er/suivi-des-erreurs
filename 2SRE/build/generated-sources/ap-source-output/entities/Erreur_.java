package entities;

import entities.Admin;
import entities.Application;
import entities.Commentaire;
import entities.Employe;
import entities.Gravite;
import entities.Piece;
import entities.Statut;
import entities.Transfert;
import entities.Typeerreur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-09T16:16:50")
@StaticMetamodel(Erreur.class)
public class Erreur_ { 

    public static volatile SingularAttribute<Erreur, Gravite> idgravite;
    public static volatile ListAttribute<Erreur, Commentaire> commentaireList;
    public static volatile SingularAttribute<Erreur, String> titre;
    public static volatile SingularAttribute<Erreur, Date> datelu;
    public static volatile SingularAttribute<Erreur, Long> iderreur;
    public static volatile ListAttribute<Erreur, Piece> pieceList;
    public static volatile SingularAttribute<Erreur, String> description;
    public static volatile SingularAttribute<Erreur, Boolean> lu;
    public static volatile SingularAttribute<Erreur, Admin> idadmin;
    public static volatile ListAttribute<Erreur, Transfert> transfertList;
    public static volatile SingularAttribute<Erreur, Date> dateresolu;
    public static volatile SingularAttribute<Erreur, Typeerreur> idtype;
    public static volatile SingularAttribute<Erreur, Boolean> resolu;
    public static volatile SingularAttribute<Erreur, Statut> idstatut;
    public static volatile SingularAttribute<Erreur, Date> datedeclarer;
    public static volatile SingularAttribute<Erreur, Employe> idemp;
    public static volatile SingularAttribute<Erreur, Application> idappli;

}