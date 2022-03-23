package com.luissrojas.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Ventas")
@JsonIgnoreProperties(value={ "Listadetalleventa"})
public class Venta implements  Serializable {
	
	private static final long serialVersionUID = 1167649479984334076L;
	@Id
	@GeneratedValue(strategy = GenerationType .IDENTITY)
	private Long idventa;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date fecha;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name="id")
	private Cliente cliente;
	 
	@Transient
	private Long idcliente;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "venta_id")
	private List<DetalleVenta> Listadetalleventa;
	
	public Venta() {
		Listadetalleventa = new ArrayList<DetalleVenta>();
	}
    
	public Long getIdventa() {
		return idventa;
	}
	

	public void setIdventa(Long idventa) {
		this.idventa = idventa;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public List<DetalleVenta> getListadetalleventa() {
		return Listadetalleventa;
	}

	public void setListadetalleventa(List<DetalleVenta> listadetalleventa) {
		Listadetalleventa = listadetalleventa;
	}
	

	public void addItem(DetalleVenta item) {
		Listadetalleventa.add(item);
	}
	
	public float getTotal() {
		float total = 0;
		for(DetalleVenta detalle: Listadetalleventa) {
			Producto producto = new Producto();
			producto = detalle.getProducto();
			total += detalle.getCantidad() * producto.getPrecio();
		}
		return total;
	}
	
	
	
	
}
