package org.jdbc;

import java.sql.*;

import org.jdbc.Util.DatabaseConn;

public class ExJdbc {
    public static void main(String[] args) {

        try (Connection conn = DatabaseConn.getInstance();
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
