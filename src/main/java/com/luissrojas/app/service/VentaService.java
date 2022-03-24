package com.luissrojas.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.luissrojas.app.entity.Cliente;
import com.luissrojas.app.entity.Venta;

public interface VentaService {
	public Iterable<Venta> findAll();
	
	public Page<Venta> findAll(Pageable pageable);
	
	public Optional<Venta> findById(Long idventa);
	
	public Venta save(Venta venta);
	
	public void deleteById(Long idventa);
	
	public Iterable<Venta> BuscarPorFecha(Date fecha);

}
