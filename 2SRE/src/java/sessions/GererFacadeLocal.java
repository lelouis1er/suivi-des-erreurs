/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Admin;
import entities.Gerer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface GererFacadeLocal {

    void create(Gerer gerer);

    void edit(Gerer gerer);

    void remove(Gerer gerer);

    Gerer find(Object id);

    List<Gerer> findAll();
    
    List<Gerer> findAll_by_admin(Admin a);

    List<Gerer> findRange(int[] range);

    int count();
    
}
