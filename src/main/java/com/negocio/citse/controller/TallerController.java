package com.negocio.citse.controller;

import com.negocio.citse.entity.Programa;
import com.negocio.citse.entity.Taller;
import com.negocio.citse.service.TallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("taller")
public class TallerController{

    @Autowired
    private TallerService service;


    @GetMapping("/")
    public ResponseEntity<List<Taller>> findAll(@RequestParam(name = "nombre",required = false)String nombre,
                                                @RequestParam(name = "programa",required = false)Integer programa,
                                                @RequestParam(name="esTaller",required = false)Boolean esTaller){
        List<Taller> tallers = new ArrayList<>();
        if(nombre==null && programa==null){
            tallers = service.findAll();
            if(tallers.isEmpty())
                return ResponseEntity.noContent().build();
        }else if (nombre!=null){
            tallers=service.findByNombre(nombre);
            if(tallers.isEmpty())
                return ResponseEntity.noContent().build();
        }else {
            tallers=service.findByEsTaller(esTaller);
            if(tallers.isEmpty())
                return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tallers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Taller> findById(@PathVariable Integer id){
        Taller taller= service.findById(id);
        if(taller!=null){
            return ResponseEntity.ok(taller);
        }else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Taller> update(@RequestBody Taller taller,@PathVariable Integer id){
        // datos
        Taller t = service.findById(id);
        t.setNombre(taller.getNombre());
        t.setObjetivo(taller.getObjetivo());
        t.setDescripcion(taller.getDescripcion());
        t.setInicio(taller.getInicio());
        t.setFin(taller.getFin());
        t.setPrograma(taller.getPrograma());
        service.save(t);
        return ResponseEntity.ok(taller);
    }

    @PostMapping
    public ResponseEntity<Taller> save(@RequestBody Taller taller){
        service.save(taller);
        return ResponseEntity.ok(taller);
    }

    @DeleteMapping("/{id}")
    public Taller delete(@PathVariable Integer id){
        Taller t = service.findById(id);
        t.setEstado(false);
        return t;
    }

}
