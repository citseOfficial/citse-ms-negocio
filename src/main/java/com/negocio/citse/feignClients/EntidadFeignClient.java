package com.negocio.citse.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.negocio.citse.models.Entidad;

@FeignClient(name = "citse-ms-entidad", path = "entidad", fallback = EntidadHistrixFallback.class)
public interface EntidadFeignClient {

    @GetMapping("/{id}")
    public ResponseEntity<Entidad> getEntidad(@PathVariable Integer id);
}
