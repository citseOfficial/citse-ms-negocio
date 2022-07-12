package com.negocio.citse.models;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class Departamento implements Serializable {
    private Integer id;
    private String noDepartamento;
}
