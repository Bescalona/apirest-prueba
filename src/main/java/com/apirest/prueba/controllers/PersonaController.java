package com.apirest.prueba.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.prueba.models.entity.Persona;
import com.apirest.prueba.models.services.IPersonaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins= {"http://localhost:4200"})
public class PersonaController {
	
	@Autowired
	private IPersonaService personaService;
	
	@GetMapping("/personas")
	public List<Persona> obtenerListaPersonas(){
		return personaService.findAll();
	}
	
	@GetMapping("/personas/{id}")
	public Persona obtenerPersona(@PathVariable Long id) {
		return personaService.findById(id);
	}
	
	@PostMapping("/personas")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona crearPersona(@RequestBody Persona persona) {
		return personaService.create(persona);
	}
	
	@DeleteMapping("personas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarPersona(@PathVariable Long id) {
		personaService.delete(id);
	}
	
	@PutMapping("personas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona editarPersona(@RequestBody Persona persona,@PathVariable Long id) {
		Persona nuevaPersona = personaService.findById(id);
		nuevaPersona.setApellido(persona.getApellido());
		nuevaPersona.setNombre(persona.getNombre());
		return personaService.create(nuevaPersona);
	}
	
}
