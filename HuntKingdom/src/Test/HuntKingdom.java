/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entities.utilisateur;
import Services.UserService;

/**
 *
 * @author salem
 */
public class HuntKingdom {

    public static void main(String[] args) {

        utilisateur u = new utilisateur("Saguer", "Med ALI", "mail@mail.tn", 27584698, ".... ");
        utilisateur u2 = new utilisateur("Malek", "Yedees", "mail@mail.tn", 27588528, ".... ");
        utilisateur u3 = new utilisateur("Akrem", "Jabeur", "mail@mail.tn", 27588698, ".... ");
        utilisateur u4 = new utilisateur("Jebali", "ONS", "mail@mail.tn", 27534698, ".... ");
        utilisateur u5 = new utilisateur("Saguer", "Med ALI", "mail@mail.tn", 27224698, ".... ");

        UserService US = new UserService();
        US.AjouterUtilisateur(u);
        US.AjouterUtilisateur(u2);
        US.AjouterUtilisateur(u3);
        US.AjouterUtilisateur(u4);

        US.AfficherUtilisateur();
        System.out.println("-------------------------------------------------------");
        US.ModifierUtilisateur(u5);
        US.AfficherUtilisateur();
        System.out.println("-------------------------------------------------------");
        US.SupprimerUtilisateur(u3);
        US.AfficherUtilisateur();
    }
}