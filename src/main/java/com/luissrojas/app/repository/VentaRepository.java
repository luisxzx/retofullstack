package com.luissrojas.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luissrojas.app.entity.Venta;
@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
	
	List<Venta> findByFecha(Date fecha);

}
