package com.negocio.citse.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
public class Distrito implements Serializable {
    private Integer id;
    private String noDistrito;
    private Provincia provincia;
}
