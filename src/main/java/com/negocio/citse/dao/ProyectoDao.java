package com.negocio.citse.dao;

import com.negocio.citse.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoDao extends JpaRepository<Proyecto,Integer> {
}
