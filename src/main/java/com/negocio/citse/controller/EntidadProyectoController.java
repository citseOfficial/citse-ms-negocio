package com.negocio.citse.controller;

import com.negocio.citse.entity.EntidadProyecto;
import com.negocio.citse.entity.Proyecto;
import com.negocio.citse.service.EntidadProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("entidadProyecto")
public class EntidadProyectoController {

    @Autowired
    private EntidadProyectoService service;


    @GetMapping("/")
    public ResponseEntity<List<EntidadProyecto>> findAll(@RequestParam(name = "proyecto",required = false) Integer proyecto,
                                                            @RequestParam(name = "entidad",required = false)Integer entidad){
        List<EntidadProyecto> ep = new ArrayList<>();

        if(null==proyecto && null==entidad){
            ep=service.findAll();
            if(ep.isEmpty())
                return ResponseEntity.noContent().build();
        } else if (entidad !=null) {
            ep=service.findByEntidad(entidad);
            if(ep.isEmpty())
                return ResponseEntity.notFound().build();
        }else{
            ep=service.findByProyecto_e(Proyecto.builder().id(proyecto).build());
            if(ep.isEmpty())
                return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ep);
    }

    @PostMapping
    public EntidadProyecto save(@RequestBody EntidadProyecto entidadProyecto){
        return service.save(entidadProyecto);
    }

    @GetMapping("/{id}")
    public EntidadProyecto findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
