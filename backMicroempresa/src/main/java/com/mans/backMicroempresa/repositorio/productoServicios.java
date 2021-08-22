package com.mans.backMicroempresa.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mans.backMicroempresa.entidades.Producto;

@Repository
public interface productoServicios extends JpaRepository<Producto, Long> {
	Boolean existsByNombreProducto(String nombreProducto);
	Boolean existsByFotoProducto(String fotoProducto);
	Producto findByNombreProducto(String nombreProducto);
}
