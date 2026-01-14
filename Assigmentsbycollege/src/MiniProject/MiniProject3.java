package managementsystem;

import java.sql.*;
import java.util.*;

public class MiniProject3 {

    static class ValidationException extends Exception {
        ValidationException(String msg) { super(msg); }
    }

    static final String URL = "jdbc:mysql://localhost:3306/colleges";
    static final String USER = "root";
    static final String PASS = "232004";

    static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }

    static boolean login(String u, String p) throws Exception {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
        ps.setString(1, u);
        ps.setString(2, p);
        ResultSet rs = ps.executeQuery();
        boolean ok = rs.next();
        con.close();
        return ok;
    }

    static void addStudent(Scanner sc) throws Exception {
        System.out.print("Eno: ");
        int eno = sc.nextInt();
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Branch: ");
        String branch = sc.next();
        System.out.print("Sem: ");
        int sem = sc.nextInt();
        System.out.print("Percentage: ");
        double per = sc.nextDouble();

        if (branch.isEmpty()) throw new ValidationException("Branch cannot be empty");
        if (sem <= 0) throw new ValidationException("Semester must be positive");
        if (per < 0) throw new ValidationException("Percentage must be positive");

        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO students VALUES (?,?,?,?,?)");
        ps.setInt(1, eno);
        ps.setString(2, name);
        ps.setString(3, branch);
        ps.setInt(4, sem);
        ps.setDouble(5, per);
        ps.executeUpdate();
        con.close();

        System.out.println("Student Added");
    }

    static void displayAll() throws Exception {
        Connection con = getConnection();
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM students");
        while (rs.next())
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getDouble(5));
        con.close();
    }

    static void search(int eno) throws Exception {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE eno=?");
        ps.setInt(1, eno);
        ResultSet rs = ps.executeQuery();
        if (rs.next())
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getDouble(5));
        else System.out.println("Student not found");
        con.close();
    }

    static void update(int eno, String branch) throws Exception {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE students SET branch=? WHERE eno=?");
        ps.setString(1, branch);
        ps.setInt(2, eno);
        ps.executeUpdate();
        con.close();
        System.out.println("Updated");
    }

    static void delete(int eno) throws Exception {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE eno=?");
        ps.setInt(1, eno);
        ps.executeUpdate();
        con.close();
        System.out.println("Deleted");
    }

    static void sorted() throws Exception {
        Connection con = getConnection();
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM students ORDER BY percentage DESC");
        while (rs.next())
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getDouble(5));
        con.close();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Username: ");
            String u = sc.next();
            System.out.print("Password: ");
            String p = sc.next();

            if (!login(u, p)) {
                System.out.println("Invalid Login");
                return;
            }

            while (true) {
                System.out.println("\n1.Add 2.Display 3.Search 4.Update 5.Delete 6.Sort 7.Exit");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1 -> addStudent(sc);
                    case 2 -> displayAll();
                    case 3 -> { System.out.print("Eno: "); search(sc.nextInt()); }
                    case 4 -> {
                        System.out.print("Eno: ");
                        int e = sc.nextInt();
                        System.out.print("Branch: ");
                        update(e, sc.next());
                    }
                    case 5 -> { System.out.print("Eno: "); delete(sc.nextInt()); }
                    case 6 -> sorted();
                    case 7 -> System.exit(0);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
