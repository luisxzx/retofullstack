package com.luissrojas.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luissrojas.app.entity.DetalleVenta;
import com.luissrojas.app.entity.Venta;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {

}
