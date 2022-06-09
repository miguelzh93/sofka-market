package com.sofkamarket.domain.service;

import com.sofkamarket.domain.Product;
import com.sofkamarket.domain.repository.ProductRepository;
import com.sofkamarket.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getProductByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Producto save(Product product){
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(pr -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }

}
