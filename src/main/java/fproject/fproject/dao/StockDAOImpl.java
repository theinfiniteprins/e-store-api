package fproject.fproject.dao;

import fproject.fproject.entity.Product;
import fproject.fproject.entity.Stock;
import org.springframework.stereotype.Repository;

import jakarta.persistence.*;
import jakarta.transaction.*;

import java.util.List;

@Repository
@Transactional
public class StockDAOImpl implements StockDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Stock save(Stock stock) {
        Stock s = entityManager.merge(stock);
        Product product = stock.getProduct();
        int qty = stock.getQuantity();
        int cqty = product.getQuantity();
        cqty=qty+cqty;
        product.setQuantity(cqty);
        entityManager.merge(product);
        return s;
    }

    @Override
    public Stock findById(Long id) {
        return entityManager.find(Stock.class, id);
    }

    @Override
    public List<Stock> findAll() {
        return entityManager.createQuery("SELECT s FROM Stock s", Stock.class)
                            .getResultList();
    }

    @Override
    public Stock updateById(Long id, Stock stock) {
        Stock existingStock = findById(id);
        if (existingStock != null) {
            stock.setId(existingStock.getId());
            entityManager.merge(stock);
        }
        return existingStock;
    }

    @Override
    public void delete(Stock stock) {
        Product product = stock.getProduct();
        int qty = stock.getQuantity();
        int cqty = product.getQuantity();
        if(cqty>=qty)
        {
	        cqty=cqty-qty;
	        product.setQuantity(qty);
	        entityManager.merge(product);
	        entityManager.remove(stock);
        }
    }
}
