package fproject.fproject.service;

import fproject.fproject.dao.SupplierDAO;
import fproject.fproject.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierDAO supplierDAO;

    @Autowired
    public SupplierServiceImpl(SupplierDAO supplierDAO) {
        this.supplierDAO = supplierDAO;
    }

    @Override
    @Transactional
    public Supplier save(Supplier supplier) {
        return supplierDAO.save(supplier);
    }

    @Override
    @Transactional
    public Supplier findById(Long id) {
        return supplierDAO.findById(id);
    }

    @Override
    @Transactional
    public List<Supplier> findAll() {
        return supplierDAO.findAll();
    }

    @Override
    @Transactional
    public void update(Supplier supplier) {
        supplierDAO.update(supplier);
    }
}
