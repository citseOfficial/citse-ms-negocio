package com.negocio.citse.service.serviceImp;

import com.negocio.citse.dao.TallerDao;
import com.negocio.citse.entity.Programa;
import com.negocio.citse.entity.Taller;
import com.negocio.citse.service.TallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TallerServiceImp implements TallerService {

    @Autowired
    private TallerDao repo;

    @Override
    public List<Taller> findAll() {
        return repo.findAll();
    }

    @Override
    public Taller findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Taller save(Taller taller) {
        return repo.save(taller);
    }

    @Override
    public Taller deleteById(Integer id) { //eliminado logico mediante el estado
        Taller status = findById(id);
        status.setEstado(false);
        repo.save(status);
        return status;
    }

    @Override
    public List<Taller> findByNombre(String nombre) {
        return repo.findTop10ByNombreContains(nombre);
    }

    @Override
    public List<Taller> findByPrograma(Programa programa) {
        return repo.findByPrograma(programa);
    }

    @Override
    public List<Taller> findByEsTaller(Boolean estado) {
        return repo.findByEstado(estado);
    }
}
