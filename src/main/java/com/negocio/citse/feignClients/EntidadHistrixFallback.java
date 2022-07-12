package com.negocio.citse.feignClients;

import com.negocio.citse.models.Entidad;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EntidadHistrixFallback implements EntidadFeignClient{
    @Override
    public ResponseEntity<Entidad> getEntidad(Integer id) {
        Entidad entidad = Entidad.builder().id(0).nombre("none").alias("none").feInstancia("none").build();
        return ResponseEntity.ok(entidad);
    }
}
