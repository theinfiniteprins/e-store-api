package fproject.fproject.dao;

import fproject.fproject.entity.Product;

import java.util.List;

public interface ProductDAO {
    Product save(Product product);
    
    Product findById(Long id);
    
    List<Product> findAll();
    
    Product update(Product product);
    
    void delete(Product product);
}
