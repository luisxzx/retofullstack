package com.luissrojas.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luissrojas.app.entity.Cliente;
import com.luissrojas.app.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));

}
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long clienteId){
		Optional<Cliente> oCliente= clienteService.findById(clienteId);
		
		if(!oCliente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oCliente);
}
	@PutMapping("/{id}")
	public ResponseEntity<?>update(@RequestBody Cliente clienteDetails, @PathVariable(value = "id") Long clienteId){
		Optional<Cliente> cliente = clienteService.findById(clienteId);
		if(!cliente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		//BeanUtils.copyProperties(clienteDetails, cliente.get());
		cliente.get().setNombre(clienteDetails.getNombre());
		cliente.get().setApellido(clienteDetails.getApellido());
		cliente.get().setDni(clienteDetails.getDni());
		cliente.get().setEmail(clienteDetails.getEmail());
		cliente.get().setTelefono(clienteDetails.getTelefono());
		cliente.get().setEnabled(clienteDetails.getEnabled());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente.get()));
	}
	
	//Delete an user
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id")Long clienteId){
		if(!clienteService.findById(clienteId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		clienteService.deleteById(clienteId);
		return ResponseEntity.ok().build();
				
	}
	@GetMapping
	public List<Cliente> readAll(){
		
		List<Cliente> clientes= StreamSupport
				.stream(clienteService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return clientes;
	}
	}


