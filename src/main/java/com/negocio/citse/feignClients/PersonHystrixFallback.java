package com.negocio.citse.feignClients;

import com.negocio.citse.models.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonHystrixFallback implements PersonaFeignClient{
    @Override
    public ResponseEntity<Persona> findById(Integer id) {
        Persona p = Persona.builder().noPersona("none").apPaterno("none").apMaterno("none").feNacimiento("none").build();
        return ResponseEntity.ok(p);
    }
}
