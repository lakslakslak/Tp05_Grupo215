package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class MateriaDTO {
	private Long codigo;
	private String nombre;
	private String curso;
	private int cantidadHoras;
	private String modalidad;
	private boolean estado;
}
