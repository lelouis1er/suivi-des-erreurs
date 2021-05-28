/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Typeerreur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface TypeerreurFacadeLocal {

    void create(Typeerreur typeerreur);

    void edit(Typeerreur typeerreur);

    void remove(Typeerreur typeerreur);

    Typeerreur find(Object id);

    List<Typeerreur> findAll();

    List<Typeerreur> findRange(int[] range);

    int count();
    
}
