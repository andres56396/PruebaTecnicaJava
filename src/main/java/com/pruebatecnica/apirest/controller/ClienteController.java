package com.pruebatecnica.apirest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.apirest.ClienteService;
import com.pruebatecnica.apirest.model.Cliente;

import org.springframework.web.bind.annotation.CrossOrigin;



@RestController
@RequestMapping("api/Clientes")
@CrossOrigin(origins = "http://localhost:4200")  // Permitir solicitudes desde localhost:4200
public class ClienteController {
	
	
	@Autowired
	private ClienteService clienteService;
	
	
	@PostMapping
	public Cliente createCliente(@RequestBody Cliente cliente) {
		
		return clienteService.createCliente(cliente);	
		
		
	}
	
	@GetMapping
	public List<Cliente> getall() {
		return clienteService.getClientes();
		
	}
	
	
	@GetMapping("{id}")
	public Cliente searchclienteById(@PathVariable("id") long id) {
		return clienteService.getClienteById(id);
		
	}
	
	
	@GetMapping("/alfabeticamente")	
	  public List<Cliente> getClientesOrdenadosAlfabeticamente() {
			
			return clienteService.getClientesOrdenadosAlfabeticamente();	
			
			
		}
	
	@GetMapping("/edad")
    public List<Cliente> getClientesOrdenadosPorEdad() {
		return clienteService.getClientesOrdenadosPorEdad();
    }
	
	 @GetMapping("/estadisticas")
	    public ResponseEntity<Map<String, Double>> getEstadisticasClientes() {
	        Map<String, Double> estadisticas = clienteService.getEstadisticasClientes();
	        return new ResponseEntity<>(estadisticas, HttpStatus.OK);
	    }
 
	

}
