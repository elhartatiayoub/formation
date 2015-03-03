package phase4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Administrateur on 03/03/2015.
 */
public  class JDBCConnectionSingl {

    static Connection connection = null;



    private JDBCConnectionSingl(){
        FileInputStream f = null;
        Properties p = new Properties ();
        try {
            f = new FileInputStream ("JDBCConnection.properties");
            p.load(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Class.forName(p.getProperty ("jdbc.driver"));
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }
        try {
            connection = DriverManager.getConnection(p.getProperty ("jdbc.url"), p.getProperty ("jdbc.user"), p.getProperty ("jdbc.pass"));
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

    public static Connection getInstance(){
        if(connection == null){
            new JDBCConnectionSingl();
        }
        return connection;
    }



}
