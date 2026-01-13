package assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnectionTest {

    public static void main(String[] args) {
    	
    	Connection con = null;
    	Statement stmt = null;
    	ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/colleges";
        String user = "root";
        String pass = "232004";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url, user, pass);

            if (con != null) {
                System.out.println("Connection Successful");
                con.close();
            } else {
                System.out.println("Unable to connect");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Unable to connect");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Unable to connect");
            e.printStackTrace();
        }
    }
}
