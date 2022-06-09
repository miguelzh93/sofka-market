package com.sofkamarket.persistence.crud;

import com.sofkamarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria );
    Optional<List<Producto>> findByCantidadStockLessLessThanAndEstado(int cantidadStock, boolean estado);
    Optional<List<Producto>> findByNombreLike(int nombre);
}