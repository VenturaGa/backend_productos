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

import com.example.demo.entity.Categoria;
import com.example.demo.service.CategoriaService;

@RestController

@RequestMapping("/Productos")
public class CategoriaController {
	@Autowired(required = false)
    private CategoriaService categoriaService;
    
    //listar
    @GetMapping("/categorias")
    public List<Categoria> listar()
    {
        return categoriaService.findAll();
    }
    
  //guardar
    @PostMapping("/categorias")
    public  Categoria guardar(@RequestBody Categoria categoria)
    {
        return categoriaService.save(categoria);
    }
    
    //get una tarea
    @GetMapping("/categorias/{id}")
    public Categoria getUnaCategoria(@PathVariable Integer id_categoria)
    {
        return categoriaService.findById(id_categoria);
    }
    
    //Modeficar
    @PutMapping("/categorias/{id}")
    public Categoria modifecar(@RequestBody Categoria categoria,@PathVariable Integer id_categoria)
    {
        Categoria categoriaActual= categoriaService.findById(id_categoria);
        categoriaActual.setNombre_categoria(categoria.getNombre_categoria());
        categoriaActual.setDescripcion(categoria.getDescripcion());
        
        return categoriaService.save(categoriaActual);
    }
    
    @DeleteMapping("/categorias/{id}")
    public void eliminar(@PathVariable Integer id_categoria)
    {
        categoriaService.delete(id_categoria);
    }
}