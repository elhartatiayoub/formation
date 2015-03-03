package phase3;

/**
 * Created by Administrateur on 03/03/2015.
 */
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    public static void main(String[] argv) {


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }

        java.sql.Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/test","root", "");

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
}