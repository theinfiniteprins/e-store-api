package fproject.fproject.service;

import fproject.fproject.entity.Stock;

import java.util.List;

public interface StockService {
    Stock save(Stock stock);
    
    Stock findById(Long id);
    
    List<Stock> findAll();
    
    Stock updateById(Long id, Stock stock);
    
    void delete(Stock stock);
}
