package com.negocio.citse.service;

import com.negocio.citse.entity.Programa;
import com.negocio.citse.entity.Taller;

import java.util.List;

public interface TallerService {
    public List<Taller> findAll();
    public Taller findById(Integer id);
    public Taller save(Taller taller);
    public Taller deleteById(Integer id);

    // Otras utilidades
    public List<Taller> findByNombre(String nombre);
    public List<Taller> findByPrograma(Programa programa);
    public List<Taller> findByEsTaller(Boolean estado);
}
