/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

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
public class UserService {

    Connection conn = DataSource.getInstance().getConnection();

    public void AjouterUtilisateur(utilisateur u) {
        String req = "insert into utilisateur(nom,prenom,adresseMail,numTel,imagePersonne)"
                + "values ('" + u.getNom() + "','" + u.getPrenom() + "','" + u.getAdresseMail() + "','" + u.getNumTel() + "','" + u.getImagePersonne() +"')";

        try {
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("utilisateur ajouté");
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<utilisateur> AfficherUtilisateur() {

        List<utilisateur> listUT = new ArrayList();
        String req = "select * from utilisateur ";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                utilisateur u = new utilisateur();
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setAdresseMail(rs.getString("adresseMail"));
                u.setNumTel(rs.getInt("numTel"));
                u.setImagePersonne(rs.getString("imagePersonne"));
                
                listUT.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUT;

    }

   public void SupprimerUtilisateur(utilisateur u) {
        String req = "delete from utilisateur where id='"+u.getId()+"'";
        PreparedStatement pt;
        try {
            pt = conn.prepareStatement(req);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/*
    public void ModifierUtilisateur(utilisateur u , utilisateur u1 ){
        int x=u.getId();
      //  SupprimerUtilisateur(u.getId());
      SupprimerUtilisateur(u);  
      AjouterUtilisateur(u1);
        u1.setId(x);
        
    }*/
    public  void ModifierUtilisateur(utilisateur u)
    {
        try {
         Statement st =conn.createStatement();
            String req="UPDATE  utilisateur set id='"+u.getId()+"',nom='"+u.getNom()+"',prenom='"+u.getPrenom()+"',adresseMail='"+u.getAdresseMail()+"',numTel='"+ u.getNumTel()+"',imagePersonne='"+ u.getImagePersonne()+"'WHERE id_pb ='"+u.getId()+"'";
    st = conn.prepareStatement(req);
    st.executeUpdate(req);
        } catch (SQLException ex) {
Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);        }
        
    }
}

