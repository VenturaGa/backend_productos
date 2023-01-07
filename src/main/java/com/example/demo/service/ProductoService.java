package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.Producto;
public interface ProductoService {
	public List<Producto> findAll();
    public Producto save(Producto producto);
    public Producto findById(Integer  id);
    public void delete(Integer id);
}
