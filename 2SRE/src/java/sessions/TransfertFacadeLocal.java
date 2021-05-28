/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Transfert;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface TransfertFacadeLocal {

    void create(Transfert transfert);

    void edit(Transfert transfert);

    void remove(Transfert transfert);

    Transfert find(Object id);

    List<Transfert> findAll();

    List<Transfert> findRange(int[] range);

    int count();
    
}
