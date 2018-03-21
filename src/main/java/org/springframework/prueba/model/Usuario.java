package org.springframework.prueba.model;

public class Usuario {
	private int id; 
	private String nombre; 
	private String nombreUsuario; 
	
	public Usuario() {
		this.id = 0; 
		this.nombre = ""; 
		this.nombreUsuario = ""; 
	}
	
	public Usuario(int id, String nombre, String nombreUsuario) {
		this.id = id; 
		this.nombre = nombre; 
		this.nombreUsuario = nombreUsuario; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	
}
