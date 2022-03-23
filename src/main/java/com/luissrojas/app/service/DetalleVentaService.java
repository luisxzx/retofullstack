package com.luissrojas.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.luissrojas.app.entity.DetalleVenta;
import com.luissrojas.app.entity.Venta;

public interface DetalleVentaService {
	
public Iterable<DetalleVenta> findAll();
	
	public Page<DetalleVenta> findAll(Pageable pageable);
	
	public Optional<DetalleVenta> findById(Long iddetalleventa);
	
	public DetalleVenta save(DetalleVenta detalleVenta);
	
	public void deleteById(Long iddetalleventa);

}
