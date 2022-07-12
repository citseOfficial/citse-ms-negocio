package com.negocio.citse.dao;

import com.negocio.citse.entity.Programa;
import com.negocio.citse.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramaDao extends JpaRepository<Programa,Integer> {

    //buscar programas mediante el id del proyecto
    public List<Programa> findByProyecto(Proyecto proyecto);

    //listar programas mediante el estado
    public List<Programa> findByEstado(Boolean estado);
}
