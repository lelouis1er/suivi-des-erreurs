package entities;

import entities.Admin;
import entities.Application;
import entities.GererPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-09T16:16:50")
@StaticMetamodel(Gerer.class)
public class Gerer_ { 

    public static volatile SingularAttribute<Gerer, String> role;
    public static volatile SingularAttribute<Gerer, Application> application;
    public static volatile SingularAttribute<Gerer, Admin> admin;
    public static volatile SingularAttribute<Gerer, GererPK> gererPK;

}