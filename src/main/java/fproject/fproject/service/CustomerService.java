package fproject.fproject.service;

import fproject.fproject.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    
    Customer findById(Long id);
    
    List<Customer> findAll();
    
    void update(Customer customer);
}
