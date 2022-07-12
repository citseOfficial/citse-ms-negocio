package com.negocio.citse.feignClients;

import com.negocio.citse.models.Distrito;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DistritoHistrixFallback implements DistritoFeignClient{
    @Override
    public ResponseEntity<Distrito> getDistrito(Integer id) {
        Distrito distrito = Distrito.builder().id(0).noDistrito("none").build();
        return ResponseEntity.ok(distrito);
    }
}
