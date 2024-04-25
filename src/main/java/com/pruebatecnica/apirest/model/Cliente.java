package com.pruebatecnica.apirest.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;


@Entity
@Table(name = "Clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;	
	
	private long cedula;	 
	
	private String nombre;
	
	private String correoElectronico;
	
	@Temporal(TemporalType.DATE)	
	private Date fechaNacimiento;
	
	
	@Transient
    private int edad; // Campo transitorio para almacenar la edad
    
    // Otros getters y setters
	@JsonIgnore
	public int getEdad() {
	    LocalDate fechaNac = this.fechaNacimiento.toLocalDate();
	    LocalDate ahora = LocalDate.now();
	    return Period.between(fechaNac, ahora).getYears();
	}

    
    // Método auxiliar para calcular la edad
    public void calcularEdad() {
        LocalDate fechaNac = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate ahora = LocalDate.now();
        this.edad = Period.between(fechaNac, ahora).getYears();
    }
	
	
	public Long getId() {
		
		return this.id;
	}
	
   public void setId(Long id) {
		
		 this.id = id;
	}
   
   
   public Long getCedula() {
		
		return this.cedula;
	}
	
  public void setCedula(Long cedula) {
		
		 this.cedula = cedula;
	}
  
  
  public String getNombre() {
		
		return this.nombre;
	}
	
public void setnombre(String nombre) {
		
		 this.nombre = nombre;
	}


public String getcorreoElectronico() {
	
	return this.correoElectronico;
}

public void setcorreoElectronico(String correoElectronico) {
	
	 this.correoElectronico = correoElectronico;
}


//Getter y Setter para fechaNacimiento
public Date getFechaNacimiento() {
    return fechaNacimiento;
}

public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
}
	
	
}
