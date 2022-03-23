package com.luissrojas.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luissrojas.app.entity.Cliente;
import com.luissrojas.app.entity.Venta;
import com.luissrojas.app.repository.ClienteRepository;
import com.luissrojas.app.repository.VentaRepository;

@Service
public class VentaServiceImpl implements VentaService {
	
	@Autowired
	private VentaRepository ventaRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Venta> findAll() {
		
		return ventaRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Venta> findAll(Pageable pageable) {
		
		return ventaRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Venta> findById(Long idventa){
		return ventaRepository.findById(idventa);
	}

	@Override
	@Transactional
	public Venta save(Venta venta) {
		
		return ventaRepository.save(venta);
	}

	@Override
	@Transactional
	public void deleteById(Long idventa) {
		ventaRepository.deleteById(idventa);
		
	}

	
	


	

}
