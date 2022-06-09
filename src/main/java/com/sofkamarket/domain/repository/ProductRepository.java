package com.sofkamarket.domain.repository;

import com.sofkamarket.domain.Product;
import com.sofkamarket.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Optional<List<Product>> getProductsByName(String name);
    Product save(Product product);
    void delete(int productId);


}
