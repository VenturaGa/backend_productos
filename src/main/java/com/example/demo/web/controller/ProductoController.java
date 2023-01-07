package com.example.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Producto;
import com.example.demo.service.ProductoService;

@RestController

@RequestMapping("/Productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    
    //listar
    @GetMapping("/productos")
    public List<Producto> listar()
    {
        return productoService.findAll();
    }
    
    //guardar
    @PostMapping("/productos")
    public  Producto guardar(@RequestBody Producto producto)
    {
        return productoService.save(producto);
    }
    
    //get un Producto
    @GetMapping("/productos/{id}")
    public Producto getUnProducto(@PathVariable Integer id_producto)
    {
        return productoService.findById(id_producto);
    }
    
    //Modeficar
    @PutMapping("/productos/{id}")
    public Producto modifecar(@RequestBody Producto producto,@PathVariable Integer id_producto)
    {
        Producto productoActual= productoService.findById(id_producto);
        productoActual.setNombre_producto(producto.getNombre_producto());
        
        return productoService.save(productoActual);
    }
    
    @DeleteMapping("/productos/{id}")
    public void eliminar(@PathVariable Integer id_producto)
    {
        productoService.delete(id_producto);
    }
}