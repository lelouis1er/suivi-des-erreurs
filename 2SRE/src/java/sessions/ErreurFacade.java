/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Employe;
import entities.Erreur;
import java.util.ArrayList;
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
public class ErreurFacade extends AbstractFacade<Erreur> implements ErreurFacadeLocal {

    @PersistenceContext(unitName = "StagePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ErreurFacade() {
        super(Erreur.class);
    }

    @Override
    public List<Erreur> findAll_byEmploye(Employe e) {
        Query q = em.createQuery("SELECT e FROM Erreur e WHERE e.idemp.idemp = :idemp");
        q.setParameter("idemp", e.getIdemp());
        try {
            return q.getResultList();
        } catch (Exception ex) {
        }
        return new ArrayList<>();
    }

    @Override
    public long nextId() {
        Query q = em.createQuery("SELECT MAX(e.iderreur) FROM Erreur e ");
        List l = q.getResultList();
        if (l != null && l.get(0) != null) {
            return (Long) l.get(0) + 1;
        }
        return 1 + 1;
    }

}
