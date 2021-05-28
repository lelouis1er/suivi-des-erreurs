/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.employe;

import entities.Employe;
import entities.Erreur;
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
import sessions.ErreurFacadeLocal;

/**
 *
 * @author Lafortune
 */
@ManagedBean
@ViewScoped
@Named(value = "eErreur")
public class EErreur implements Serializable {

    @EJB
    private ErreurFacadeLocal erreurFacadeLocal;
    private List<Erreur> list_erreurs = new ArrayList<>();
    private Erreur selected_erreur;

    @EJB
    private EmployeFacadeLocal employeFacadeLocal;
    private Employe current_employe;

    private User user;

    @PostConstruct
    private void init() {

        HttpServletRequest hsr = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = hsr.getSession();

        user = (User) session.getAttribute("user");

        current_employe = employeFacadeLocal.find(user.getId());

        list_erreurs = erreurFacadeLocal.findAll_byEmploye(current_employe);
        

    }

    public EErreur() {
    }

    public void saisi() {
    }



    public double nbre_total_erreurs() {
        return list_erreurs.size();
    }
    
    public double nbre_erreur_resolu ()
    {
        double nbre = 0.0;
        for (Erreur e: list_erreurs)
        {
            if (e.getResolu())
                nbre += 1;
        }
        return nbre;
    }
    
    public String afficher (Erreur e) {
        System.out.println("redirection");
        if (e != null) {
            return "/employe/erreur/discussion.xhtml?faces_redirect=true&id_e=" + e.getIderreur();
        }
        return "";
    }
    
    

    /////////////////////////////// SETTEURS ET GETTEURS  //////////////////////////////////////////////////////////////////////////
    public Employe getCurrent_employe() {
        return current_employe;
    }

    public void setCurrent_employe(Employe current_employe) {
        this.current_employe = current_employe;
    }

    public List<Erreur> getList_erreurs() {
        return list_erreurs;
    }

    public Erreur getSelected_erreur() {
        return selected_erreur;
    }

    public void setSelected_erreur(Erreur selected_erreur) {
        this.selected_erreur = selected_erreur;
    }
    


}
