package org.jdbc;

import java.sql.*;
import java.util.Date;

import org.jdbc.Util.DatabaseConn;
import org.jdbc.model.Product;
import org.jdbc.repository.ProductRepositoryImpl;
import org.jdbc.repository.Repository;

public class ExJdbcTrx {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = DatabaseConn.getInstance()) {
            if(conn.getAutoCommit())
                conn.setAutoCommit(false);
            try {
                Repository<Product> repository = new ProductRepositoryImpl();
                System.out.println("=================== Show List ================");
                repository.showL().forEach(System.out::println);

                System.out.println("=================== See Id================");
                System.out.println(repository.forId(1L));

                System.out.println("=================== Show List ================");
                Product p = new Product();
                //p.setId(5L);
                p.setName("Keyboard IBM Razer");
                p.setPrice(1000);
                p.setRegisterDate(new Date());
                p.setSku("ab12345");
                repository.save(p);
                System.out.println("Product Save");
                repository.showL().forEach(System.out::println);

                System.out.println("=================== Show List ================");
                Product p2 = new Product();
                //p.setId(5L);
                p2.setName("Keyboard IBM Razer 2.0");
                p2.setPrice(1200);
                p2.setRegisterDate(new Date());
                p2.setSku("abc11343");
                repository.save(p2);

                System.out.println("Product Save");
                repository.showL().forEach(System.out::println);

                //System.out.println("=================== Delete product ================");
                //repository.delete(5L);
                //repository.showL().forEach(System.out::println);

                conn.commit();
            }
            catch (SQLException e){
                // Transaction METHOD
                conn.rollback();
                e.printStackTrace();
            }
        }
    }
}