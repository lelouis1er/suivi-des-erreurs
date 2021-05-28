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
public class ApplicationFacade extends AbstractFacade<Application> implements ApplicationFacadeLocal {

    @PersistenceContext(unitName = "StagePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApplicationFacade() {
        super(Application.class);
    }

    @Override
    public List<Application> find_by_employe(Employe e) {

        return e.getIdens().getApplicationList();

    }
    @Override
    public List<Application> find_by_entreprise(Entreprise e){

        return e.getApplicationList();

    }
    @Override
    public List<Application> find_by_admin(Admin a){

        Query q = em.createQuery("SELECT g FROM Gerer g, Admin a WHERE g.idadmin = a.idadmin =:idadmin");
        q.setParameter("idadmin", a.getIdadmin());
        try {
            return q.getResultList();
        } catch (Exception ex) {
        }
        return new ArrayList<>();
    }
}
