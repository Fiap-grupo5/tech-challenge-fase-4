package com.fiap.g5.msproduct.controller;

import com.fiap.g5.msproduct.domain.Product;
import com.fiap.g5.msproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> listAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product created = productService.create(product);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
            @PathVariable Long id,
            @RequestBody Product product
    ) {
        Product updated = productService.update(id, product);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/stock/increment")
    public ResponseEntity<Product> incrementStock(
            @PathVariable Long id,
            @RequestParam("quantity") int quantity
    ) {
        Product updated = productService.incrementStock(id, quantity);
        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}/stock/decrement")
    public ResponseEntity<Product> decrementStock(
            @PathVariable Long id,
            @RequestParam("quantity") int quantity
    ) {
        Product updated = productService.decrementStock(id, quantity);
        return ResponseEntity.ok(updated);
    }
}
