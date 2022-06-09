package com.sofkamarket.persistence.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "compras_productos")
public class ComprasProductos {

    @EmbeddedId
    private ComprasProductosPK id;

    private Integer cantidad;
    private Integer total;
    private boolean estado;
}
