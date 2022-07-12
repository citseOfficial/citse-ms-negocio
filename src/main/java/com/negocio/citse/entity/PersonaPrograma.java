package com.negocio.citse.entity;

import com.negocio.citse.models.Persona;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tmv_personas_programa")
public class PersonaPrograma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERSONA_PROGRAMA")
    private Integer id;

    @Column(name = "ID_PERSONA")
    private Integer idPersona;

    @Transient
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "ID_PROGRAMA")
    private Programa programa;
}
