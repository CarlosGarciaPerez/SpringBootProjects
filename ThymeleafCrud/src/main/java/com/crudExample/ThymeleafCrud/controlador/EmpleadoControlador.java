package com.crudExample.ThymeleafCrud.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.crudExample.ThymeleafCrud.modelo.Empleado;
import com.crudExample.ThymeleafCrud.servicio.IEmpleadoServicio;

@Controller
public class EmpleadoControlador {

	@Autowired
	private IEmpleadoServicio iempleadoServicio;de Em
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "nombre", "asc", model);		
	}

	@PostMapping("/guardarEmpleado")
	public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado) {
		// save employee to database
		iempleadoServicio.guardarEmpleado(empleado);
		return "redirect:/";
	}

	@GetMapping("/showNuevoEmpleadoForm")
	public String showNuevoEmpleadoForm (Model model) {
		// create model attribute to bind form data
		Empleado empleado = new Empleado();
		model.addAttribute("empleado", empleado);
		return "nuevo_empleado";
	}

	@GetMapping("/showActualizaEmpleado/{id}")
	public String showActualizaEmpleado(@PathVariable (value = "id") long id, Model model)
	{
		Empleado empleado = iempleadoServicio.getEmpleadoById(id);
		model.addAttribute("empleado", empleado);
		return  "actualiza_empleado";
	}

	@GetMapping("/eliminarEmpleado/{id}")
	public String eliminarEmpleado (@PathVariable  (value = "id") long id)
	{
		this.iempleadoServicio.eliminaEmpleado(id);
		return "redirect:/";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Empleado> page = iempleadoServicio.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Empleado> listempleados = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listempleados", listempleados);
		return "index";
	}
	
	
}
