package com.sofkamarket.persistence;

import com.sofkamarket.domain.Product;
import com.sofkamarket.domain.repository.ProductRepository;
import com.sofkamarket.persistence.crud.ProductoCrudRepository;
import com.sofkamarket.persistence.entity.Producto;
import com.sofkamarket.persistence.mapper.ProducMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProductoRepository implements ProductRepository {
    private ProductoCrudRepository productoCrudRepository;
    private ProducMapper mapper;
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
    public Optional<List<Product>> getScarseProducts(int quantity, boolean status) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessLessThanAndEstado(quantity, status);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Optional<List<Product>> getProductsByName(int name) {
        Optional<List<Producto>> productName =  productoCrudRepository.findByNombreLike(name);
        return productName.map(poName -> mapper.toProducts(poName));
    }
    @Override
    public Producto save(Product product){
        return productoCrudRepository.save(mapper.toProducto(product));
    }
    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }


}
