/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Admin;
import entities.Application;
import entities.Employe;
import entities.Entreprise;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Louis Stark
 */
@Local
public interface ApplicationFacadeLocal {

    void create(Application application);

    void edit(Application application);

    void remove(Application application);
    
    Application find(Object id);

    List<Application> findAll();

    List<Application> findRange(int[] range);
    
    List<Application> find_by_employe(Employe e);
    
    List<Application> find_by_entreprise(Entreprise e);
    
    List<Application> find_by_admin(Admin a);
    
   

    int count();
    
}
