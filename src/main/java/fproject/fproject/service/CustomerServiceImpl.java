package fproject.fproject.service;

import fproject.fproject.dao.CustomerDAO;
import fproject.fproject.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public Customer save(Customer customer) {
        return customerDAO.save(customer);
    }

    @Override
    @Transactional
    public Customer findById(Long id) {
        return customerDAO.findById(id);
    }

    @Override
    @Transactional
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Override
    @Transactional
    public void update(Customer customer) {
        customerDAO.update(customer);
    }
}
