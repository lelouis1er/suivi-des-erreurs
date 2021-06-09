/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Employe;
import entities.Erreur;
import entities.Membre;
import static java.util.Collections.list;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface MembreFacadeLocal {

    void create(Membre membre);

    void edit(Membre membre);

    void remove(Membre membre);

    Membre find(Object id);
    
    Membre find_by_employe(Employe e);
    
    List<Membre> find_by_commentaire(Erreur e);

    List<Membre> findAll();

    List<Membre> findRange(int[] range);
    
    long nextId();

    int count();
    
}
