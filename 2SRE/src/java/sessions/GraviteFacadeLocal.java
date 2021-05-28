/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Gravite;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface GraviteFacadeLocal {

    void create(Gravite gravite);

    void edit(Gravite gravite);

    void remove(Gravite gravite);

    Gravite find(Object id);

    List<Gravite> findAll();

    List<Gravite> findRange(int[] range);

    int count();
    
}
