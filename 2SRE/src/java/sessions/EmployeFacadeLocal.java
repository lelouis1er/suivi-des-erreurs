/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Employe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface EmployeFacadeLocal {

    void create(Employe employe);

    void edit(Employe employe);

    void remove(Employe employe);

    Employe find(Object id);
    
    Employe find_by_login_mdp(String login);

    List<Employe> findAll();

    List<Employe> findRange(int[] range);

    int count();
    
}
