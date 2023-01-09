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

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoDAO;
import com.example.demo.service.ProductoService;


public class ProductoServiceTests {
	@Mock
	private ProductoDAO productoDao;
	
	@InjectMocks
	private ProductoService service;
	private Producto producto;

	
	@BeforeEach
	public void initProducto() {
		MockitoAnnotations.openMocks(this);
		this.producto = new Producto();
		this.producto.setNombre_producto("nombre");
		
	}
	
	@Test
	void getAllProductosTest() {
		when(productoDao.findAll()).thenReturn(Arrays.asList(producto));
		assertNotNull(producto);
		
		
	}
	
	void getProductoByIdTest() {
		when(this.productoDao.findById(any(Integer.class))).thenReturn(Optional.of(producto));
		Producto producto  = this.service.findById(1);
		assertNotNull(producto);
		assertEquals(this.producto, producto);
	}
	
	@Test
	void saveProductoTest() {
		when(productoDao.save(any(Producto.class))).thenReturn(producto);
		Producto producto = new Producto();
		producto.setNombre_producto("Nombre dos");
		Producto productoNuevo  = this.service.save(producto);
		assertEquals(this.producto, productoNuevo);
	}
	
	@Test
	void deleteProductoTest() {
		doNothing().when(this.productoDao).deleteById(any());
		this.service.delete(1);
	}
}
