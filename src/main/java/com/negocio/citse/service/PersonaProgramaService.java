package com.negocio.citse.service;

import com.negocio.citse.entity.PersonaPrograma;
import com.negocio.citse.entity.Programa;

import java.util.List;

public interface PersonaProgramaService {

    public List<PersonaPrograma> findAll();

    public PersonaPrograma save(PersonaPrograma personaPrograma);

    public PersonaPrograma findById(Integer id);
    public void deleteById(Integer id);

    public List<PersonaPrograma> findByPrograma(Programa programa);
}
