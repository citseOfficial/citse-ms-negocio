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
@Table(name = "TMA_PROGRAMAS")
@Entity
@AllArgsConstructor @NoArgsConstructor @Builder
public class Programa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROGRAMA")
    private Integer id;

    @Column(name = "NO_PROGRAMA")
    private String nombre;

    @Column(name = "OBJ_PROGRAMA")
    private String objetivo;

    @Column(name = "DE_PROGRAMA")
    private String descripcion;

    @Column(name = "FE_INICIO")
    private String inicio;

    @Column(name = "FE_FIN")
    private String fin;

    @Column(name = "ES_PROGRAMA",columnDefinition = "BIT")
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "ID_PROYECTO")
    private Proyecto proyecto;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "programa")
    private List<Taller> talleres;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "programa")
    private List<PersonaPrograma> personas;
}
