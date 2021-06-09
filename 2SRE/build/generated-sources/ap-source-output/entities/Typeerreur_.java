package entities;

import entities.Erreur;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-09T16:16:50")
@StaticMetamodel(Typeerreur.class)
public class Typeerreur_ { 

    public static volatile SingularAttribute<Typeerreur, Integer> idtype;
    public static volatile SingularAttribute<Typeerreur, String> libele;
    public static volatile SingularAttribute<Typeerreur, String> description;
    public static volatile ListAttribute<Typeerreur, Erreur> erreurList;

}