 package com.pruebatecnica.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.apirest.model.Cliente;

/**
 * Interfaz que define un repositorio para la entidad Cliente.
 * Extiende JpaRepository para obtener acceso a operaciones CRUD básicas.
 */


@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
	
	
	

}
