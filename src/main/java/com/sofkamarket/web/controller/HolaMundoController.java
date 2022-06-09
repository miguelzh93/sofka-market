package com.sofkamarket.web.controller;

import com.sofkamarket.persistence.ProductRepository;
import com.sofkamarket.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/base")
public class HolaMundoController {


    @GetMapping("/v1")
    public String saludar() {
        return "Hola Mundo";
    }

    /*@GetMapping("/v2")
    public List<Producto> getAllProductos() {

        return p.getAll();
    }*/
}
