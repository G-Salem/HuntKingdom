/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.chasseur;
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
public class chasseurService {
    
    Connection conn = DataSource.getInstance().getConnection();

    public void AjouterChasseur(chasseur c) {
        String req = "insert into chasseur(nom,prenom,adresseMail,numTel,imagePersonne,imagePermis,idPermis,login,password)"
                + "values ('" + c.getNom() + "','" + c.getPrenom() + "','" + c.getAdresseMail() + "','" + c.getNumTel() + "','" + c.getImagePersonne()+ "','"+ c.getImagePermis()+ "','"+c.getIdPermis()+ "','"+c.getLogin()+ "','"+c.getPassword() +"')";

        try {
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("chasseur ajouté");
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<chasseur> Afficherchasseur() {

        List<chasseur> listCH = new ArrayList();
        String req = "select * from chasseur ";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                chasseur c = new chasseur();
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setAdresseMail(rs.getString("adresseMail"));
                c.setNumTel(rs.getInt("numTel"));
                c.setImagePersonne(rs.getString("imagePersonne"));
                c.setImagePermis(rs.getString("imagePermis"));
                c.setIdPermis(rs.getInt("idPermis"));
                c.setLogin(rs.getString("login"));
                c.setPassword(rs.getString("password"));
                
                listCH.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCH;

    }

    public void SupprimerChasseur(chasseur c) {
        String req = "delete from chasseur where id='"+c.getId()+"'";
        PreparedStatement pt;
        try {
            pt = conn.prepareStatement(req);

            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ModifierChasseur(chasseur c , chasseur c1 ){
        int x=c.getId();
      SupprimerChasseur(c);  
      AjouterChasseur(c1);
        c1.setId(x);
    }
    
    // methode connection 
}
