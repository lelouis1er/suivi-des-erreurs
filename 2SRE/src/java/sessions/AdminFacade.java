/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Admin;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Louis Stark
 */
@Stateless
public class AdminFacade extends AbstractFacade<Admin> implements AdminFacadeLocal {
    @PersistenceContext(unitName = "StagePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminFacade() {
        super(Admin.class);
    }
    
    @Override
    public Admin find_by_login_mdp(String login) {
        Query q = em.createQuery("SELECT a FROM Admin a WHERE a.login = :login");
        q.setParameter("login", login);

        try {
            List list = q.getResultList();
            if (list != null) {
                return (Admin) list.get(0);
            }
        } catch (Exception e) {
        }

        return null;
    }
    
}
