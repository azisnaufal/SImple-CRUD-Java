/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleCrud;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author oazisn
 */
public class Koneksi {
        public static Connection getKoneksi(String host, String port, 
	String username, String password, String db) {
        String konString = "jdbc:mysql://" + host + "/" + db;
        Connection koneksi = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(konString, username, password);
            System.out.println("Koneksi Berhasil");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to connect to MySQL Server or Database Not Found!");
            System.exit(0);
        }
        return koneksi;
    }
}
