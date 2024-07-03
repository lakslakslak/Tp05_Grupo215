package ar.edu.unju.fi.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
public class AlumnoDTO {
	private String dni;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNac;
	private String domicilio;
	private Long lu;
	private boolean estado;
}
