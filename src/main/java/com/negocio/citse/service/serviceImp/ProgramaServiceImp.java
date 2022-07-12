package com.negocio.citse.service.serviceImp;

import com.negocio.citse.dao.ProgramaDao;
import com.negocio.citse.entity.Programa;
import com.negocio.citse.entity.Proyecto;
import com.negocio.citse.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramaServiceImp implements ProgramaService {

    @Autowired
    private ProgramaDao repo;

    @Override
    public List<Programa> findAll() {
        return repo.findAll();
    }

    @Override
    public Programa findById(Integer id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public Programa save(Programa programa) {
        return repo.save(programa);
    }

    @Override
    public Programa deleteById(Integer id) {
        Programa p = findById(id);
        p.setEstado(false);
        repo.save(p);
        return p;
    }

    @Override
    public List<Programa> findByProyecto(Proyecto proyecto) {
        return repo.findByProyecto(proyecto);
    }

    @Override
    public List<Programa> findByEsPrograma(Boolean estado) {
        return repo.findByEstado(estado);
    }
}
