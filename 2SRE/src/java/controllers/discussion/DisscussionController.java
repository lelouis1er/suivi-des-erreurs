 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.discussion;

import entities.Admin;
import entities.Commentaire;
import entities.Employe;
import entities.Erreur;
import entities.Membre;
import entities.Statut;
import entities.User;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
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
@ManagedBean(name = "discussionController")
@ViewScoped
public class DisscussionController implements Serializable {

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

    private String msg = "";

    private User user;

    @PostConstruct
    private void init() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpSession session = request.getSession();

        String id_e = request.getParameter("id_e");
        System.out.println("id : " + id_e);

        try {
            if (id_e != null) {

                Long id = id_e.isEmpty() ? null : Long.parseLong(id_e);

                if (id != null) {

                    current_erreur = erreurFacadeLocal.find(id);
                    System.out.println("erreur correspondante : " + current_erreur);

                    if (current_erreur != null) {
                        if (current_erreur.getLu() == null || current_erreur.getLu() == false) {
                            current_erreur.setDatelu(new Date());
                            current_erreur.setLu(true);
                            
                            erreurFacadeLocal.edit(current_erreur);
                        } 
                        user = (User) session.getAttribute("user");
                        current_employe = employeFacadeLocal.find(user.getId());
                        current_membre = membreFacadeLocal.find_by_employe(current_employe);

                        list_commentaires = commentaireFacadeLocal.findAll_by_erreur(current_erreur);
                        list_membres = membreFacadeLocal.findAll();

                    } else {
                        throw new Exception("Erreur non existante !!!");
                    }

                } else {
                    throw new Exception("Id non valide !!!");
                }

            } else {
                throw new Exception("Id non valide !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.sendRedirect(request.getContextPath() + "/application/e/messages.xhtml");
            } catch (IOException ex) {
                ex.printStackTrace();
                Logger.getLogger(DisscussionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public DisscussionController() {
    }

    public void saisi() {
    }

    ;
    
    public void send_commentaire() {
        if (!msg.isEmpty()) {
            new_commentaire = new Commentaire();
            new_commentaire.setIdCom(commentaireFacadeLocal.nextId());
            new_commentaire.setContenu(msg);
            new_commentaire.setIderreur(current_erreur);
            new_commentaire.setHeurearr(new Date());
            Membre m = find_membre_in_list();
            if (m == null) {
                m = new Membre();
                m.setIdmembre(membreFacadeLocal.nextId());
                if (user.getType().equals("admin")) {
                    m.setIdadmin(((Admin) user.getUser()));

                } else if (!user.getType().equals("admin")) {
                    m.setIdemp(((Employe) user.getUser()));
                }
                m.setNom(user.getNom());
                m.setPrenom(user.getPrenom());
                m.setTypeMembre(user.getType());

                membreFacadeLocal.create(m);
            }
            new_commentaire.setIdmembre(m);

            commentaireFacadeLocal.create(new_commentaire);
            update_list_commentaires();
            
            msg = "";
        }
    }

    public boolean is_my_comment(Commentaire c) {
        if (user.getType().equals("admin")) {
            if (c.getIdmembre().getIdadmin() != null) {
                if (c.getIdmembre().getIdadmin().getIdadmin().equals(((Admin) user.getUser()).getIdadmin())) {
                    return true;
                }
            }
        } else if (!user.getType().equals("admin")) {
            if (c.getIdmembre().getIdemp() != null) {
                if (c.getIdmembre().getIdemp().getIdemp().equals(((Employe) user.getUser()).getIdemp())) {
                    return true;
                }
            }
        }
        return false;

    }

    public void make_resolved() {
        current_erreur.setResolu(true);
        current_erreur.setIdstatut(new Statut(2));
        current_erreur.setDateresolu(new Date());
        erreurFacadeLocal.edit(current_erreur);

    }

    public void make_annule() {

        current_erreur.setIdstatut(new Statut(3));
        erreurFacadeLocal.edit(current_erreur);

    }

    public void make_nonresolu() {

        current_erreur.setIdstatut(new Statut(4));
        erreurFacadeLocal.edit(current_erreur);

    }

    private void update_list_commentaires() {
        list_commentaires = commentaireFacadeLocal.findAll_by_erreur(current_erreur);
    }

    public List<Membre> all_discus_membre() {
        List<Membre> result = new ArrayList<>();
        List<Commentaire> _temp = commentaireFacadeLocal.findAll_by_erreur(current_erreur);

        for (Commentaire c : _temp) {
            if (!exist_in_list(result, c.getIdmembre())) {
                result.add(c.getIdmembre());
            }
        }
        return result;
    }

    public boolean exist_in_list(List<Membre> l, Membre m) {
        for (Membre m1 : l) {
            if (m1.getIdmembre().equals(m.getIdmembre())) {
                return true;
            }
        }
        return false;
    }

    private Membre find_membre_in_list() {
        Membre result = null;
        List<Commentaire> _temp = commentaireFacadeLocal.findAll_by_erreur(current_erreur);

        for (Commentaire c : _temp) {
            if (user.getType().equals("admin")) {
                if (c.getIdmembre().getIdadmin() != null) {
                    if (c.getIdmembre().getIdadmin().getIdadmin().equals(((Admin) user.getUser()).getIdadmin())) {
                        result = c.getIdmembre();
                        break;
                    }
                }
            } else if (!user.getType().equals("admin")) {
                if (c.getIdmembre().getIdemp() != null) {
                    if (c.getIdmembre().getIdemp().getIdemp().equals(((Employe) user.getUser()).getIdemp())) {
                        result = c.getIdmembre();
                        break;
                    }
                }

            }
        }
        return result;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
