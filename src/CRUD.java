


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author crisl
 */
public class CRUD {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
   
    private static final String USER = "ufnprojetomove";

    private static final String PASS = "USc5KrG_77nwVC";
    
    private static final String URL = "jdbc:mysql://ufnprojetomove.mysql.dbaas.com.br:3306/ufnprojetomove?useTimeZone=true&serverTimezone=UTC&user="+USER+"&password="+PASS;
    
    Connection c;
    Statement stmt = null;
    
    public void connect() {
        try {
            Class.forName(DRIVER).newInstance();
             c = DriverManager.getConnection(URL);
            System.out.println("Conectado!");           
        } catch (Exception e) {
            System.out.println("e: " + e);
            JOptionPane.showMessageDialog(null, e);           
        }
    }

    public String login(String email, String pass) throws SQLException {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `Pessoa` WHERE `email` = \""+email+"\" and `senha` = \""+pass+"\""); 
           
            if (rs != null && rs.next()) {
                JOptionPane.showMessageDialog(null, "Bem vindo "+rs.getString("nome")+"!");
                return rs.getString("nome");
            }
            
        } catch (Exception e) {
            System.out.println("e: " + e);
            JOptionPane.showMessageDialog(null, e);           
        } 
        return null;
    }

    ResultSet getEstoque() throws SQLException {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `Estoque`"); 
           
            return rs;
            
        } catch (Exception e) {
            System.out.println("e: " + e);
            JOptionPane.showMessageDialog(null, e);           
        } 
        return null;
    }

   
    Connection connect(String driver, String user, String pass, String url) {
          try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            c = DriverManager.getConnection("jdbc:mysql://" + user+ ":" + pass + "/" + url+ "?useTimeZone=true&serverTimezone=UTC&user=" + user + "&password=" +pass);
            System.out.println("Conectado!");
        } catch (Exception e) {
            System.out.println("e: " + e);
        }
        return c; //To change body of generated methods, choose Tools | Templates.
    }

}



