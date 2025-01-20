package com.example.restCrud.controller;

import com.example.restCrud.modelo.Producto;
import com.example.restCrud.servicio.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/productoController")
public class ProductoController {
    @Autowired
    private IProductoService iProductoService;

    @PostMapping("/guardarEmpleado")
    public ResponseEntity<Producto> guardarEmpleado (@RequestBody Producto producto){
        return new ResponseEntity<Producto>(iProductoService.guardarProducto(producto), HttpStatus.CREATED);
    }

    @GetMapping ("/obtenerProductos")
    public List<Producto> obtenerProductos(){
        return iProductoService.obtenerProductos();
    }
    @GetMapping ("/obtenerProductoById/{id}")
    public ResponseEntity<Producto> obtenerProductoById (@PathVariable ("id") long id){
        return new ResponseEntity<Producto>(iProductoService.buscarProductoById(id), HttpStatus.OK);
    }
    @PutMapping("/actualizarProducto/{id}")
    public ResponseEntity<Producto> actualizarProducto (@PathVariable ("id") long id,
                                                        @RequestBody Producto producto){
        return new ResponseEntity<Producto>(iProductoService.actualizarProducto(producto, id), HttpStatus.OK );
    }
    @DeleteMapping("/eliminarProducto/{id}")
    public ResponseEntity<String>  eliminarProducto (@PathVariable ("id") long id){
        iProductoService.eliminarProducto(id);
        return new ResponseEntity<String> ("Producto Eliminado correctamente", HttpStatus.OK);
    }


}
