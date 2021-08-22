package com.mans.backMicroempresa.entidades;

import javax.persistence.*;

@Entity
@Table(name ="administrador")
public class Administrador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idadministrador")
	private Long idAdministrador;
	
	@Column(name = "nombreadministrador")
	private String nombreAdministrador;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "contrasena")
	private String contrasenia;

	public Administrador() {
		super();
	}

	public Administrador(String nombreAdministrador, String usuario, String contrasenia) {
		super();
		this.nombreAdministrador = nombreAdministrador;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}

	public Long getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(Long idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public String getNombreAdministrador() {
		return nombreAdministrador;
	}

	public void setNombreAdministrador(String nombreAdministrador) {
		this.nombreAdministrador = nombreAdministrador;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
}
