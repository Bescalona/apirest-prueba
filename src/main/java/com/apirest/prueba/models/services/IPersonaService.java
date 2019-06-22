package com.apirest.prueba.models.services;

import java.util.List;

import com.apirest.prueba.models.entity.Persona;

public interface IPersonaService {
	
	public List<Persona> findAll();
	
	public Persona findById(Long id);
	
	public Persona create(Persona persona);
	
	public void delete (Long id);
	
}
