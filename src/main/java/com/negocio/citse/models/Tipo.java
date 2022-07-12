package com.negocio.citse.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Tipo implements Serializable {
    private Integer idTipo;
    private String noTipo;
    private String coAlias;
}
