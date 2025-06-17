package org.jdbc.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.jdbc.Util.DatabaseConn;
import org.jdbc.model.Product;

public class ProductRepositoryImpl implements Repository<Product> {

    private Connection getConnection() throws SQLException {
        return DatabaseConn.getInstance();
    }

    @Override
    public List<Product> showL() {
        List<Product> products = new ArrayList<>();
        
        try(Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products")) {
            
            while (rs.next()) {
                Product p = getProduct(rs);
                products.add(p);
            }

        } catch (SQLException e ) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
        return products;
    }
    @Override
    public Product forId(Long id) {
        Product product = null;

        try (   PreparedStatement stmt = getConnection()
                .prepareStatement("SELECT * FROM products WHERE id = ?" )){

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                product = getProduct(rs);
            }

            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public void save(Product t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


    private static Product getProduct(ResultSet rs) throws SQLException {
        Product p = new Product();
        p.setId(rs.getLong("id"));
        p.setName(rs.getString("name"));
        p.setPrice(rs.getInt("price"));
        p.setRegisterDate(rs.getDate("register_date"));
        return p;
    }
    
}
