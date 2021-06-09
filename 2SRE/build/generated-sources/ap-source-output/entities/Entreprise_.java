package entities;

import entities.Admin;
import entities.Application;
import entities.Employe;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-09T16:16:50")
@StaticMetamodel(Entreprise.class)
public class Entreprise_ { 

    public static volatile ListAttribute<Entreprise, Admin> adminList;
    public static volatile ListAttribute<Entreprise, Employe> employeList;
    public static volatile SingularAttribute<Entreprise, String> raison;
    public static volatile SingularAttribute<Entreprise, Integer> idens;
    public static volatile ListAttribute<Entreprise, Application> applicationList;

}