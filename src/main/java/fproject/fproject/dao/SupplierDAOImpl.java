package fproject.fproject.dao;

import fproject.fproject.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import java.util.List;

@Repository
public class SupplierDAOImpl implements SupplierDAO {

    private final EntityManager entityManager;

    @Autowired
    public SupplierDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Supplier save(Supplier supplier) {
        return entityManager.merge(supplier);
    }

    @Override
    public Supplier findById(Long id) {
        return entityManager.find(Supplier.class, id);
    }

    @Override
    public List<Supplier> findAll() {
        return entityManager.createQuery("SELECT s FROM Supplier s", Supplier.class)
                            .getResultList();
    }

    @Override
    public void update(Supplier supplier) {
        entityManager.merge(supplier);
    }
}
