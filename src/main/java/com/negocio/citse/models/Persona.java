package com.negocio.citse.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.io.Serializable;

@Data
@Builder
public class Persona implements Serializable {
    private Integer idPersona;
    private String noPersona;
    private String apPaterno;
    private String apMaterno;
    private String nuIndentificacion;
    private String feNacimiento;
    private Boolean esPersona;
    private Integer idTiIndentificacion;
    private Tipo tipoIdentificacion;
    private Integer idTiPersona;
    private Tipo tipoPersona;
    private Integer idComunidad;
    private Integer idTiEsCivil;
    private Tipo esCivil;

}
