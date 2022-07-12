package com.negocio.citse.service.serviceImp;

import com.negocio.citse.dao.PersonaProgramaDao;
import com.negocio.citse.entity.PersonaPrograma;
import com.negocio.citse.entity.Programa;
import com.negocio.citse.feignClients.PersonaFeignClient;
import com.negocio.citse.models.Persona;
import com.negocio.citse.service.PersonaProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaProgramServiceImp implements PersonaProgramaService {

    @Autowired
    private PersonaProgramaDao repo;

    @Autowired
    private PersonaFeignClient personaFeignClient;

    @Override
    public List<PersonaPrograma> findAll() {
        List<PersonaPrograma> ppl = repo.findAll();
        ppl.stream().forEach(personaPrograma -> {
            Persona persona = personaFeignClient.findById(personaPrograma.getIdPersona()).getBody();
            personaPrograma.setPersona(persona);
        });
        return ppl;
    }

    @Override
    public PersonaPrograma save(PersonaPrograma personaPrograma) {
        return repo.save(personaPrograma);
    }

    @Override
    public PersonaPrograma findById(Integer id) {
        PersonaPrograma pp = repo.findById(id).orElse(null);
        if(pp!=null){
            Persona persona = personaFeignClient.findById(pp.getIdPersona()).getBody();
            pp.setPersona(persona);
        }
        return pp;
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<PersonaPrograma> findByPrograma(Programa programa) {
        return repo.findByPrograma(programa);
    }
}
