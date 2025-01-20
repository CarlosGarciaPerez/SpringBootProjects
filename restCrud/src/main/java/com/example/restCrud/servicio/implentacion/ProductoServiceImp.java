package com.example.restCrud.servicio.implentacion;

import com.example.restCrud.modelo.Producto;
import com.example.restCrud.repositorio.IProductoRepository;
import com.example.restCrud.servicio.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductoServiceImp implements IProductoService {

    @Autowired
    private IProductoRepository iProductoRepository;

    @Override
    public Producto guardarProducto(Producto producto) {
        return iProductoRepository.save( producto);
    }

    @Override
    public List<Producto> obtenerProductos() {
        return iProductoRepository.findAll();
    }
    @Override
    public Producto buscarProductoById(long id) {
        Optional<Producto> producto = iProductoRepository.findById(id);
        if ( producto.isPresent()){
            return producto.get();
        }else {
            throw new RuntimeException();
        }
    }

    @Override
    public Producto actualizarProducto(Producto producto, long id) {
       Producto existeProducto = iProductoRepository.findById(id).orElseThrow(
               ()->  new RuntimeException()
       );

       existeProducto.setNombre(producto.getNombre());
       existeProducto.setDescripcion(producto.getDescripcion());
       existeProducto.setPrecio(producto.getPrecio());
        // save
        iProductoRepository.save(existeProducto);

        return existeProducto;
    }

    @Override
    public void eliminarProducto(long id) {
       //check
        iProductoRepository.findById(id).orElseThrow(()-> new RuntimeException());
        //delete
        iProductoRepository.deleteById(id);
    }
}
