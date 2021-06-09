/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Employe;
import entities.Erreur;
import entities.Statut;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import sessions.EmployeFacadeLocal;
import sessions.ErreurFacadeLocal;
import sessions.StatutFacadeLocal;

/**
 *
 * @author PACO PC
 */
public abstract class SuperController {
    @EJB
    protected ErreurFacadeLocal erreurFacadeLocal;
    protected List<Erreur> list_erreurs = new ArrayList<>();

    @EJB
    protected EmployeFacadeLocal employeFacadeLocal;
    protected Employe current_employe;

    @EJB
    protected StatutFacadeLocal statutFacadeLocal;
    protected List<Statut> list_statut = new ArrayList<>();

    protected User user;
    
    
    
    
//////////////////////////////////   GETTRES ET SETTERS   //////////////////////////////////////////////////////////
    
    public List<Statut> getList_statut() {
        return list_statut;
    }

    public void setList_statut(List<Statut> list_statut) {
        this.list_statut = list_statut;
    }
    
}
