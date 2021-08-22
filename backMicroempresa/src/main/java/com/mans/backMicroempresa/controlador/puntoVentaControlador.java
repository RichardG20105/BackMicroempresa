package com.mans.backMicroempresa.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mans.backMicroempresa.repositorio.puntoVentaServicios;

import com.mans.backMicroempresa.entidades.PuntoVenta;
import com.mans.backMicroempresa.exception.ResourceNotFoundException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/PuntoVenta/")

public class puntoVentaControlador {
	@Autowired
	private puntoVentaServicios puntoVentaServicios;
	
	//Consultar todos los Punto Venta
	@GetMapping("buscarPuntoVenta")
	public List<PuntoVenta> buscarPuntoVenta(){
		return this.puntoVentaServicios.findAll();
	}
	
	//Crear Punto Venta
	@PostMapping("crearPuntoVenta")
	public PuntoVenta crearPuntoVenta(@Valid @RequestBody PuntoVenta puntoventa) throws ResourceNotFoundException {
		if(puntoVentaServicios.existsByNombrePventa(puntoventa.getNombrePventa())) {
			throw new ResourceNotFoundException("Ya existe un Punto Venta con ese Nombre");
		}
		return this.puntoVentaServicios.save(puntoventa);
	}
	
	//Buscar Punto Venta por id (get-rest api)
	@GetMapping("buscarPuntoVentaId/{id}")
	public ResponseEntity<PuntoVenta> buscarPuntoVentaId(@PathVariable Long id)throws ResourceNotFoundException{
		PuntoVenta puntoventa = puntoVentaServicios.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("No existe el Punto Venta con el Id: "+id));
		return ResponseEntity.ok(puntoventa);
	}
	
	//Modificar Punto Venta
	@PutMapping("modificarPuntoVenta/{id}")
	public ResponseEntity<PuntoVenta> actualizarPuntoVenta(@PathVariable(value ="id")Long idPventa,@Valid @RequestBody PuntoVenta pventaDetalle) throws ResourceNotFoundException{
		PuntoVenta puntoventa = puntoVentaServicios.findById(idPventa)
				.orElseThrow(()->new ResourceNotFoundException("No existe el Punto Venta con el Id: "+idPventa));
			puntoventa.setNombrePventa(pventaDetalle.getNombrePventa());
			puntoventa.setDireccionPventa(pventaDetalle.getDireccionPventa());
			puntoventa.setCiudadPventa(pventaDetalle.getCiudadPventa());
		return ResponseEntity.ok(this.puntoVentaServicios.save(puntoventa));
	}
	
	//Borrar Punto Venta
	@DeleteMapping("borrarPuntoVenta/{id}")
	public Map<String, Boolean> borrarPuntoVenta(@PathVariable(value ="id")Long idPventa)throws ResourceNotFoundException{
		PuntoVenta puntoventa = puntoVentaServicios.findById(idPventa)
				.orElseThrow(()->new ResourceNotFoundException("No se encontro el Punto Venta con el Id: "+idPventa));
		this.puntoVentaServicios.delete(puntoventa);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put(("Se elimino el Punto Venta"), Boolean.TRUE);
		return response;
	}
	
}