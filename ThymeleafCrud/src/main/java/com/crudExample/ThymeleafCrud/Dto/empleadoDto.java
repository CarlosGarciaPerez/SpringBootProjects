package com.crudExample.ThymeleafCrud.Dto;

import jakarta.persistence.Column;

public class empleadoDto {

	private Long Id;

	private String nombre;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private String email;

	public empleadoDto() {
		super();
	}

	public empleadoDto(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String email) {
		super();
		Id = id;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.email = email;
	}

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
