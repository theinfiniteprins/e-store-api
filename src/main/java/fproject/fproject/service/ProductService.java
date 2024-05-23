package fproject.fproject.service;

import fproject.fproject.entity.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    
    Product findById(Long id);
    
    List<Product> findAll();
    
    Product update(Product product);
    
    void delete(Product product);
}
