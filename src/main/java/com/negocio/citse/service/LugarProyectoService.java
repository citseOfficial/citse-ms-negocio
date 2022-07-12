package com.negocio.citse.service;

import com.negocio.citse.entity.LugarProyecto;
import com.negocio.citse.entity.Proyecto;
import com.negocio.citse.models.Distrito;

import java.util.List;

public interface LugarProyectoService {
    public List<LugarProyecto> findAll();
    public LugarProyecto findById(Integer id);

    public LugarProyecto save(LugarProyecto lugarProyecto);

    public LugarProyecto deleteById(Integer id);

    // --
    public List<LugarProyecto> findByIdDistrito(Integer id);
    public List<LugarProyecto> findByProyecto(Proyecto proyecto);

}
