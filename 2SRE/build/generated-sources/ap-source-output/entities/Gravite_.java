package entities;

import entities.Erreur;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-26T14:08:29")
@StaticMetamodel(Gravite.class)
public class Gravite_ { 

    public static volatile SingularAttribute<Gravite, Integer> idgravite;
    public static volatile SingularAttribute<Gravite, String> descgravite;
    public static volatile SingularAttribute<Gravite, String> background;
    public static volatile SingularAttribute<Gravite, String> libele;
    public static volatile ListAttribute<Gravite, Erreur> erreurList;

}