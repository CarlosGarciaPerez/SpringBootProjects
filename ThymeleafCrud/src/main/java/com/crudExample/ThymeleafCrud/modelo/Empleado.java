package com.crudExample.ThymeleafCrud.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long Id;
		
	@Column (name = "nombre")
	private String nombre;
	
	@Column (name = "apellido_paterno")
	private String apellidoPaterno;
	
	@Column (name = "apellido_materno")
	private String apellidoMaterno;
	
	@Column (name = "correo")
	private String email;


	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
