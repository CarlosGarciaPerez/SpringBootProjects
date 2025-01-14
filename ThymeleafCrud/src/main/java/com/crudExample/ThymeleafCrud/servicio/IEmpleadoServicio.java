package com.crudExample.ThymeleafCrud.servicio;

import java.util.List;

import org.springframework.data.domain.Page;

import com.crudExample.ThymeleafCrud.modelo.Empleado;

public interface IEmpleadoServicio {
	
	public List<Empleado> getAllEmpleado();
	
	public void guardarEmpleado(Empleado empleado);
	
	public Empleado getEmpleadoById (Long Id);
	
	public void eliminaEmpleado (Long Id);
	
	Page<Empleado> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	

}
