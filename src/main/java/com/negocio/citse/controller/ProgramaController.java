package com.negocio.citse.controller;

import com.negocio.citse.entity.Programa;
import com.negocio.citse.entity.Proyecto;
import com.negocio.citse.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("programa")
public class ProgramaController {

    @Autowired
    private ProgramaService service;


    @GetMapping("/")
    public ResponseEntity<List<Programa>> find(@RequestParam(name = "proyecto",required = false) Integer proyecto,
                                               @RequestParam(name="esPrograma",required = false)Boolean esPrograma){
        List<Programa> p = new ArrayList<>();
        if(null==proyecto && null==esPrograma){
            p=service.findAll();
            if(p.isEmpty())
                return ResponseEntity.noContent().build();
        } else if (proyecto != null) {
            p=service.findByProyecto(Proyecto.builder().id(proyecto).build());
            if(p.isEmpty())
                return  ResponseEntity.notFound().build();
        }else{
            p=service.findByEsPrograma(esPrograma);
            if(p.isEmpty())
                return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(p);
    }

    @GetMapping("/{id}")
    public Programa findById(@PathVariable(value="id") Integer id){
        return service.findById(id);
    }

    @PostMapping
    public Programa save(@RequestBody Programa programa){
        return service.save(programa);
    }

    @PutMapping("/{id}")
    public Programa update(@RequestBody Programa programa,@PathVariable Integer id){
        Programa p = service.findById(id);
        p.setNombre(programa.getNombre());
        p.setObjetivo(programa.getObjetivo());
        p.setDescripcion(programa.getDescripcion());
        p.setInicio(programa.getInicio());
        p.setFin(programa.getFin());
        p.setProyecto(programa.getProyecto());
        service.save(p);
        return p;
    }

    @DeleteMapping("/{id}")
    public Programa deleteById(@PathVariable Integer id){
        Programa programa= findById(id);
        programa.setEstado(false);
        service.save(programa);
        return programa;
    }

}
