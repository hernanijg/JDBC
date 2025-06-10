package org.jdbc.repository;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                Product p = new Product();
                p.setId(rs.getLong("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getInt("price"));
                p.setRegisterDate(rs.getDate("register_date"));
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'forId'");
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
    
}
