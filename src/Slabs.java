



import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CSE
 */
public class Slabs {
String a,b,c,d;
    Slabs(String text, String text0, String text1, String text2) {
        a=text;
        b=text0;
        c=text1;
        d=text2;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public void insert_slabDetails()
    {
    try {
        Class.forName("java.sql.Driver");
        java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost/csea","root","iclab");
        java.sql.Statement st=con.createStatement();
        String query="insert into slab_details(Min_read,Max_read,Cost_perunit,Service_charge) values('"+a+"','"+b+"','"+c+"','"+d+"')";
        st.executeUpdate(query);
        con.close();
        JOptionPane.showMessageDialog(null, "successfully inserted");
        
        
    } catch (Exception ex) {
         JOptionPane.showMessageDialog(null, ex);
       
       // Logger.getLogger(Slabs.class.getName()).log(Level.SEVERE, null, ex);
    } 
       }
    
}
