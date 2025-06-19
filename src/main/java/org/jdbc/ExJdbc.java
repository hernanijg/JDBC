package org.jdbc;

import java.sql.*;

import org.jdbc.Util.DatabaseConn;
import org.jdbc.model.Product;
import org.jdbc.repository.ProductRepositoryImpl;
import org.jdbc.repository.Repository;

public class ExJdbc {
    public static void main(String[] args) {

        try (Connection conn = DatabaseConn.getInstance()) {

            Repository<Product> repository = new ProductRepositoryImpl();
            repository.showL().forEach(System.out::println);
            System.out.println(repository.forId(1L));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

