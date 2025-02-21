package com.fiap.g5.msproduct.controller;

import com.fiap.g5.msproduct.controller.json.ProductJson;
import com.fiap.g5.msproduct.domain.Product;
import com.fiap.g5.msproduct.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final FindAllProductsUseCase findAllProductsUseCase;
    private final FindProductByIdUseCase findProductByIdUseCase;
    private final CreateProductUseCase createProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final IncrementStockUseCase incrementStockUseCase;
    private final DecrementStockUseCase decrementStockUseCase;

    @GetMapping
    public List<ProductJson> listAll() {
        return findAllProductsUseCase.execute()
                .stream()
                .map(ProductJson::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductJson> getById(@PathVariable Long id) {
        Product product = findProductByIdUseCase.execute(id);
        return ResponseEntity.ok(new ProductJson(product));
    }

    @PostMapping
    public ResponseEntity<ProductJson> create(@RequestBody Product product) {
        Product created = createProductUseCase.execute(product);
        return ResponseEntity.ok(new ProductJson(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductJson> update(
            @PathVariable Long id,
            @RequestBody Product product
    ) {
        Product updated = updateProductUseCase.execute(id, product);
        return ResponseEntity.ok(new ProductJson(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteProductUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/stock/increment")
    public ResponseEntity<ProductJson> incrementStock(
            @PathVariable Long id,
            @RequestParam("quantity") int quantity
    ) {
        Product updated = incrementStockUseCase.execute(id, quantity);
        return ResponseEntity.ok(new ProductJson(updated));
    }

    @PatchMapping("/{id}/stock/decrement")
    public ResponseEntity<ProductJson> decrementStock(
            @PathVariable Long id,
            @RequestParam("quantity") int quantity
    ) {
        Product updated = decrementStockUseCase.execute(id, quantity);
        return ResponseEntity.ok(new ProductJson(updated));
    }
}
