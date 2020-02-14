/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author salem
 */
public class chasseur extends utilisateur{
    
    String imagePermis;
    int idPermis;
    String login;
    String password;
    public chasseur() {
    }

    public chasseur(String imagePermis, int idPermis, String login, String password, String nom, String prenom, String adresseMail, int numTel, String imagePersonne) {
        super(nom, prenom, adresseMail, numTel, imagePersonne);
        this.imagePermis = imagePermis;
        this.idPermis = idPermis;
        this.login = login;
        this.password = password;
    }
   

    public String getImagePermis() {
        return imagePermis;
    }

    public void setImagePermis(String imagePermis) {
        this.imagePermis = imagePermis;
    }

    public int getIdPermis() {
        return idPermis;
    }

    public void setIdPermis(int idPermis) {
        this.idPermis = idPermis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public String getImagePersonne() {
        return imagePersonne;
    }

    public void setImagePersonne(String imagePersonne) {
        this.imagePersonne = imagePersonne;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "chasseur{" + "imagePermis=" + imagePermis + ", idPermis=" + idPermis + ", login=" + login + ", password=" + password + '}';
    }
    

    



    
}
