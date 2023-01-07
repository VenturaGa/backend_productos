package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Venta;

import com.example.demo.repository.VentaDAO;

@Service
public class VentaImplement implements VentaService {
	 @Autowired
	  private VentaDAO ventaDao;
	@Override
	@Transactional(readOnly=true)
	public List<Venta> findAll() {
		// TODO Auto-generated method stub
		return (List<Venta>) ventaDao.findAll();
	}

}
