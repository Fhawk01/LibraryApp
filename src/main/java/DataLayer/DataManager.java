package DataLayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public abstract class DataManager {


    protected Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=books;user=sa;password=pass";
            Connection con = DriverManager.getConnection(url);
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return null;
    }

    public DataManager() {
        Properties properties = new Properties();

        InputStream is = null;
        try {
            is = new FileInputStream("src/main/resources/app.properties");

        } catch (FileNotFoundException ex) {
            System.out.println("Could not load database config");
            return;
        }

        try {
            properties.load(is);
        } catch (IOException ex) {
            System.out.println("Could not load database config");
            return;
        }
        
    }
}