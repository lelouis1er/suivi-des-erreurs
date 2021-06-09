/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Admin;
import entities.Application;
import entities.Employe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface AdminFacadeLocal {

    void create(Admin admin);

    void edit(Admin admin);

    void remove(Admin admin);

    Admin find(Object id);
    
    Admin find_by_login_mdp(String login);

    List<Admin> findAll();

    List<Admin> findRange(int[] range);

    int count();
    
}
