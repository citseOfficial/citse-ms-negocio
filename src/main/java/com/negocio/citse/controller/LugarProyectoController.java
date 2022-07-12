package com.negocio.citse.controller;

import com.negocio.citse.entity.LugarProyecto;
import com.negocio.citse.entity.Proyecto;
import com.negocio.citse.service.LugarProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("lugarProyecto")
public class LugarProyectoController {

    @Autowired
    private LugarProyectoService service;


    @GetMapping("/{id}")
    public LugarProyecto findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<LugarProyecto>> findAll(@RequestParam(name = "proyecto",required = false) Integer proyecto,
                                                              @RequestParam(name = "distrito",required = false)Integer distrito){
        List<LugarProyecto> lp = new ArrayList<>();
        if(null == proyecto && null==distrito){
            lp=service.findAll();
            if(lp.isEmpty())
                return ResponseEntity.noContent().build();
        }else if(proyecto!=null){
            lp=service.findByProyecto(Proyecto.builder().id(proyecto).build());
            if(lp.isEmpty())
                return ResponseEntity.notFound().build();
        }else{
            lp=service.findByIdDistrito(distrito);
            if(lp.isEmpty())
                return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lp);
    }

    @PostMapping
    public LugarProyecto save(@RequestBody LugarProyecto lugarProyecto){
        return service.save(lugarProyecto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
