package entities;

import entities.Entreprise;
import entities.Erreur;
import entities.Gerer;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-26T14:08:29")
@StaticMetamodel(Application.class)
public class Application_ { 

    public static volatile ListAttribute<Application, Gerer> gererList;
    public static volatile SingularAttribute<Application, String> description;
    public static volatile ListAttribute<Application, Entreprise> entrepriseList;
    public static volatile ListAttribute<Application, Erreur> erreurList;
    public static volatile SingularAttribute<Application, Integer> idappli;
    public static volatile SingularAttribute<Application, String> nom;

}