package com.negocio.citse.controller;

import com.negocio.citse.entity.PersonaPrograma;
import com.negocio.citse.entity.Programa;
import com.negocio.citse.service.PersonaProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("personaPrograma")
public class PersonaProgramController {

    @Autowired
    private PersonaProgramaService service;

    @GetMapping("/")
    public ResponseEntity<List<PersonaPrograma>> findAll(@RequestParam(name = "programa",required = false)Integer programa){
        List<PersonaPrograma> p = new ArrayList<>();
        if(programa==null){
            System.out.println("aca");
            p=service.findAll();
            if(p.isEmpty())
                return ResponseEntity.noContent().build();
        }else {
            System.out.println("aca 2");
            p=service.findByPrograma(Programa.builder().id(programa).build());
            if(p.isEmpty())
                return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }

    @GetMapping("/{id}")
    public PersonaPrograma findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<PersonaPrograma> save(@RequestBody PersonaPrograma personaPrograma){
        service.save(personaPrograma);
        return ResponseEntity.ok(personaPrograma);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
