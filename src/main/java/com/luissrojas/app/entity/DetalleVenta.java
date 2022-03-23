package com.luissrojas.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "detalleventas")
public class DetalleVenta implements Serializable {
	
	private static final long serialVersionUID = 5384185129863475962L;

	@Id
	@GeneratedValue(strategy = GenerationType .IDENTITY)
	private Long iddetalleventa;

	@ManyToOne
	@JoinColumn(name="idproducto")
	private Producto producto;
	
	private Integer cantidad;
	
	
	@Transient
	private Long idproduct;

	public Long getIddetalleventa() {
		return iddetalleventa;
	}

	public void setIddetalleventa(Long iddetalleventa) {
		this.iddetalleventa = iddetalleventa;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}



	public Long getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(Long idproduct) {
		this.idproduct = idproduct;
	}

	

	
	
	
	
	

}
