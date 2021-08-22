package com.mans.backMicroempresa.entidades;

import javax.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproducto")
	private Long idProducto;
	
	@Column(name = "nombreproducto")
	private String nombreProducto;
	
	@Column(name = "fotoproducto")
	private String fotoProducto;
	
	public Producto() {
		super();
	}
	
	public Producto(String nombreProducto, String fotoProducto) {
		super();
		this.nombreProducto = nombreProducto;
		this.fotoProducto = fotoProducto;
	}
	
	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}
	
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	
	public String getFotoProducto() {
		return fotoProducto;
	}
	
	public void setFotoProducto(String fotoProducto) {
		this.fotoProducto = fotoProducto;
	}	
}
