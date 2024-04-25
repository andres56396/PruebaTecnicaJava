package com.pruebatecnica.apirest;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.pruebatecnica.apirest.model.Cliente;
import com.pruebatecnica.apirest.repository.ClienteRepository;

/**
 * Servicio para manejar operaciones relacionadas con la entidad Cliente.
 */

@Component
public class ClienteService {
	
	
	@Autowired
	 private ClienteRepository clienteRepository;
	
	
	public Cliente createCliente(Cliente cliente) {
		
		return clienteRepository.save(cliente);
		
	}
	 
  public Cliente getClienteById(long id) {
		
		Optional<Cliente> optionalCliente = clienteRepository.findById(id);
		
		return optionalCliente.get();
		
	}
  
  
  public List<Cliente> getClientes() {		
		
		return clienteRepository.findAll();
		
	} 
  
  public void deleteCliente(long id) {
	  
	  clienteRepository.deleteById(id);
  }
	 
  
//Listado de clientes ordenados alfabéticamente
  public List<Cliente> getClientesOrdenadosAlfabeticamente() {
      return clienteRepository.findAll().stream()
              .sorted(Comparator.comparing(Cliente::getNombre))
              .collect(Collectors.toList());
  }
  

  public List<Cliente> getClientesOrdenadosPorEdad() {
      return clienteRepository.findAll().stream()
              .sorted(Comparator.comparingInt(Cliente::getEdad))
              .collect(Collectors.toList());
  }

  
  public Map<String, Double> getEstadisticasClientes() {
      List<Cliente> clientes = clienteRepository.findAll();
      
      int totalClientes = clientes.size();
      
      double sumaEdades = clientes.stream()
                                  .mapToInt(Cliente::getEdad)
                                  .sum();
      
      double promedioEdad = totalClientes > 0 ? sumaEdades / totalClientes : 0.0;
      
      Map<String, Double> estadisticas = new HashMap<>();
      estadisticas.put("totalClientes", (double) totalClientes);
      estadisticas.put("promedioEdad", promedioEdad);
      
      return estadisticas;
  }
  


}
