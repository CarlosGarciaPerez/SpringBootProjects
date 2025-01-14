package com.crudExample.ThymeleafCrud.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudExample.ThymeleafCrud.modelo.Empleado;

@Repository
public interface IEmpleadoRepositorio extends JpaRepository<Empleado, Long> {

}
