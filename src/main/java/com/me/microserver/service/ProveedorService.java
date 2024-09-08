package com.me.microserver.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.microserver.entity.Proveedor;
import com.me.microserver.repository.ProveedorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public Proveedor crearProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public List<Proveedor> obtenerTodosLosProveedores() {
        return proveedorRepository.findAll();
    }

    public Optional<Proveedor> obtenerProveedorPorId(String id) {
        return proveedorRepository.findById(id);
    }

    public Proveedor actualizarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public void eliminarProveedorPorId(String id) {
        proveedorRepository.deleteById(id);
    }
}
