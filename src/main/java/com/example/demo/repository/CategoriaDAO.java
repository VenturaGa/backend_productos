package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.Categoria;

public interface CategoriaDAO extends CrudRepository<Categoria, Integer>{
    
}
