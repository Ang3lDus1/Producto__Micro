package com.me.microserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.me.microserver.entity.Proveedor;
import com.me.microserver.service.ProveedorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @PostMapping
    public ResponseEntity<Proveedor> crearProveedor(@RequestBody Proveedor proveedor) {
        Proveedor nuevoProveedor = proveedorService.crearProveedor(proveedor);
        return ResponseEntity.ok(nuevoProveedor);
    }

    @GetMapping
    public ResponseEntity<List<Proveedor>> obtenerTodosLosProveedores() {
        List<Proveedor> proveedores = proveedorService.obtenerTodosLosProveedores();
        return ResponseEntity.ok(proveedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtenerProveedorPorId(@PathVariable String id) {
        Optional<Proveedor> proveedor = proveedorService.obtenerProveedorPorId(id);
        return proveedor.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable String id, @RequestBody Proveedor proveedor) {
        proveedor.setId(id);
        Proveedor proveedorActualizado = proveedorService.actualizarProveedor(proveedor);
        return ResponseEntity.ok(proveedorActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable String id) {
        proveedorService.eliminarProveedorPorId(id);
        return ResponseEntity.noContent().build();
    }
}
