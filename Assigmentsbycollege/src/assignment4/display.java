package assignment4;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class display {

	    public static void main(String[] args) {

	        String url = "jdbc:mysql://localhost:3306/college";
	        String user = "root";
	        String password = "232004";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            Connection con = DriverManager.getConnection(url, user, password);
	            System.out.println("Connected to database.");

	            String selectSQL = "SELECT * FROM Students WHERE semester = ? AND branch = ?";
	            PreparedStatement ps = con.prepareStatement(selectSQL);

	            ps.setInt(1, 7);
	            ps.setString(2, "EC");

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                System.out.println(
	                        rs.getInt("id") + " | " +
	                        rs.getString("name") + " | " +
	                        rs.getString("branch") + " | " +
	                        rs.getDouble("percentage") + " | " +
	                        rs.getInt("semester")
	                );
	            }

	            con.close();

	        } catch (ClassNotFoundException e) {
	            System.out.println("JDBC Driver not found.");
	        } catch (SQLException e) {
	            System.out.println("SQL Error: " + e.getMessage());
	        }
	    }
	}


