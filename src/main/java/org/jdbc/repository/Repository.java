package org.jdbc.repository;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
    List<T> showL() throws SQLException;
    
    T forId(Long id) throws SQLException;
    
    void save(T t) throws SQLException;
    void delete(Long id) throws SQLException;
}
