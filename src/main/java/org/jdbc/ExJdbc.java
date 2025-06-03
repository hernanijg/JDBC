package org.jdbc;

import java.sql.*;

public class ExJdbc {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java_course?serverTimezone=UTC";
        String username = "root";
        String password = "caca";

        try (Connection conn = DriverManager.getConnection(url, username, password);
                Statement stmt = conn.createStatement();
                ResultSet r = stmt.executeQuery("SELECT * FROM products")) {

            while (r.next()) {
                System.out.print(r.getInt("id"));
                System.out.print(" | ");
                System.out.print(r.getString("name"));
                System.out.print(" | ");
                System.out.print(r.getInt("price"));
                System.out.print(" | ");
                System.out.println(r.getDate("register_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
