package com.negocio.citse.service;

import com.negocio.citse.entity.Programa;
import com.negocio.citse.entity.Proyecto;

import java.util.List;

public interface ProgramaService {
    public List<Programa> findAll();

    public Programa findById(Integer id);

    public Programa save(Programa programa);

    public Programa deleteById(Integer id);

    // --
    public List<Programa> findByProyecto(Proyecto proyecto);
    public List<Programa> findByEsPrograma(Boolean estado);
}
