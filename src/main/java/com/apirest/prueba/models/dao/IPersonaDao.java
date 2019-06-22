package com.apirest.prueba.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.apirest.prueba.models.entity.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Long>{

}
