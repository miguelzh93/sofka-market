package com.sofkamarket.persistence;

import com.sofkamarket.domain.Product;
import com.sofkamarket.domain.repository.ProductRepository;
import com.sofkamarket.persistence.crud.ProductoCrudRepository;
import com.sofkamarket.persistence.entity.Producto;

import com.sofkamarket.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;
    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Optional<List<Product>> getProductsByName(String name) {
        Optional<List<Producto>> productName =  productoCrudRepository.findByNombreLike(name);
        return productName.map(poName -> mapper.toProducts(poName));
    }
    @Override
    public Product save(Product product){
        return mapper.toProduct(productoCrudRepository.save(mapper.toProducto(product)));
    }
    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }


}
