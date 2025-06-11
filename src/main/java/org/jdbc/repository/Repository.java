package org.jdbc.repository;

import java.util.List;

public interface Repository<T> {
    List<T> showL();
    
    T forId(Long id);
    
    void save(T t);

    void delete(Long id);
}
