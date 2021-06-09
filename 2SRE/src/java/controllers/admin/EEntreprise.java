/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.admin;


import entities.Employe;
import entities.Entreprise;

import entities.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import sessions.EmployeFacadeLocal;
import sessions.EntrepriseFacadeLocal;


/**
 *
 * @author Lafortune
 */
@ManagedBean
@ViewScoped
@Named(value = "eEntreprise")
public class EEntreprise implements Serializable {

  
    @EJB
    private EntrepriseFacadeLocal entrepriseFacadeLocal;
    private List<Entreprise> list_entreprise = new ArrayList<>();
    private Entreprise entreprise;
    private double nbre_total_entreprise;
    
    @PostConstruct
    private void init() {

        HttpServletRequest hsr = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = hsr.getSession();


        entreprise = (Entreprise) session.getAttribute("entreprise");
        
        
        list_entreprise = entrepriseFacadeLocal.findAll();
        
        nbre_total_entreprise = list_entreprise.size();
        

    }

    public EEntreprise() {
    }

    public void saisi() {
    }

    /**
     *
     * @return
     */
   
    
    public double nbre_total_entreprise() {
        return list_entreprise.size();
    }
    
 
    
    

    /////////////////////////////// SETTEURS ET GETTEURS  //////////////////////////////////////////////////////////////////////////

    public EntrepriseFacadeLocal getEntrepriseFacadeLocal() {
        return entrepriseFacadeLocal;
    }

    public void setEntrepriseFacadeLocal(EntrepriseFacadeLocal entrepriseFacadeLocal) {
        this.entrepriseFacadeLocal = entrepriseFacadeLocal;
    }

    public List<Entreprise> getList_entreprise() {
        return list_entreprise;
    }

    public void setList_entreprise(List<Entreprise> list_entreprise) {
        this.list_entreprise = list_entreprise;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public double getNbre_total_entreprise() {
        return nbre_total_entreprise;
    }

    public void setNbre_total_entreprise(double nbre_total_entreprise) {
        this.nbre_total_entreprise = nbre_total_entreprise;
    }

    
    
}   