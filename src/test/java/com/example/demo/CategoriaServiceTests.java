package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.entity.Categoria;
import com.example.demo.repository.CategoriaDAO;
import com.example.demo.service.CategoriaService;


public class CategoriaServiceTests {
	@Mock
	private CategoriaDAO categoriaDao;
	
	@InjectMocks
	private CategoriaService service;
	private Categoria categoria;

	
	@BeforeEach
	public void initCategoria() {
		MockitoAnnotations.openMocks(this);
		this.categoria = new Categoria();
		this.categoria.setNombre_categoria("nombre");
		this.categoria.setDescripcion("descripcion");
	}
	
	@Test
	void getAllCategoriaTest() {
		when(categoriaDao.findAll()).thenReturn(Arrays.asList(categoria));
		assertNotNull(categoria);
		
		
	}
	
	void getCategoriaByIdTest() {
		when(this.categoriaDao.findById(any(Integer.class))).thenReturn(Optional.of(categoria));
		Categoria categoria  = this.service.findById(1);
		assertNotNull(categoria);
		assertEquals(this.categoria, categoria);
	}
	
	@Test
	void saveCategoriaTest() {
		when(categoriaDao.save(any(Categoria.class))).thenReturn(categoria);
		Categoria categoria = new Categoria();
		categoria.setNombre_categoria("Nombre dos");
		Categoria categoriaNueva  = this.service.save(categoria);
		assertEquals(this.categoria, categoriaNueva);
	}
	
	@Test
	void deleteProductoTest() {
		doNothing().when(this.categoriaDao).deleteById(any());
		this.service.delete(1);
	}
}
