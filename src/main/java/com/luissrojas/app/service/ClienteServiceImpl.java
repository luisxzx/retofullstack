package com.luissrojas.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luissrojas.app.entity.Cliente;
import com.luissrojas.app.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Cliente> findAll() {
		return clienteRepository.findAll();
		

	}

	@Override
	@Transactional(readOnly=true)
	public Page<Cliente> findAll(Pageable pageable) {
		
		return clienteRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Cliente> findById(Long id) {
		
		return clienteRepository.findById(id);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		
		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		clienteRepository.deleteById(id);
		
	}
	
	
	
}