package ar.edu.unju.fi.DTO;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AlumnoDTO {
	private String dni;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private Calendar fechadenacimiento;
	private String domicilio;
	private String lu;
	private Boolean estado;
	
}
