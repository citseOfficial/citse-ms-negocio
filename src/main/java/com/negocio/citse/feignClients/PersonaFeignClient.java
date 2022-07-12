package com.negocio.citse.feignClients;

import com.negocio.citse.models.Persona;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "citse-ms-maestra", path = "persona", fallback = PersonHystrixFallback.class)
public interface PersonaFeignClient {
    @GetMapping("/{id}")
    public ResponseEntity<Persona> findById(@PathVariable Integer id);
}
