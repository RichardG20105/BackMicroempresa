package com.mans.backMicroempresa.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mans.backMicroempresa.entidades.PuntoVenta;

@Repository

public interface puntoVentaServicios extends JpaRepository <PuntoVenta, Long>{
	Boolean existsByNombrePventa(String nombrePventa);
}
