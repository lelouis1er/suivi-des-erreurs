/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.converter;

import entities.Application;
import entities.Gravite;
import entities.Typeerreur;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import sessions.ApplicationFacadeLocal;
import sessions.GraviteFacadeLocal;
import sessions.TypeerreurFacadeLocal;

/**
 *
 * @author Lafortune
 */
@ManagedBean
@RequestScoped
@Named(value = "superConverter")
public class SuperConverter {

    @EJB
    private GraviteFacadeLocal graviteFacadeLocal;
    private List<Gravite> list_Gravites;
    
    @EJB
    private ApplicationFacadeLocal applicationFacadeLocal;
    private List<Application> list_Appli;
    
    @EJB
    private TypeerreurFacadeLocal typeerreurFacadeLocal;
    private List<Typeerreur> list_typeE;

    @PostConstruct
    private void init() {
        list_Gravites = graviteFacadeLocal.findAll();
        list_Appli = applicationFacadeLocal.findAll();
        list_typeE = typeerreurFacadeLocal.findAll();
    }

    public SuperConverter() {

    }

    public Gravite find_gravite_in_list_gravite(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("aucun id remplie");
        }
        for (Gravite g : list_Gravites) {
            if (id.equals(g.getIdgravite())) {
                return g;
            }
        }
        return null;
    }
    
    public Application find_appli_in_list_appli(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("aucun id remplie");
        }
        for (Application a : list_Appli) {
            if (id.equals(a.getIdappli())) {
                return a;
            }
        }
        return null;
    }
    
    public Typeerreur find_typeErreur_in_list_typeE(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("aucun id remplie");
        }
        for (Typeerreur t : list_typeE) {
            if (id.equals(t.getIdtype())) {
                return t;
            }
        }
        return null;
    }

}
