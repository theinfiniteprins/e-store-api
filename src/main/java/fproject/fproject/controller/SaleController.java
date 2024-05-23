package fproject.fproject.controller;

import fproject.fproject.entity.Product;
import fproject.fproject.entity.Sale;
import fproject.fproject.service.ProductService;
import fproject.fproject.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;
    private ProductService productService;

    public SaleController(SaleService saleService, ProductService productService) {
        this.saleService = saleService;
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Sale> addSale(@RequestBody Sale sale) {
    	Product product = productService.findById(sale.getProduct().getId());
    	sale.setProduct(product);
        Sale savedSale = saleService.save(sale);
        return new ResponseEntity<>(savedSale, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        List<Sale> saleList = saleService.findAll();
        return new ResponseEntity<>(saleList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Long id) {
        Sale sale = saleService.findById(id);
        if (sale != null) {
            return new ResponseEntity<>(sale, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public void updateSale(@PathVariable Long id, @RequestBody Sale sale) {
          saleService.updateById(id,sale);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        Sale existingSale = saleService.findById(id);
        if (existingSale != null) {
            saleService.delete(existingSale);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
