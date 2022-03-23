package com.luissrojas.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.luissrojas.app.entity.Cliente;
import com.luissrojas.app.entity.Producto;

public interface ProductoService {
public Iterable<Producto> findAll();
	
	public Page<Producto> findAll(Pageable pageable);
	
	public Optional<Producto> findById(Long idventa);
	
	public Producto save(Producto producto);
	
	public void deleteById(Long idventa);


}
