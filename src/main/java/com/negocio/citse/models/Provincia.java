package com.negocio.citse.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Data
public class Provincia implements Serializable {
    private Integer id;
    private String noProvincia;
    private Departamento departamento;
   // private Departamento departamento;
   //  private List<Distrito> distritos;
}
