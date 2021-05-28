/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Employe;
import entities.Membre;
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
public class MembreFacade extends AbstractFacade<Membre> implements MembreFacadeLocal {
    @PersistenceContext(unitName = "StagePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MembreFacade() {
        super(Membre.class);
    }

    @Override
    public long nextId() {
        Query q = em.createQuery("SELECT MAX(m.idmembre) FROM Membre m ");
        List l = q.getResultList();
        if (l != null && l.get(0) != null) {
            return (Long) l.get(0) + 1;
        }
        return 1 + 1;
    }

    @Override
    public Membre find_by_employe(Employe e) {
        Query q = em.createQuery("SELECT m FROM Membre m WHERE m.idemp.idemp = :idemp");
        q.setParameter("idemp", e.getIdemp());
        try {
            return (Membre) q.getResultList().get(0);
        } catch (Exception ex) {
        }
        return null;
    }
    
}
