package com.example.restCrud.repositorio;

import com.example.restCrud.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Long> {

}
