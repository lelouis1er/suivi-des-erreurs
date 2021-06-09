/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Commentaire;
import entities.Erreur;
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
public class CommentaireFacade extends AbstractFacade<Commentaire> implements CommentaireFacadeLocal {
    @PersistenceContext(unitName = "StagePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    

    public CommentaireFacade() {
        super(Commentaire.class);
    }

    @Override
    public List<Commentaire> findAll_by_erreur(Erreur e) {
        Query q = em.createQuery("SELECT c FROM Commentaire c WHERE c.iderreur.iderreur = :id_e");
        q.setParameter("id_e", e.getIderreur());
        return q.getResultList();
    }
    
    @Override
    public long nextId() {
        Query q = em.createQuery("SELECT MAX(c.idCom) FROM Commentaire c ");
        List l = q.getResultList();
        if (l != null && l.get(0) != null) {
            return (Long) l.get(0) + 1;
        }
        return 1 + 1;
    }
    
}
