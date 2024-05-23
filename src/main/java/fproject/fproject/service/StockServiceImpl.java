package fproject.fproject.service;

import fproject.fproject.dao.StockDAO;
import fproject.fproject.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final StockDAO stockDAO;

    @Autowired
    public StockServiceImpl(StockDAO stockDAO) {
        this.stockDAO = stockDAO;
    }

    @Override
    @Transactional
    public Stock save(Stock stock) {
        return stockDAO.save(stock);
    }

    @Override
    @Transactional(readOnly = true)
    public Stock findById(Long id) {
        return stockDAO.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Stock> findAll() {
        return stockDAO.findAll();
    }

    @Override
    @Transactional
    public Stock updateById(Long id, Stock stock) {
        return stockDAO.updateById(id, stock);
    }

    @Override
    @Transactional
    public void delete(Stock stock) {
        stockDAO.delete(stock);
    }
}
