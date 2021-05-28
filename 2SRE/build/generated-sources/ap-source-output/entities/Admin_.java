package entities;

import entities.Entreprise;
import entities.Erreur;
import entities.Gerer;
import entities.Membre;
import entities.Transfert;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-26T14:08:29")
@StaticMetamodel(Admin.class)
public class Admin_ { 

    public static volatile ListAttribute<Admin, Transfert> transfertList1;
    public static volatile ListAttribute<Admin, Gerer> gererList;
    public static volatile SingularAttribute<Admin, String> mdp;
    public static volatile ListAttribute<Admin, Entreprise> entrepriseList;
    public static volatile SingularAttribute<Admin, String> tel;
    public static volatile ListAttribute<Admin, Erreur> erreurList;
    public static volatile SingularAttribute<Admin, Integer> idadmin;
    public static volatile SingularAttribute<Admin, String> login;
    public static volatile ListAttribute<Admin, Transfert> transfertList;
    public static volatile SingularAttribute<Admin, String> nom;
    public static volatile ListAttribute<Admin, Membre> membreList;
    public static volatile SingularAttribute<Admin, String> email;

}