package fproject.fproject.dao;

import fproject.fproject.entity.Supplier;

import java.util.List;

public interface SupplierDAO {
    Supplier save(Supplier supplier);

    Supplier findById(Long id);

    List<Supplier> findAll();

    void update(Supplier supplier);
}
