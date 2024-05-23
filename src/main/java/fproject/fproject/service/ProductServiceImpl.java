package fproject.fproject.service;

import fproject.fproject.dao.ProductDAO;
import fproject.fproject.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    

    @Override
    @Transactional
    public Product save(Product product) {
        return productDAO.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productDAO.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    @Transactional
    public Product update(Product product) {
        return productDAO.update(product);
    }

    @Override
    @Transactional
    public void delete(Product product) {
        productDAO.delete(product);
    }
}
