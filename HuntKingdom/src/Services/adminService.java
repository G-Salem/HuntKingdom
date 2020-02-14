/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.admin;
import Entities.chasseur;
import Entities.utilisateur;
import Utilities.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salem
 */
public class adminService extends utilisateur{
    

    
    Connection conn = DataSource.getInstance().getConnection();

    public void AjouterAdmin(admin a) {
        String req = "insert into admin(nom,prenom,adresseMail,login,password)"
                + "values ('" + a.getNom() + "','" + a.getPrenom() + "','" + a.getAdresseMail() + "','"+ a.getLogin() + "','"+ a.getPassword() +"')";

        try {
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Admin ajouté");
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<admin> AfficherAdmin() {

        List<admin> listAD = new ArrayList();
        String req = "select * from admin ";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                admin a = new admin();
                a.setNom(rs.getString("nom"));
                a.setPrenom(rs.getString("prenom"));
                a.setAdresseMail(rs.getString("adresseMail"));
                a.setLogin(rs.getString("login"));
                a.setPassword(rs.getString("password"));
                
                listAD.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAD;

    }

    public void SupprimerAdmin(admin a) {
        String req = "delete from chasseur where id='"+a.getId()+"'";
        PreparedStatement pt;
        try {
            pt = conn.prepareStatement(req);

            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ModifierChasseur(admin a , admin a1 ){
        int x=a.getId();
      SupprimerAdmin(a);  
      AjouterAdmin(a1);
        a1.setId(x);
    }

public List<utilisateur> getUserParMotCle(String motCle) {
        Statement st;
        List<utilisateur> UT = new ArrayList();
        try {
            st = conn.createStatement();
            String req = "select * from utilisateur where nom like '%" + motCle + "%' or prenom like '%" ;
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
//                UT.add(new utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
                UT.add(new utilisateur( rs.getString("nom"), rs.getString("prenom"), rs.getString("adresseMail"), rs.getInt("numTel"), rs.getString("imagePersonne")));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }  
        return UT;
    }


}
