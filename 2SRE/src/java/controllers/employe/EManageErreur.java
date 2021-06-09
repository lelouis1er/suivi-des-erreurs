/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.employe;

import entities.Admin;
import entities.Application;
import entities.Employe;
import entities.Erreur;
import entities.Gerer;
import entities.Gravite;
import entities.Membre;
import entities.Statut;
import entities.Typeerreur;
import entities.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.PrimeFaces;
import sessions.ApplicationFacadeLocal;
import sessions.EmployeFacadeLocal;
import sessions.ErreurFacadeLocal;
import sessions.GraviteFacadeLocal;
import sessions.MembreFacadeLocal;
import sessions.StatutFacadeLocal;
import sessions.TypeerreurFacadeLocal;

/**
 *
 * @author Louis Stark
 */
@ManagedBean
@ViewScoped
@Named(value = "eManageErreur")
public class EManageErreur implements Serializable {

    @EJB
    private ErreurFacadeLocal erreurFacadeLocal;
    private List<Erreur> list_erreurs = new ArrayList<>();
    private Erreur create_erreur = new Erreur();

    @EJB
    private EmployeFacadeLocal employeFacadeLocal;
    private Employe current_employe;

    @EJB
    protected TypeerreurFacadeLocal typeerreurFacadeLocal;
    protected List<Typeerreur> list_typeE = new ArrayList<>();
    protected Typeerreur selected_typeE;

    @EJB
    private GraviteFacadeLocal graviteFacadeLocal;
    private List<Gravite> list_Gravites = new ArrayList<>();
    private Gravite selected_gravite;

    @EJB
    private ApplicationFacadeLocal applicationFacadeLocal;
    private List<Application> list_Application = new ArrayList<>();
    private List<Application> list_Application1 = new ArrayList<>();
    private Application selected_application;

    @EJB
    protected StatutFacadeLocal statutFacadeLocal;
    protected Statut current_statut;

    @EJB
    protected MembreFacadeLocal membreFacadeLocal;

    protected Admin admin_principal;

    private User user;

    @PostConstruct
    private void init() {

        HttpServletRequest hsr = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = hsr.getSession();

        user = (User) session.getAttribute("user");

        current_employe = employeFacadeLocal.find(user.getId());

        list_erreurs = erreurFacadeLocal.findAll_byEmploye(current_employe);

        list_Gravites = graviteFacadeLocal.findAll();

        list_erreurs = erreurFacadeLocal.findAll();

        list_typeE = typeerreurFacadeLocal.findAll();

        
        
        list_Application1 = applicationFacadeLocal.findAll();
        

    }

    public EManageErreur() {
    }

    public void saisi() {
    }

    public void send_erreur() {
        if (create_erreur != null && current_employe != null) {
            FacesMessage msg;
            if (selected_application != null && selected_gravite != null && selected_typeE != null) {
                current_statut = statutFacadeLocal.find(1);
                for (Gerer g : selected_application.getGererList()) {
                    if (g.getRole().equals("principal")) {
                        admin_principal = g.getAdmin();
                    }
                }
                create_erreur.setIderreur(erreurFacadeLocal.nextId());
                create_erreur.setIdemp(current_employe);
                create_erreur.setIdtype(selected_typeE);
                create_erreur.setIdappli(selected_application);
                create_erreur.setIdgravite(selected_gravite);
                create_erreur.setDatedeclarer(new Date());
                create_erreur.setIdstatut(current_statut);
                create_erreur.setIdadmin(admin_principal);
                create_erreur.setResolu(false);

                try {
                    erreurFacadeLocal.create(create_erreur);

                    // on ajoute les membres de la discussion
                    // 1 - le createur (employe ayant déclarer l'erreur)
                    Membre membre = new Membre();
                    membre.setIdmembre(membreFacadeLocal.nextId());
                    membre.setIdemp(current_employe);
                    membre.setNom(current_employe.getNom());
                    membre.setPrenom(current_employe.getPrenom());
                    membre.setTypeMembre("createur");

                    membreFacadeLocal.create(membre);

                    // 2. on creer l'admin responsable
                    membre = new Membre();
                    membre.setIdmembre(membreFacadeLocal.nextId());
                    membre.setIdadmin(admin_principal);
                    membre.setNom(admin_principal.getNom());
                    membre.setTypeMembre("admin");

                    membreFacadeLocal.create(membre);

                    create_erreur = new Erreur();
                    selected_application = new Application();
                    selected_gravite = new Gravite();

                    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "L'erreur à été signaler !", null);
                    PrimeFaces.current().executeScript("PF('dde').hide()");
                } catch (Exception e) {
                    msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Une erreur s'est produite: " + e.getMessage(), null);
                }
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "le type d'erreur ou le niveau de gravité n'a pas été selectionné !", null);
            }

            PrimeFaces.current().dialog().showMessageDynamic(msg, true);
        }
    }

///////////////////////////////////   GETTERS ET SETTERS  //////////////////////////////////////////////////
    public List<Typeerreur> getList_typeE() {
        return list_typeE;
    }

    public List<Gravite> getList_Gravites() {
        return list_Gravites;
    }

    public List<Application> getList_Application() {
        return list_Application;
    }

    public Erreur getCreate_erreur() {
        return create_erreur;
    }

    public void setCreate_erreur(Erreur create_erreur) {
        this.create_erreur = create_erreur;
    }

    public Typeerreur getSelected_typeE() {
        return selected_typeE;
    }

    public void setSelected_typeE(Typeerreur selected_typeE) {
        this.selected_typeE = selected_typeE;
    }

    public Gravite getSelected_gravite() {
        return selected_gravite;
    }

    public void setSelected_gravite(Gravite selected_gravite) {
        this.selected_gravite = selected_gravite;
    }

    public Application getSelected_application() {
        return selected_application;
    }

    public void setSelected_application(Application selected_application) {
        this.selected_application = selected_application;
    }

    public List<Erreur> getList_erreurs() {
        return list_erreurs;
    }

    public void setList_erreurs(List<Erreur> list_erreurs) {
        this.list_erreurs = list_erreurs;
    }

    public List<Application> getList_Application1() {
        return list_Application1;
    }

    public void setList_Application1(List<Application> list_Application1) {
        this.list_Application1 = list_Application1;
    }

    
    
    
    
}



