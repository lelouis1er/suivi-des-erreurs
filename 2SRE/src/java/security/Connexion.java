/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import entities.Admin;
import entities.Employe;
import entities.User;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.PrimeFaces;
import sessions.EmployeFacadeLocal;
import sessions.AdminFacadeLocal;

/**
 *
 * @author Lafortune
 */
@ManagedBean
@ViewScoped
public class Connexion implements Serializable {

    @EJB
    private EmployeFacadeLocal employeFacadeLocal;

    @EJB
    private AdminFacadeLocal adminFacadeLocal;

    private String[] type_conn = {"simple utilisateur", "administrateur"};
    private String selected_type = "simple utilisateur";

    private User user;
    private String login, mdp;

    public Connexion() {
    }
    
    public void saisi () {
        System.out.println("type: " + selected_type);
    }

    public String Se_Connecter(HttpServletRequest hsr) {

        if (!login.isEmpty() && !mdp.isEmpty()) {
            System.out.println("type: " + selected_type);
            if (selected_type != null) {
                if (selected_type.equals(type_conn[0])) {
                    Employe temp_em = employeFacadeLocal.find_by_login_mdp(login);
                    if (temp_em != null) {

                        if (!Cryptage.compare(temp_em.getMdp(), mdp)) {
                            temp_em = null;
                        }
                        if (temp_em != null) {
                            user = new User(temp_em);
                            (hsr.getSession()).setAttribute("user", user);

                            return "/employe/index.xhtml?faces_redirect=true";
                        }

                    }
                } else if (selected_type.equals(type_conn[1])) {
                    Admin temp_ad = adminFacadeLocal.find_by_login_mdp(login);
                    if (temp_ad != null) {

                        if (!Cryptage.compare(temp_ad.getMdp(), mdp)) {
                            temp_ad = null;
                        }
                        if (temp_ad != null) {
                            user = new User(temp_ad);
                            (hsr.getSession()).setAttribute("user", user);

                            return "/admin/index.xhtml?faces_redirect=true";
                        }
                    }
                }
            }
        }
        
        PrimeFaces.current().dialog().showMessageDynamic(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Impossible de se connecter", "login ou mot de passe incorrect"), true);
        return null;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String[] getType_conn() {
        return type_conn;
    }

    public String getSelected_type() {
        return selected_type;
    }

    public void setSelected_type(String selected_type) {
        this.selected_type = selected_type;
    }

}
