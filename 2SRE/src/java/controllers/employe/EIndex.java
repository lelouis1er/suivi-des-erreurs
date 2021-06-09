 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.employe;

import controllers.admin.*;
import entities.Employe;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sessions.ErreurFacadeLocal;
import entities.Erreur;
import entities.Statut;
import entities.User;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import sessions.EmployeFacadeLocal;
import sessions.StatutFacadeLocal;

/**
 *
 * @author Lafortune
 */
@ManagedBean
@ViewScoped
@Named(value = "eIndex")
public class EIndex implements Serializable {

    @EJB
    private ErreurFacadeLocal erreurFacadeLocal;
    private List<Erreur> list_erreurs = new ArrayList<>();

    @EJB
    private EmployeFacadeLocal employeFacadeLocal;
    private Employe current_employe;

    @EJB
    private StatutFacadeLocal statutFacadeLocal;
    protected List<Statut> list_statut = new ArrayList<>();

    private User user;

    private List<Statu> list_stat = new ArrayList<>();

    private boolean etats_is_empty = true;

    @PostConstruct
    private void init() {

        HttpServletRequest hsr = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = hsr.getSession();

        user = (User) session.getAttribute("user");

        current_employe = employeFacadeLocal.find(user.getId());

        list_erreurs = erreurFacadeLocal.findAll_byEmploye(current_employe);

        list_statut = statutFacadeLocal.findAll();

        init_map_statut();


    }

    public EIndex() {

    }
    
    public void refresh () {
        list_erreurs = erreurFacadeLocal.findAll_byEmploye(current_employe);
        init_map_statut();
    }

    private void init_map_statut() {
        list_stat = new ArrayList<>();
        for (Statut s : list_statut) {
            list_stat.add(new Statu(s));
        }
        init_set_statu_num_val();
    }

    private void init_set_statu_num_val() {

        for (Erreur e : list_erreurs) {
            if (find_index_of_statut(e.getIdstatut()) != -1) {
                list_stat.get(find_index_of_statut(e.getIdstatut())).incremente();
            }
        }

    }

    private int find_index_of_statut(Statut s) {
        for (int i = 0; i < list_stat.size(); i++) {
            if (list_statut.get(i).getLibele().equals(s.getLibele())) {
                return i;
            }
        }
        return -1;
    }

//////////////////////////////////   GETTRES ET SETTERS   //////////////////////////////////////////////////////////
    public boolean isEtats_is_empty() {
        return etats_is_empty;
    }

    public List<Statu> getList_stat() {
        return list_stat;
    }

    public List<Statut> getList_statut() {
        return list_statut;
    }

    public void setList_statut(List<Statut> list_statut) {
        this.list_statut = list_statut;
    }
    
    

///////////////////////////////  CLASS   /////////////////////////////////////////    
    public class Statu {

        private Statut s;
        private int nbre = 0;

        public Statu(Statut s) {
            this.s = s;
        }

        public void incremente() {
            nbre += 1;
        }

        public String getLibelle() {
            return s.getLibele();
        }
        
         public String getStyle() {
            return s.getStyle();
        }

        public void setLibelle(String libelle) {
            this.s.setLibele(libelle);
        }

        public int getNbre() {
            return nbre;
        }

        public void setNbre(int nbre) {
            this.nbre = nbre;
        }

        public Statut getS() {
            return s;
        }

        
    }

}
