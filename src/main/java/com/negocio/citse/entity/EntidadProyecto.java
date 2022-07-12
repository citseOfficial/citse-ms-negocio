package com.negocio.citse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.negocio.citse.models.Entidad;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "TMV_ENTIDADES_PROYECTO")
public class EntidadProyecto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ENTIDAD_PROYECTO")
    private Integer id;

    @Column(name = "ID_ENTIDAD")
    private Integer entidad;

    @Transient
    private Entidad detallEntidad;

    @Column(name = "ES_ENTIDAD_PROYECTO")
    private Boolean esEntidadProyecto;

    @ManyToOne
    @JoinColumn(name = "ID_PROYECTO")
    private Proyecto proyecto;
}
