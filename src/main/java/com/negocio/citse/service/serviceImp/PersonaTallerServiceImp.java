package com.negocio.citse.service.serviceImp;

import com.negocio.citse.dao.PersonaProgramaDao;
import com.negocio.citse.dao.PersonaTallerDao;
import com.negocio.citse.entity.PersonaTaller;
import com.negocio.citse.service.PersonaTallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaTallerServiceImp implements PersonaTallerService {

    @Autowired
    private PersonaTallerDao repo;

    @Override
    public List<PersonaTaller> findAll() {
        return repo.findAll();
    }

    @Override
    public PersonaTaller save(PersonaTaller personaTaller) {
        return repo.save(personaTaller);
    }

    @Override
    public PersonaTaller findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}
