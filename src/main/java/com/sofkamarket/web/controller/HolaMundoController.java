package com.sofkamarket.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class HolaMundoController {


    @GetMapping("/v1")
    public String saludar() {
        return "Hola Mundo";
    }

}
