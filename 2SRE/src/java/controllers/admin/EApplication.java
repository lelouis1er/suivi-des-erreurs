/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.admin;

import entities.Admin;
import entities.Application;
import entities.Employe;
import entities.Erreur;
import entities.Gerer;
import entities.Gravite;
import entities.Membre;
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
import sessions.AdminFacadeLocal;
import sessions.ApplicationFacadeLocal;
import sessions.EmployeFacadeLocal;
import sessions.GererFacadeLocal;
import sessions.MembreFacadeLocal;


/**
 *
 * @author Lafortune
 */
@ManagedBean
@ViewScoped
@Named(value = "eMateriel")
public class EApplication implements Serializable {

    @EJB
    private ApplicationFacadeLocal applicationFacadeLocal;
    private List<Application> list_application = new ArrayList<>();
    private List<Application> list_application1 = new ArrayList<>();
    private int nbre_total_application;
    private Application selected_application;
    private Application create_Application = new Application();
    @EJB
    private EmployeFacadeLocal employeFacadeLocal;
    private List<Employe> list_employe = new ArrayList<>();
    Employe current_employe;
    
    @EJB
    private GererFacadeLocal gererFacadeLocal;
    private List<Gerer> list_gerer = new ArrayList<>();
    
    
    
    
    @EJB
    private MembreFacadeLocal membreFacadeLocal;
    private List<Membre> list_membre = new ArrayList<>();
    private int nbre_total_fiche;
    private Membre create_membre = new Membre();
    private Membre current_membre;
    
    
    @EJB
    private AdminFacadeLocal adminFacadeLocal;
    private List<Admin> list_admin = new ArrayList<>();
    private Admin current_Admin;
  
    private User user;

    @PostConstruct
    private void init() {

        HttpServletRequest hsr = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = hsr.getSession();

        user = (User) session.getAttribute("user");

   
        
        current_Admin = adminFacadeLocal .find(user.getId());
        list_application = applicationFacadeLocal.findAll();
        list_gerer = gererFacadeLocal.findAll_by_admin(current_Admin);
        
        list_membre = membreFacadeLocal.findAll();
        
        nbre_total_application = list_application.size();
        
       
        

    }

    public EApplication() {
    }

    public void saisi() {
    }
   

    public int nbre_total_application() {
        return list_application.size();
    }
    
    public int nbre_total_fiche() {
        return list_membre.size();
    }
    
    
    
    public String afficher (Erreur e) {
        System.out.println("redirection");
        if (e != null) {
            return "/employe/erreur/discussion.xhtml?faces_redirect=true&id_e=" + e.getIderreur();
        }
        return "";
    }
    
    

    /////////////////////////////// SETTEURS ET GETTEURS  //////////////////////////////////////////////////////////////////////////

    public ApplicationFacadeLocal getApplicationFacadeLocal() {
        return applicationFacadeLocal;
    }

    public void setApplicationFacadeLocal(ApplicationFacadeLocal applicationFacadeLocal) {
        this.applicationFacadeLocal = applicationFacadeLocal;
    }

    public List<Application> getList_application() {
        return list_application;
    }

    public void setList_application(List<Application> list_application) {
        this.list_application = list_application;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AdminFacadeLocal getAdminFacadeLocal() {
        return adminFacadeLocal;
    }

    public void setAdminFacadeLocal(AdminFacadeLocal adminFacadeLocal) {
        this.adminFacadeLocal = adminFacadeLocal;
    }

    public List<Admin> getList_admin() {
        return list_admin;
    }

    public void setList_admin(List<Admin> list_admin) {
        this.list_admin = list_admin;
    }

    public Admin getCurrent_Admin() {
        return current_Admin;
    }

    public void setCurrent_Admin(Admin current_Admin) {
        this.current_Admin = current_Admin;
    }

    public List<Membre> getList_membre() {
        return list_membre;
    }

    public void setList_membre(List<Membre> list_membre) {
        this.list_membre = list_membre;
    }

    public MembreFacadeLocal getMembreFacadeLocal() {
        return membreFacadeLocal;
    }

    public void setMembreFacadeLocal(MembreFacadeLocal membreFacadeLocal) {
        this.membreFacadeLocal = membreFacadeLocal;
    }

    public int getNbre_total_application() {
        return nbre_total_application;
    }

    public void setNbre_total_application(int nbre_total_application) {
        this.nbre_total_application = nbre_total_application;
    }

    public int getNbre_total_fiche() {
        return nbre_total_fiche;
    }

    public void setNbre_total_fiche(int nbre_total_fiche) {
        this.nbre_total_fiche = nbre_total_fiche;
    }

    public EmployeFacadeLocal getEmployeFacadeLocal() {
        return employeFacadeLocal;
    }

    public void setEmployeFacadeLocal(EmployeFacadeLocal employeFacadeLocal) {
        this.employeFacadeLocal = employeFacadeLocal;
    }

    public List<Employe> getList_employe() {
        return list_employe;
    }

    public void setList_employe(List<Employe> list_employe) {
        this.list_employe = list_employe;
    }

    public Employe getCurrent_employe() {
        return current_employe;
    }

    public void setCurrent_employe(Employe current_employe) {
        this.current_employe = current_employe;
    }

    public Membre getCreate_membre() {
        return create_membre;
    }

    public void setCreate_membre(Membre create_membre) {
        this.create_membre = create_membre;
    }

    public Application getSelected_application() {
        return selected_application;
    }

    public void setSelected_application(Application selected_application) {
        this.selected_application = selected_application;
    }

    public Application getCreate_Application() {
        return create_Application;
    }

    public void setCreate_Application(Application create_Application) {
        this.create_Application = create_Application;
    }

    public Membre getCurrent_membre() {
        return current_membre;
    }

    public void setCurrent_membre(Membre current_membre) {
        this.current_membre = current_membre;
    }

    public List<Gerer> getList_gerer() {
        return list_gerer;
    }

    public void setList_gerer(List<Gerer> list_gerer) {
        this.list_gerer = list_gerer;
    }

    
    
   
   


}
