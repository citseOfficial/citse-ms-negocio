package com.negocio.citse.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "TMV_PERSONAS_TALLER")
public class PersonaTaller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERSONA_TALLER")
    private Integer id;

    @Column(name = "ID_PERSONA")
    private Integer idPersona;

    @Column(name = "ES_ASISTENCIA",columnDefinition = "BIT")
    private Boolean asistencia;

    @ManyToOne
    @JoinColumn(name = "ID_TALLER")
    private Taller taller;
}
