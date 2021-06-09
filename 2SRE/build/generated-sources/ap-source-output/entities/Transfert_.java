package entities;

import entities.Admin;
import entities.Erreur;
import entities.TransfertPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-09T16:16:50")
@StaticMetamodel(Transfert.class)
public class Transfert_ { 

    public static volatile SingularAttribute<Transfert, TransfertPK> transfertPK;
    public static volatile SingularAttribute<Transfert, Admin> receveur;
    public static volatile SingularAttribute<Transfert, Erreur> erreur;
    public static volatile SingularAttribute<Transfert, Admin> admin;
    public static volatile SingularAttribute<Transfert, String> motif;
    public static volatile SingularAttribute<Transfert, Date> datetransfert;

}