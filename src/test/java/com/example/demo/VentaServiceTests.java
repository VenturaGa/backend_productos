package com.example.demo;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.entity.Venta;
import com.example.demo.repository.VentaDAO;
import com.example.demo.service.VentaService;


public class VentaServiceTests {
	@Mock
	private VentaDAO ventaDao;
	@InjectMocks
	private VentaService service;
	private Venta venta;
	
	@BeforeEach
	public void initVenta() {
		MockitoAnnotations.openMocks(this);
		this.venta = new Venta();
	}
	
	@Test
	void getAllVentaTest() {
		when(ventaDao.findAll()).thenReturn(Arrays.asList(venta));
		assertNotNull(venta);
		
	}
}
