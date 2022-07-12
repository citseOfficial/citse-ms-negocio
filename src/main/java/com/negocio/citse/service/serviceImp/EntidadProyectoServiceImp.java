package com.negocio.citse.service.serviceImp;

import com.negocio.citse.dao.EntidadProyectoDao;
import com.negocio.citse.entity.EntidadProyecto;
import com.negocio.citse.entity.Proyecto;
import com.negocio.citse.feignClients.EntidadFeignClient;
import com.negocio.citse.models.Entidad;
import com.negocio.citse.service.EntidadProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntidadProyectoServiceImp implements EntidadProyectoService {

    @Autowired
    private EntidadProyectoDao repo;

    @Autowired
    private EntidadFeignClient entidadFeignClient;

    @Override
    public List<EntidadProyecto> findAll() {
        return repo.findAll();
    }

    @Override
    public EntidadProyecto findById(Integer id) {
        EntidadProyecto ep = repo.findById(id).orElse(null);
        if(ep!=null){
            Entidad entidad = entidadFeignClient.getEntidad(ep.getEntidad()).getBody();
            ep.setDetallEntidad(entidad);
        }
        return ep;
    }

    @Override
    public EntidadProyecto save(EntidadProyecto entidadProyecto) {
        return repo.save(entidadProyecto);
    }

    @Override
    public EntidadProyecto deleteById(Integer id) {
        EntidadProyecto ep = findById(id);
        ep.setEsEntidadProyecto(false);
        repo.save(ep);
        return ep;
    }

    @Override
    public List<EntidadProyecto> findByProyecto_e(Proyecto proyecto) {
        return repo.findByProyecto(proyecto);
    }

    @Override
    public List<EntidadProyecto> findByEntidad(Integer id) {
        return repo.findByEntidad(id);
    }
}
