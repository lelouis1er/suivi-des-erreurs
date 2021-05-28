package entities;

import entities.Admin;
import entities.Employe;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-26T14:08:29")
@StaticMetamodel(Membre.class)
public class Membre_ { 

    public static volatile SingularAttribute<Membre, Long> idmembre;
    public static volatile SingularAttribute<Membre, Employe> idemp;
    public static volatile SingularAttribute<Membre, String> type;
    public static volatile SingularAttribute<Membre, Admin> idadmin;
    public static volatile SingularAttribute<Membre, String> nom;
    public static volatile SingularAttribute<Membre, String> prenom;

}