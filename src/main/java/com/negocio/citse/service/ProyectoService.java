package com.negocio.citse.service;

import com.negocio.citse.entity.Proyecto;

import java.util.List;

public interface ProyectoService {
    public List<Proyecto> findAll();
    public Proyecto findById(Integer id);
    public Proyecto save(Proyecto proyecto);
    //public void deleteById(Inetger id);
}
