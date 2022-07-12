package com.negocio.citse.dao;

import com.negocio.citse.entity.LugarProyecto;
import com.negocio.citse.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LugarProyectoDao extends JpaRepository<LugarProyecto,Integer> {
    public List<LugarProyecto> findByIdDistrito(Integer id);
    public List<LugarProyecto> findByProyecto(Proyecto proyecto);
}
