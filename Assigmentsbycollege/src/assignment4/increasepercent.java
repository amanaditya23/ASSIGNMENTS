package assignment4;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	public class increasepercent {
	    public static void main(String[] args) {

	        String url = "jdbc:mysql://localhost:3306/college";
	        String user = "root";
	        String password = "232004";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            Connection con = DriverManager.getConnection(url, user, password);
	            System.out.println("Connected to database.");

	            String updateSQL = "UPDATE Students SET percentage = percentage * 1.05 WHERE branch = ?";
	            PreparedStatement ps = con.prepareStatement(updateSQL);

	            ps.setString(1, "CSE");

	            int rows = ps.executeUpdate();
	            System.out.println(rows + " record(s) updated.");

	            con.close();
	            System.out.println("Connection closed.");

	        } catch (ClassNotFoundException e) {
	            System.out.println("JDBC Driver not found.");
	        } catch (SQLException e) {
	            System.out.println("SQL Error: " + e.getMessage());
	        }
	    }
	}

