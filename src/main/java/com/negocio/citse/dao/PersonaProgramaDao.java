package com.negocio.citse.dao;

import com.negocio.citse.entity.Programa;
import com.negocio.citse.entity.PersonaPrograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaProgramaDao extends JpaRepository<PersonaPrograma,Integer> {
    public List<PersonaPrograma> findByPrograma(Programa programa);
}
