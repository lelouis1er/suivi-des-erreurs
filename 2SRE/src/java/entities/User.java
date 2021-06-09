/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Lafortune
 */
public class User{
    
    private String nom;
    private String type;
    private String prenom;
    private int id;
    private Object user;
    
    public User(Admin a){
        this.nom = a.getLogin();
        this.prenom = "";
        this.type = "admin";
        this.id = a.getIdadmin();
        this.user = a;
    }
    
    public User(Employe e){
        this.nom = e.getLogin();
        this.type = "employe";
        this.prenom = e.getPrenom();
        this.id = e.getIdemp();
        this.user = e;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public User(String nom, String type, String prenom, int id) {
        this.nom = nom;
        this.type = type;
        this.prenom = prenom;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User: nom: "+this.nom+" ; prenom:"+this.prenom+" ; type:"+this.type+" ; id:"+this.id+" ;";
    }
    
    
    
}
