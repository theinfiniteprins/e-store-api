package fproject.fproject.controller;

import fproject.fproject.entity.Product;
import fproject.fproject.entity.Stock;
import fproject.fproject.service.ProductService;
import fproject.fproject.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockService stockService;
    private ProductService productService;

    public StockController(StockService stockService, ProductService productService) {
        this.stockService = stockService;
        this.productService = productService;
    }
    
    @PostMapping
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
    	Product product = productService.findById(stock.getProduct().getId());
    	stock.setProduct(product);
        Stock savedStock = stockService.save(stock);
        return new ResponseEntity<>(savedStock, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Stock>> getAllStock() {
        List<Stock> stockList = stockService.findAll();
        return new ResponseEntity<>(stockList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long id, @RequestBody Stock stock) {
        Stock existingStock = stockService.findById(id);
        if (existingStock != null) {
            stock.setId(id);
            Stock updatedStock = stockService.updateById(id,stock);
            return new ResponseEntity<>(updatedStock, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        Stock existingStock = stockService.findById(id);
        if (existingStock != null) {
            stockService.delete(existingStock);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
