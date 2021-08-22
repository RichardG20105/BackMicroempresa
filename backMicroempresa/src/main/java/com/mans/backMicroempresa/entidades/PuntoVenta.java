package com.mans.backMicroempresa.entidades;

import javax.persistence.*;

@Entity
@Table(name ="puntoventa")

public class PuntoVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpventa")
	private Long idPventa;
	
	@Column(name = "nombrepventa")
	private String nombrePventa;
	
	@Column(name = "direccionpventa")
	private String direccionPventa;
	
	@Column(name = "ciudadpventa")
	private String ciudadPventa;

	public PuntoVenta() {
		super();
	}

	public PuntoVenta(String nombrePventa, String direccionPventa, String ciudadPventa) {
		super();
		this.nombrePventa = nombrePventa;
		this.direccionPventa = direccionPventa;
		this.ciudadPventa = ciudadPventa;
	}

	public Long getIdPventa() {
		return idPventa;
	}

	public void setIdPventa(Long idPventa) {
		this.idPventa = idPventa;
	}

	public String getNombrePventa() {
		return nombrePventa;
	}

	public void setNombrePventa(String nombrePventa) {
		this.nombrePventa = nombrePventa;
	}

	public String getDireccionPventa() {
		return direccionPventa;
	}

	public void setDireccionPventa(String direccionPventa) {
		this.direccionPventa = direccionPventa;
	}

	public String getCiudadPventa() {
		return ciudadPventa;
	}

	public void setCiudadPventa(String ciudadPventa) {
		this.ciudadPventa = ciudadPventa;
	}
	
		
}
