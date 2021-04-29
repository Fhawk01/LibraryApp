/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author johnk
 */
public abstract class DataManager {

    private String hostName;
    private String databaseName;
    private String userName;
    private String password;

    protected Connection getConnection() throws SQLException {
        String connectionString = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;logonTimeout=30;",
                hostName, databaseName, userName, password);

        return DriverManager.getConnection(connectionString);
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
        
        
        this.hostName = properties.getProperty("db.host");
        this.databaseName = properties.getProperty("db.name");
        this.userName = properties.getProperty("db.user");
        this.password = properties.getProperty("db.password");
    }
}
