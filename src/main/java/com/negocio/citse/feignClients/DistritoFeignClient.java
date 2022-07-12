package com.negocio.citse.feignClients;

import com.negocio.citse.models.Distrito;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "citse-ms-ubigeo", path = "distrito", fallback = DistritoHistrixFallback.class)//url = "http://localhost:8001/ms/distrito")
public interface DistritoFeignClient {

    @GetMapping("/{id}")
    public ResponseEntity<Distrito> getDistrito(@PathVariable("id") Integer id);

    //TODO:issue en fallback
}
