package fproject.fproject.service;

import fproject.fproject.entity.Supplier;

import java.util.List;

public interface SupplierService {
    Supplier save(Supplier supplier);
    
    Supplier findById(Long id);
    
    List<Supplier> findAll();
    
    void update(Supplier supplier);
}
