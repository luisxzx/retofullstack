package com.luissrojas.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luissrojas.app.entity.Cliente;
import com.luissrojas.app.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>  {

}
