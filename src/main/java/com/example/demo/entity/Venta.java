package com.example.demo.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ventas")
public class Venta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_venta")
	  private Integer id_venta;
    @Column(name="id_producto")
    	private Integer id_producto;
    @Column(name="catidad")
    	private Integer cantidad;
}
