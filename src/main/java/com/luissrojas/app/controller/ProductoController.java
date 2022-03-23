package com.luissrojas.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
import com.luissrojas.app.entity.Producto;
import com.luissrojas.app.service.ClienteService;
import com.luissrojas.app.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	@Autowired
	private ProductoService productoService;
	
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Producto producto){
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));

}
	@GetMapping("/{idproducto}")
	public ResponseEntity<?> read(@PathVariable(value = "idproducto") Long productoid){
		Optional<Producto> oProducto= productoService.findById(productoid);
		
		if(!oProducto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oProducto);
}
	@PutMapping("/{idproducto}")
	public ResponseEntity<?>update(@RequestBody Producto productoDetails, @PathVariable(value = "id") Long productoid){
		Optional<Producto> producto = productoService.findById(productoid);
		if(!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		//BeanUtils.copyProperties(clienteDetails, cliente.get());
		producto.get().setNombreproducto(productoDetails.getNombreproducto());
		producto.get().setPrecio(productoDetails.getPrecio());
	
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto.get()));
	}
	
	//Delete an user
	
	@DeleteMapping("/{idproducto}")
	public ResponseEntity<?> delete(@PathVariable(value = "idproducto")Long productoid){
		if(!productoService.findById(productoid).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		productoService.deleteById(productoid);
		return ResponseEntity.ok().build();
				
	}
	@GetMapping
	public List<Producto> readAll(){
		
		List<Producto> productos= StreamSupport
				.stream(productoService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return productos;
	}

}
