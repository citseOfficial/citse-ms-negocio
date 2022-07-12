package com.negocio.citse.controller;

import com.negocio.citse.entity.PersonaTaller;
import com.negocio.citse.service.PersonaTallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personaTaller")
public class PersonaTallerController {

    @Autowired
    private PersonaTallerService service;

    @GetMapping
    public List<PersonaTaller> findAll(){
         return service.findAll();
    }
    @GetMapping("/{id}")
    public PersonaTaller findById(@PathVariable Integer id){
       return service.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaTaller> save(@RequestBody PersonaTaller personaTaller, @PathVariable Integer id){
        PersonaTaller pt = service.findById(id);
        if(pt!=null){
            pt.setTaller(personaTaller.getTaller());
            pt.setAsistencia(personaTaller.getAsistencia());
            pt.setIdPersona(personaTaller.getIdPersona());
            service.save(pt);
        }
        return ResponseEntity.ok(pt);
    }
    @PostMapping
    public PersonaTaller save(@RequestBody PersonaTaller personaTaller){
        return service.save(personaTaller);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        if(id!=null){
            service.deleteById(id);
        }else{
            System.out.println("pillador");
        }
    }
}
