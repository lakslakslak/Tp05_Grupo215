package ar.edu.unju.fi.DTO;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class MateriaDTO {

    private String codigo;
    private String nombre;
    private String curso;
    private Integer cantidad;
    private Boolean modalidad;
    private Boolean estado;
}