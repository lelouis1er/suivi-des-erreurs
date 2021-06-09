package entities;

import entities.Entreprise;
import entities.Erreur;
import entities.Membre;
import entities.Poste;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-09T16:16:50")
@StaticMetamodel(Employe.class)
public class Employe_ { 

    public static volatile SingularAttribute<Employe, String> mdp;
    public static volatile SingularAttribute<Employe, Entreprise> idens;
    public static volatile SingularAttribute<Employe, Integer> idemp;
    public static volatile SingularAttribute<Employe, Poste> idposte;
    public static volatile ListAttribute<Employe, Erreur> erreurList;
    public static volatile SingularAttribute<Employe, String> login;
    public static volatile SingularAttribute<Employe, String> nom;
    public static volatile SingularAttribute<Employe, String> prenom;
    public static volatile ListAttribute<Employe, Membre> membreList;

}