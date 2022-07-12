package com.negocio.citse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "TMA_TALLERES")
public class Taller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TALLER")
    private Integer id;

    @Column(name = "NO_TALLER")
    private String nombre;

    @Column(name = "OBJ_TALLER")
    private String objetivo;

    @Column(name = "DE_TALLER")
    private String descripcion;

    @Column(name = "FE_INICIO")
    private String inicio;

    @Column(name = "FE_FIN")
    private String fin;

    @Column(name = "ES_TALLER")
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "ID_PROGRAMA")
    private Programa programa;

    @JsonIgnore
    @OneToMany(mappedBy = "taller")
    private List<PersonaTaller> personasT;
}
