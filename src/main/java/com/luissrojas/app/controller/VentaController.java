package com.luissrojas.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.luissrojas.app.entity.Cliente;
import com.luissrojas.app.entity.DetalleVenta;
import com.luissrojas.app.entity.Producto;
import com.luissrojas.app.entity.Venta;
import com.luissrojas.app.service.ClienteService;
import com.luissrojas.app.service.DetalleVentaService;
import com.luissrojas.app.service.ProductoService;
import com.luissrojas.app.service.VentaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ventas")
public class VentaController {
	@Autowired
	private VentaService ventaService;
	
	@Autowired
	private DetalleVentaService detalleVentaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	public List<Venta> readAll(){
		
		List<Venta> ventas= StreamSupport
				.stream(ventaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return ventas;
	}
	
	
	@PostMapping(path = "/crear",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody Venta venta){
		
		List<DetalleVenta> lista = new ArrayList<DetalleVenta>(venta.getListadetalleventa());
		Cliente cliente = clienteService.findById(venta.getIdcliente()).get();
		venta.setCliente(cliente);
		List<DetalleVenta> nlista = new ArrayList<DetalleVenta>();
		     if  (lista.size()> 0){
			 for(DetalleVenta detalleventa:lista){
	        	 Producto producto =  productoService.findById(detalleventa.getIdproduct()).get();
	        	 DetalleVenta nuevodetalleVenta = new DetalleVenta();
	        	 nuevodetalleVenta.setProducto(producto);
	        	 nuevodetalleVenta.setCantidad(detalleventa.getCantidad());
	        	 nlista.add(nuevodetalleVenta);
	        	
			 
		 }
			 venta.setListadetalleventa(nlista);
         }
         
		return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.save(venta));
		

}
	@GetMapping("/{idventa}")
	public ResponseEntity<?> read(@PathVariable(value = "idventa") Long ventaId){
		Optional<Venta> oVenta= ventaService.findById(ventaId);
		
		if(!oVenta.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oVenta.get());
}
	
	
	
	@PostMapping("/fecha")
	@ResponseBody
	public Map<String, String>  fech(@RequestBody  Map<String, String> payload )  {
		//Date sellDate = new SimpleDateFormat("yyyy-MM-dd").parse(payload.get("fecha"));
		//List<Venta> ventas= StreamSupport
			//	.stream(ventaService.BuscarPorFecha(sellDate).spliterator(), false)
				//.collect(Collectors.toList());
		return payload;
}
	
	@PutMapping("/{idventa}")
	public ResponseEntity<?>update(@RequestBody Venta ventadetails, @PathVariable(value = "idventa") Long ventaId){
		Optional<Venta> venta = ventaService.findById(ventaId);
		if(!venta.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		//BeanUtils.copyProperties(clienteDetails, cliente.get());
		venta.get().setFecha(ventadetails.getFecha());
		venta.get().setCliente(ventadetails.getCliente());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.save(venta.get()));
	}
	
	
}
