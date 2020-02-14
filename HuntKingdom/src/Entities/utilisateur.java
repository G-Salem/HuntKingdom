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
public class utilisateur {
    int id;
    String nom;
    String prenom;
    String adresseMail;
    int numTel;
    String imagePersonne;
    
    public utilisateur() {
    }

    public utilisateur(String nom, String prenom, String adresseMail, int numTel, String imagePersonne) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresseMail = adresseMail;
        this.numTel = numTel;
        this.imagePersonne = imagePersonne;
    }

    public utilisateur(String nom, String prenom, String adresseMail) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresseMail = adresseMail;
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

    

    @Override
    public String toString() {
        return "utilisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresseMail=" + adresseMail + ", numTel=" + numTel + ", imagePersonne=" + imagePersonne +'}';
    }
    
    
}
