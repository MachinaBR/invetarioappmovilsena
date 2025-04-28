package com.example.inventarioapi.service;

import com.example.inventarioapi.model.Producto;
import com.example.inventarioapi.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    // Constructor para inyección de dependencias
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Obtener todos los productos
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    // Guardar un producto
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    // Eliminar un producto por ID
    public void eliminarPorId(Integer id) {
        productoRepository.deleteById(id);
    }
}
