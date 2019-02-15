
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Customers {
    String a,b,c,d,e,f,g,cname;
int cu;
    Customers(String text, String toString, String toString0, String text0, String text1, String text2, String text3) {
a=text;
b=toString;
c=toString0;
d=text0;
e=text1;
f=text2;
g=text3;
int cu;
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Customers(String name){
        cname=name;
    }
    public Customers()
    {}

    Customers(int c) {
        cu = c;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    public void insert_customerDetails(){
   try {
        Class.forName("java.sql.Driver");
        java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost/csea","root","iclab");
        java.sql.Statement st=con.createStatement();
        String query="insert into customer_details values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"')";
        st.executeUpdate(query);
        con.close();
        JOptionPane.showMessageDialog(null, "successfully inserted");
        
        
    } catch (Exception ex) {
         JOptionPane.showMessageDialog(null, ex);
       
       // Logger.getLogger(Slabs.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }
    public void display(DefaultTableModel dtm)
    {
         try { 
             Class.forName("java.sql.Driver");
        java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost/csea","root","iclab");
        java.sql.Statement st=con.createStatement();
        String query="select * from customer_details";
       ResultSet rs= st.executeQuery(query);
        while(rs.next())
        {
            Object o[]={rs.getString("Customer_Name"),rs.getInt("year"),rs.getString("month"),rs.getInt("previous"),rs.getInt("current"),rs.getInt("consumed"),rs.getInt("amount")};
            dtm.addRow(o);
        } 
        }
        catch(Exception e){}
      
    }
    public double calculate() throws FileNotFoundException{
    double f=0;
    int a=0,b=0;
    try{
          Class.forName("java.sql.Driver");
        java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost/csea","root","iclab");
        java.sql.Statement st=con.createStatement();
        String query="select Cost_perunit,Service_charge from slab_details where '"+cu+"'>=Min_read and '"+cu+"'<=Max_read";
      ResultSet rs=st.executeQuery(query);
     
  while(rs.next())
  {
      a=rs.getInt("Cost_perunit");
      b=rs.getInt("Service_charge");
  }
    double d=cu*a+b;
      con.close();
     // JOptionPane.showMessageDialog(null, "successfully inserted");
      return d;  
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    return f;
}

  public  void search(DefaultTableModel dtm) {
        try{
               Class.forName("java.sql.Driver");
        java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost/csea","root","iclab");
        java.sql.Statement st=con.createStatement();
        System.out.println(cname);
        String query="select * from customer_details where Customer_Name='"+cname+"'";
       ResultSet rs= st.executeQuery(query);
        while(rs.next())
        {
            Object o[]={rs.getString("Customer_Name"),rs.getInt("year"),rs.getString("month"),rs.getInt("previous"),rs.getInt("current"),rs.getInt("consumed"),rs.getInt("amount")};
            dtm.addRow(o);
        } 
        con.close();
         JOptionPane.showMessageDialog(null, "successfully searched");
   
        }
        catch(Exception e){
        
  JOptionPane.showMessageDialog(null, "not found");
   
        }  //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
