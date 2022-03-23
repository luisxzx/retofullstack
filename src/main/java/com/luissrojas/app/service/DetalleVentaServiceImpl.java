package com.luissrojas.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luissrojas.app.entity.DetalleVenta;
import com.luissrojas.app.entity.Venta;
import com.luissrojas.app.repository.ClienteRepository;
import com.luissrojas.app.repository.DetalleVentaRepository;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {
	@Autowired
	private DetalleVentaRepository detalleventaRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<DetalleVenta> findAll() {
		
		return detalleventaRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<DetalleVenta> findAll(Pageable pageable) {
		
		return detalleventaRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<DetalleVenta> findById(Long iddetalleventa) {
		
		return detalleventaRepository.findById(iddetalleventa);
	}

	@Override
	@Transactional
	public DetalleVenta save(DetalleVenta detalleVenta) {
		
		return detalleventaRepository.save(detalleVenta);
	}

	@Override
	@Transactional
	public void deleteById(Long iddetalleventa) {
		detalleventaRepository.deleteById(iddetalleventa);
		
	}

	

}
