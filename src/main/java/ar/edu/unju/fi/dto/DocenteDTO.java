package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
public class DocenteDTO {

    private Long legajo;

    @NotBlank(message = "Debe ingresar el nombre del docente")
    @Size(min=2,max = 50, message = "El nombre debe contener como mínimo 2 caracteres y como máximo 50 caracteres")
    @Pattern(regexp= "[a-zA-ZÁÉÍÓÚáéíóúÑñ ]*", message="Debe ingresar únicamente letras y espacios")
    private String nombre;

    @NotBlank(message = "Debe ingresar el apellido del docente")
    @Size(min=2,max = 50, message = "El apellido no puede llevar menos de 2 caracteres y más de 50 caracteres")
    @Pattern(regexp= "[a-zA-ZÁÉÍÓÚáéíóúÑñ ]*", message="Debe ingresar únicamente letras y espacios")
    private String apellido;

    @NotBlank(message = "Debe ingresar el email")
    @Email(message = "Debe ingresar un email válido")
    private String email;

    @NotBlank(message = "Debe ingresar el teléfono")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Debe ingresar un teléfono válido")
    private String telefono;

    private boolean estado;
}