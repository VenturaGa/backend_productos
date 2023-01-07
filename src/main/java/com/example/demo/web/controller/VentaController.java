package com.example.demo.web.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Venta;
import com.example.demo.service.VentaService;



@RestController
@RequestMapping("/Productos")
public class VentaController {

	@Autowired(required = false)
    private VentaService ventaService;
    
    //listar
	
    @GetMapping("/ventas")
    public List<Venta> listar()
    {
        return ventaService.findAll();
    }
}
