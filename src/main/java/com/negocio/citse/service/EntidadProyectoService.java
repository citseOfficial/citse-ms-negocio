package com.negocio.citse.service;

import com.negocio.citse.entity.EntidadProyecto;
import com.negocio.citse.entity.Proyecto;

import java.util.List;

public interface EntidadProyectoService {
    public List<EntidadProyecto> findAll();

    public EntidadProyecto findById(Integer id);

    public EntidadProyecto save(EntidadProyecto entidadProyecto);

    public EntidadProyecto deleteById(Integer id);

    // - - -
    public List<EntidadProyecto> findByProyecto_e(Proyecto proyecto);
    public List<EntidadProyecto> findByEntidad(Integer id);
}
