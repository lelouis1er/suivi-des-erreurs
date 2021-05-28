/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Admin;
import entities.Gerer;
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
public class GererFacade extends AbstractFacade<Gerer> implements GererFacadeLocal {
    @PersistenceContext(unitName = "StagePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GererFacade() {
        super(Gerer.class);
    }

    @Override
    public List<Gerer> findAll_by_admin(Admin a) {
       Query q = em.createQuery("SELECT g FROM Gerer g WHERE g.gererPK.idadmin = :idadmin");
        q.setParameter("idadmin", a.getIdadmin());
        try {
            return q.getResultList();
        } catch (Exception ex) {
        }
        return new ArrayList<>();
    }
    
}
