package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import lombok.Data;
import java.util.Calendar;
import jakarta.persistence.Id;

@Data
@Component
@Entity
public class Alumno {
	private String dni;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private Calendar fechadenacimiento;
	private String domicilio;
	@Id
	private String lu;
	private Boolean estado;
}