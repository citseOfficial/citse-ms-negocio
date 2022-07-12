package com.negocio.citse.dao;

import com.negocio.citse.entity.PersonaTaller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaTallerDao extends JpaRepository<PersonaTaller,Integer> {
}
