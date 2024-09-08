package com.me.microserver.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.me.microserver.entity.Proveedor;

public interface ProveedorRepository extends MongoRepository<Proveedor, String> {
}
