/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Employe;
import entities.Erreur;
import entities.Statut;
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
        try {
            q.setParameter("idemp", e.getIdemp());
            return q.getResultList();
        } catch (Exception ex) {
        }
        return new ArrayList<>();
    }
    
    @Override
    public List<Erreur> findAll_byStatut(Statut s) {
        Query q = em.createQuery("SELECT e FROM Erreur e WHERE e.idstatut = :id_s");
        try {
            q.setParameter("id_s", s.getIdstatut() );
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

    @Override
    public List<Erreur> findAll_by_employe_statut(Employe e, Statut s) {
        Query q = em.createQuery("SELECT e FROM Erreur e WHERE e.idemp.idemp = :idemp AND e.idstatut.idstatut = :id_s");
        try {
            q.setParameter("idemp", e.getIdemp());
            q.setParameter("id_s", s.getIdstatut());
            return q.getResultList();
        } catch (Exception ex) {
        }
        return new ArrayList<>();
    }

}
