package assignment4;



	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	public class Insertreport {
	    public static void main(String[] args) {

	        String url = "jdbc:mysql://localhost:3306/college";
	        String user = "root";
	        String password = "232004";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            Connection con = DriverManager.getConnection(url, user, password);
	            System.out.println("Connected to database.");

	            Statement stmt = con.createStatement();

	            String createTable = "CREATE TABLE IF NOT EXISTS Students (" +
	                    "id INT PRIMARY KEY AUTO_INCREMENT," +
	                    "name VARCHAR(50)," +
	                    "branch VARCHAR(30)," +
	                    "percentage DOUBLE)";

	            stmt.executeUpdate(createTable);
	            System.out.println("Table created successfully.");

	            String insertSQL = "INSERT INTO Students(name, branch, percentage) VALUES (?, ?, ?)";
	            PreparedStatement ps = con.prepareStatement(insertSQL);

	            ps.setString(1, "Aman");
	            ps.setString(2, "Computer Science");
	            ps.setDouble(3, 85.6);
	            ps.executeUpdate();

	            ps.setString(1, "Neeraj");
	            ps.setString(2, "Information Technology");
	            ps.setDouble(3, 88.2);
	            ps.executeUpdate();

	            ps.setString(1, "Nikhil");
	            ps.setString(2, "Mechanical");
	            ps.setDouble(3, 79.5);
	            ps.executeUpdate();

	            System.out.println("Records inserted successfully.");

	            con.close();
	            System.out.println("Connection closed.");

	        } catch (ClassNotFoundException e) {
	            System.out.println("JDBC Driver not found.");
	        } catch (SQLException e) {
	            System.out.println("SQL Error: " + e.getMessage());
	        }
	    }
	}

