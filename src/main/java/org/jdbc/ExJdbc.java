package org.jdbc;

import java.sql.*;
import java.util.Date;

import org.jdbc.Util.DatabaseConn;
import org.jdbc.model.Product;
import org.jdbc.repository.ProductRepositoryImpl;
import org.jdbc.repository.Repository;

public class ExJdbc {
    public static void main(String[] args) {

        try (Connection conn = DatabaseConn.getInstance()) {

            Repository<Product> repository = new ProductRepositoryImpl();
            System.out.println("=================== Show List ================");
            repository.showL().forEach(System.out::println);

            System.out.println("=================== See Id================");
            System.out.println(repository.forId(1L));

            System.out.println("=================== Show List ================");
            Product p = new Product();
            p.setId(5L);
            p.setName("Keyboard Razer");
            p.setPrice(700);
            p.setRegisterDate(new Date());
            repository.save(p);
            System.out.println("Product Save");
            repository.showL().forEach(System.out::println);

            System.out.println("=================== Delete product ================");
            repository.delete(5L);
            repository.showL().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}