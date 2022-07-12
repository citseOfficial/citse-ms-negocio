package com.negocio.citse.service;

import com.negocio.citse.entity.PersonaTaller;

import java.util.List;

public interface PersonaTallerService {
    public List<PersonaTaller> findAll();
    public PersonaTaller save(PersonaTaller personaTaller);
    public PersonaTaller findById(Integer id);
    public void deleteById(Integer id);
}
