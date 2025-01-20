package com.example.restCrud.servicio;

import com.example.restCrud.modelo.Producto;

import java.util.List;

public interface IProductoService {
    public Producto guardarProducto(Producto producto);
    public List<Producto> obtenerProductos();
    public Producto buscarProductoById (long id);
    public Producto actualizarProducto (Producto producto, long id);
    void eliminarProducto(long id);
}
