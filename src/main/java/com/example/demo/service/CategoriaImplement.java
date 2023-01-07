package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Categoria;
import com.example.demo.repository.CategoriaDAO;


public class CategoriaImplement implements CategoriaService {
	  @Autowired
	  private CategoriaDAO categoriaDao;
	@Override
	@Transactional(readOnly=true)
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return (List<Categoria>) categoriaDao.findAll();

	}

	@Override
	@Transactional(readOnly=false)
	public Categoria save(Categoria categoria) {
		// TODO Auto-generated method stub
		return categoriaDao.save(categoria);
	}

	@Override
	@Transactional(readOnly=true)
	public Categoria findById(Integer id_categoria) {
		// TODO Auto-generated method stub
		 return categoriaDao.findById(id_categoria).orElse(null);

	}

	@Override
	@Transactional(readOnly=false)
	public void delete(Integer id_categoria) {
		 categoriaDao.deleteById(id_categoria);
		
	}

}
