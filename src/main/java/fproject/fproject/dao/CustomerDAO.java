package fproject.fproject.dao;

import fproject.fproject.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    Customer save(Customer customer);

    Customer findById(Long id);

    List<Customer> findAll();

    void update(Customer customer);
}
