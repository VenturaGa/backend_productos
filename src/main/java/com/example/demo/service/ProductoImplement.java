package com.example.demo.service;

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoDAO;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoImplement  implements ProductoService{
    @Autowired
    private ProductoDAO productoDao;

	@Override
    @Transactional(readOnly=true)
	public List<Producto> findAll() {
        return (List<Producto>) productoDao.findAll();

	}

	@Override
    @Transactional(readOnly=false)
	public Producto save(Producto producto) {
		return productoDao.save(producto);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Producto findById(Integer id_producto) {
		 return productoDao.findById(id_producto).orElse(null);
	}

	@Override
    @Transactional(readOnly=false)
	public void delete(Integer id_producto) {
		// TODO Auto-generated method stub
        productoDao.deleteById(id_producto);

	}
    
    

	
    
}