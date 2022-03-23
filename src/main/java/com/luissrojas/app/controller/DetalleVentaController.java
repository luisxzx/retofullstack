package com.luissrojas.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/api/detalleventa")
public class DetalleVentaController {
	

}
