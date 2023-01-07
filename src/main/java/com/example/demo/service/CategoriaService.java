package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Categoria;

public interface CategoriaService {
	public List<Categoria> findAll();
    public Categoria save(Categoria categoria);
    public Categoria findById(Integer  id_categoria);
    public void delete(Integer id_categoria);
}
