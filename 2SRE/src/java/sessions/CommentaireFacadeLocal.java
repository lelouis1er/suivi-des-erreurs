/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Commentaire;
import entities.Erreur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface CommentaireFacadeLocal {

    void create(Commentaire commentaire);

    void edit(Commentaire commentaire);

    void remove(Commentaire commentaire);

    Commentaire find(Object id);

    List<Commentaire> findAll();

    List<Commentaire> findRange(int[] range);
    
    List<Commentaire> findAll_by_erreur(Erreur e);

    int count();
    
    long nextId();
    
}
