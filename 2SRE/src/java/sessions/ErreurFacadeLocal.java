/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Employe;
import entities.Erreur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface ErreurFacadeLocal {

    void create(Erreur erreur);

    void edit(Erreur erreur);

    void remove(Erreur erreur);

    Erreur find(Object id);

    List<Erreur> findAll();

    List<Erreur> findRange(int[] range);
    
    List<Erreur> findAll_byEmploye(Employe e);

    int count();
    
    long nextId();
    
}
