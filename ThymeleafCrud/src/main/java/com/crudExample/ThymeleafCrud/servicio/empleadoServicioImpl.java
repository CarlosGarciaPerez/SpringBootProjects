package com.crudExample.ThymeleafCrud.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.crudExample.ThymeleafCrud.modelo.Empleado;
import com.crudExample.ThymeleafCrud.repositorio.IEmpleadoRepositorio;

@Service
public class empleadoServicioImpl  implements IEmpleadoServicio {
	
	@Autowired
	private IEmpleadoRepositorio iempleadoRepositorio;

	@Override
	public List<Empleado> getAllEmpleado() {	
		return iempleadoRepositorio.findAll();
	}

	@Override
	public void guardarEmpleado(Empleado empleado) {
		this.iempleadoRepositorio.save(empleado);
	}

	@Override
	public Empleado getEmpleadoById(Long Id) {
		Optional<Empleado> optional = iempleadoRepositorio.findById(Id);	
		Empleado empleado = null;
		if (optional.isPresent()) {
			empleado = optional.get();
		}else {
			throw new RuntimeException(" Empleado NO ENCONTRADO para id :: " + Id);
		}
		return empleado;
	}

	@Override
	public void eliminaEmpleado(Long Id) {
		this.iempleadoRepositorio.deleteById(Id);
		
	}

	@Override
	public Page<Empleado> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.iempleadoRepositorio.findAll(pageable);
	}
	
	


}
