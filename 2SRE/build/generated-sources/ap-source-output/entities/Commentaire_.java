package entities;

import entities.Erreur;
import entities.Membre;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-26T14:08:29")
@StaticMetamodel(Commentaire.class)
public class Commentaire_ { 

    public static volatile SingularAttribute<Commentaire, Long> idCom;
    public static volatile SingularAttribute<Commentaire, Date> datelu;
    public static volatile SingularAttribute<Commentaire, Membre> idmembre;
    public static volatile SingularAttribute<Commentaire, Erreur> iderreur;
    public static volatile SingularAttribute<Commentaire, Boolean> lu;
    public static volatile SingularAttribute<Commentaire, Date> heurearr;
    public static volatile SingularAttribute<Commentaire, String> contenu;

}