/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Employe;
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
public class EmployeFacade extends AbstractFacade<Employe> implements EmployeFacadeLocal {

    @PersistenceContext(unitName = "StagePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeFacade() {
        super(Employe.class);
    }

    @Override
    public Employe find_by_login_mdp(String login) {
        Query q = em.createQuery("SELECT e FROM Employe e WHERE e.login = :login ");
        q.setParameter("login", login);

        try {
            List list = q.getResultList();
            if (list != null) {
                return (Employe) list.get(0);
            }
        } catch (Exception e) {
        }

        return null;
    }

}
