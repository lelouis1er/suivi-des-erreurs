package entities;

import entities.Erreur;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-09T16:16:50")
@StaticMetamodel(Piece.class)
public class Piece_ { 

    public static volatile SingularAttribute<Piece, String> emplacement;
    public static volatile SingularAttribute<Piece, BigInteger> idmembre;
    public static volatile SingularAttribute<Piece, Erreur> iderreur;
    public static volatile SingularAttribute<Piece, String> type;
    public static volatile SingularAttribute<Piece, Integer> idpiece;
    public static volatile SingularAttribute<Piece, String> nom;
    public static volatile SingularAttribute<Piece, BigInteger> comIderreur;

}