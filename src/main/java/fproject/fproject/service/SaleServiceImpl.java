package fproject.fproject.service;

import fproject.fproject.dao.SaleDAO;
import fproject.fproject.entity.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleDAO saleDAO;

    @Autowired
    public SaleServiceImpl(SaleDAO saleDAO) {
        this.saleDAO = saleDAO;
    }

    @Override
    @Transactional
    public Sale save(Sale sale) {
        return saleDAO.save(sale);
    }

    @Override
    @Transactional(readOnly = true)
    public Sale findById(Long id) {
        return saleDAO.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sale> findAll() {
        return saleDAO.findAll();
    }

    @Override
    @Transactional
    public void updateById(Long id, Sale sale) {
        saleDAO.updateById(id, sale);
    }

    @Override
    @Transactional
    public void delete(Sale sale) {
        saleDAO.delete(sale);
    }
}
