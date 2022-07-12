package com.negocio.citse.controller;

import com.negocio.citse.entity.Proyecto;
import com.negocio.citse.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import java.util.List;

@RestController
@RequestMapping("proyecto")
public class ProyectoController {

    @Autowired
    private ProyectoService service;


    @GetMapping("/")
    public List<Proyecto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Proyecto findById(@PathVariable Integer id, HttpRequestHandlerServlet request){
        return  service.findById(id);
    }

    @PostMapping
    public Proyecto save(@RequestBody Proyecto proyecto){
        return service.save(proyecto);
    }

    @PutMapping("/{id}")
    public Proyecto update(@RequestBody Proyecto proyecto, @PathVariable Integer id){
        Proyecto p = service.findById(id);
        p.setNombre(proyecto.getNombre());
        p.setObjetivo(proyecto.getObjetivo());
        p.setDescripcion(proyecto.getDescripcion());
        p.setInicio(proyecto.getInicio());
        p.setFin(proyecto.getFin());
        p.setEstado(proyecto.getEstado());
        return service.save(p);
    }

    @DeleteMapping("/{id}")
    public Proyecto deleteById(@PathVariable Integer id){
        Proyecto p = service.findById(id);
        p.setEstado(false);
        service.save(p);
        return p;
    }

}
