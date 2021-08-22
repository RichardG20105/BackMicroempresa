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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mans.backMicroempresa.entidades.Administrador;
import com.mans.backMicroempresa.exception.ResourceNotFoundException;
import com.mans.backMicroempresa.repositorio.administradorServicios;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Administrador/")
public class administradorControlador {
	@Autowired
	private administradorServicios administradorServicios;
	
	@GetMapping("buscarAdministrador")
	public List<Administrador> getAdministradores(){
		return this.administradorServicios.findAll();
	}
	
	@GetMapping("buscarAdministradorId/{id}")
	public ResponseEntity<Administrador> getAdminsitradorId(@PathVariable(value = "id") Long idAdministrador)
			throws ResourceNotFoundException{
				Administrador administrador = administradorServicios.findById(idAdministrador)
				.orElseThrow(() -> new ResourceNotFoundException("No existe Administrador con el id ::"+idAdministrador));
				return ResponseEntity.ok().body(administrador);
		}
	
	@GetMapping("accesoLogin/{usuario}/{contrasenia}")
	@ResponseBody
	public ResponseEntity<Administrador> getAccesoLogin(@PathVariable(value = "usuario") String usuario,@PathVariable(value = "contrasenia")String contrasenia)
	throws ResourceNotFoundException{
		Administrador administrador = administradorServicios.findByUsuarioAndContrasenia(usuario,contrasenia)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario o contraseña incorrectos"));
		return ResponseEntity.ok().body(administrador);
	}
	
	@PostMapping("crearAdministrador")
	public Administrador crearAdministrador(@Valid @RequestBody Administrador administrador) throws ResourceNotFoundException{
		if(administradorServicios.existsByUsuario(administrador.getUsuario())){
			throw new ResourceNotFoundException("Ya existe un Administador con ese usuario");
		}
		return this.administradorServicios.save(administrador);
	}
	
	@PutMapping("modificarAdministrador/{id}")
	public ResponseEntity<Administrador> actualizarAdministrador(@PathVariable(value = "id")Long idAdministrador, @Valid @RequestBody Administrador administradorDetalle)throws ResourceNotFoundException{
		Administrador administrador = administradorServicios.findById(idAdministrador)
				.orElseThrow(()->new ResourceNotFoundException("No existe el administrador con el Id: "+idAdministrador));
		administrador.setNombreAdministrador(administradorDetalle.getNombreAdministrador());
		administrador.setUsuario(administradorDetalle.getUsuario());
		administrador.setContrasenia(administradorDetalle.getContrasenia());
		
		return ResponseEntity.ok(this.administradorServicios.save(administrador));
	}
	
	@DeleteMapping("borrarAdministrador/{id}")
	public Map<String, Boolean> borrarAdministrador(@PathVariable(value = "id")Long idAdministrador)throws ResourceNotFoundException{
		Administrador administrador = administradorServicios.findById(idAdministrador)
				.orElseThrow(()->new ResourceNotFoundException("No existe el adminsitrador con el Id: "+idAdministrador));
		this.administradorServicios.delete(administrador);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put(("Se elimino el Producto"), Boolean.TRUE);
		return response;
	}
}
