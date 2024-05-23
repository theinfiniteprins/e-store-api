package fproject.fproject.dao;

import fproject.fproject.entity.Sale;

import java.util.List;

public interface SaleDAO {
    Sale save(Sale sale);
    
    Sale findById(Long id);
    
    List<Sale> findAll();
    
    void updateById(Long id, Sale sale);
    
    void delete(Sale sale);
}
