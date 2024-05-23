package fproject.fproject.dao;

import fproject.fproject.entity.Product;
import fproject.fproject.entity.Sale;
import org.springframework.stereotype.Repository;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SaleDAOImpl implements SaleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Sale save(Sale sale) {
        Product product = sale.getProduct();
        int qty = sale.getQuantity();
        int cqty = product.getQuantity();
        
        if (qty > cqty) {
            throw new IllegalArgumentException("Quantity to be sold is greater than the available quantity.");
        }
        
        int updatedQty = cqty - qty;
        product.setQuantity(updatedQty);
        entityManager.merge(product);
        entityManager.persist(sale);
        return sale;
    }


    @Override
    public Sale findById(Long id) {
        return entityManager.find(Sale.class, id);
    }

    @Override
    public List<Sale> findAll() {
        return entityManager.createQuery("SELECT s FROM Sale s", Sale.class)
                            .getResultList();
    }

    @Override
    public void updateById(Long id, Sale sale) {
        Sale existingSale = findById(id);
        if (existingSale != null) {
            sale.setId(existingSale.getId());
            entityManager.merge(sale);
        }
    }

    @Override
    public void delete(Sale sale) {
        entityManager.remove(sale);
    }
}
