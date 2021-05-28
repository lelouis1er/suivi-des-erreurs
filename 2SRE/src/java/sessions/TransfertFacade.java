/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Transfert;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Louis Stark
 */
@Stateless
public class TransfertFacade extends AbstractFacade<Transfert> implements TransfertFacadeLocal {
    @PersistenceContext(unitName = "StagePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransfertFacade() {
        super(Transfert.class);
    }
    
}
