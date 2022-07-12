package com.negocio.citse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Table(name = "TMA_PROYECTOS")
@Entity
@AllArgsConstructor  @NoArgsConstructor @Builder
public class Proyecto implements Serializable {

    @Id
    @Column(name = "ID_PROYECTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NO_PROYECTO")
    private String nombre;

    @Column(name = "OBJ_PROYECTO")
    private String objetivo;

    @Column(name = "DE_PROYECTO")
    private String descripcion;

    @Column(name = "FE_INICIO")
    private String inicio;

    @Column(name = "FE_FIN")
    private String fin;

    @Column(name = "ES_PROYECTO",columnDefinition = "BIT")
    private Boolean estado;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "proyecto")
    private List<LugarProyecto> lugares;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "proyecto")
    private List<EntidadProyecto> entidades;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "proyecto")
    private List<Programa> programas;

}
