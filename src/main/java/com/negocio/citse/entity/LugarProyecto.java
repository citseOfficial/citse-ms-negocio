package com.negocio.citse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.negocio.citse.models.Distrito;
import lombok.Data;
import lombok.NonNull;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TMV_LUGARES_PROYECTO")
public class LugarProyecto implements Serializable {

    @Id
    @Column(name = "ID_LUGAR_PROYECTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ID_DISTRITO")
    private Integer idDistrito;

    @Transient
    private Distrito distrito;//NO SE INSERTARA EN LA BD-- SOLO PARA CLIENTEFEIGN

    @Column(name = "ES_LUGAR_PROYECTO")
    private Boolean esLugarProyecto;

    @ManyToOne
    @JoinColumn(name = "ID_PROYECTO")
    private Proyecto proyecto;

}
