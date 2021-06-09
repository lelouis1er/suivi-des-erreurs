package entities;

import entities.Erreur;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-09T16:16:50")
@StaticMetamodel(Statut.class)
public class Statut_ { 

    public static volatile SingularAttribute<Statut, Integer> idstatut;
    public static volatile SingularAttribute<Statut, String> libele;
    public static volatile SingularAttribute<Statut, String> description;
    public static volatile SingularAttribute<Statut, String> style;
    public static volatile ListAttribute<Statut, Erreur> erreurList;

}