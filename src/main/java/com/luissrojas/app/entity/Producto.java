package com.luissrojas.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Productos")
public class Producto implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 494832234043404052L;
	
	@Id
	@GeneratedValue(strategy = GenerationType .IDENTITY)
	private Long idproducto;
	@Column(length = 50)
	private String nombreproducto;
	
	private float precio;

	public Long getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Long idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	

}
