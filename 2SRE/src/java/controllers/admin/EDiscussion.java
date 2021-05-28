/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.admin;

import controllers.employe.*;
import entities.Commentaire;
import entities.Employe;
import entities.Erreur;
import entities.Membre;
import entities.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessions.CommentaireFacadeLocal;
import sessions.EmployeFacadeLocal;
import sessions.ErreurFacadeLocal;
import sessions.MembreFacadeLocal;
import sessions.StatutFacadeLocal;

/**
 *
 * @author Louis Stark
 */
@ManagedBean
@ViewScoped
public class EDiscussion {
    
    @EJB
    private StatutFacadeLocal statutFacadeLocal;

    @EJB
    private ErreurFacadeLocal erreurFacadeLocal;
    private Erreur current_erreur;

    @EJB
    private CommentaireFacadeLocal commentaireFacadeLocal;
    private List<Commentaire> list_commentaires = new ArrayList<>();
    private Commentaire new_commentaire = new Commentaire();

    @EJB
    private MembreFacadeLocal membreFacadeLocal;
    private List<Membre> list_membres = new ArrayList<>();
    private Membre current_membre;
    
    @EJB
    private EmployeFacadeLocal employeFacadeLocal;
    private Employe current_employe;
    
    private User user;

    @PostConstruct
    private void init() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpSession session = request.getSession();
        
        String id_e = request.getParameter("id_e");

        if (id_e != null) {

            Long id = id_e.isEmpty() ? null : Long.parseLong(id_e);

            if (id != null) {

                current_erreur = erreurFacadeLocal.find(id);

                if (current_erreur != null) {
                    user = (User) session.getAttribute("user");
                    current_employe = employeFacadeLocal.find(user.getId());
                    current_membre = membreFacadeLocal.find_by_employe(current_employe);
                    
                    list_commentaires = commentaireFacadeLocal.findAll_by_erreur(current_erreur);
                    list_membres = membreFacadeLocal.findAll();
                    
                    
                } else {
                    try {
                        response.sendRedirect(request.getContextPath() + "/employe/erreur.xhtml");
                    } catch (IOException ex) {
                        Logger.getLogger(EDiscussion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } else {
                try {
                    response.sendRedirect(request.getContextPath() + "/employe/erreur.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(EDiscussion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            try {
                response.sendRedirect(request.getContextPath() + "/employe/erreur.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(EDiscussion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public EDiscussion() {
    }
    
    public void saisi() {};
    
    public void send_commentaire () {
        if (!new_commentaire.getContenu().isEmpty())
        {
            new_commentaire.setIdCom(commentaireFacadeLocal.nextId());
            new_commentaire.setIderreur(current_erreur);
            new_commentaire.setIdmembre(current_membre);
            new_commentaire.setHeurearr(new Date());
            
            
            commentaireFacadeLocal.create(new_commentaire);
            update_list_commentaires();
        }
    }
    
    public void make_resolved () {
        current_erreur.setResolu(true);
        current_erreur.setIdstatut(statutFacadeLocal.find(2));
        erreurFacadeLocal.edit(current_erreur);
    }
    
    private void update_list_commentaires () {
        list_commentaires = commentaireFacadeLocal.findAll_by_erreur(current_erreur);
    }
    
    
    
//////////////////////////////// getters et setters  ////////////////////////////////////////

    public Erreur getCurrent_erreur() {
        return current_erreur;
    }

    public List<Commentaire> getList_commentaires() {
        return list_commentaires;
    }

    public List<Membre> getList_membres() {
        return list_membres;
    }

    public Employe getCurrent_employe() {
        return current_employe;
    }

    public Commentaire getNew_commentaire() {
        return new_commentaire;
    }

    public void setNew_commentaire(Commentaire new_commentaire) {
        this.new_commentaire = new_commentaire;
    }
    
    

}
