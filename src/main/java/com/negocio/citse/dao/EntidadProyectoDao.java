package com.negocio.citse.dao;

import com.negocio.citse.entity.EntidadProyecto;
import com.negocio.citse.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface EntidadProyectoDao extends JpaRepository<EntidadProyecto,Integer> {
    public List<EntidadProyecto> findByProyecto(Proyecto proyecto);
    public List<EntidadProyecto> findByEntidad(Integer id);
}
