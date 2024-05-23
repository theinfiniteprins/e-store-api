package fproject.fproject.dao;

import fproject.fproject.entity.Stock;

import java.util.List;

public interface StockDAO {
    Stock save(Stock stock);

    Stock findById(Long id);

    List<Stock> findAll();

    Stock updateById(Long id, Stock stock);

    void delete(Stock stock);
}
