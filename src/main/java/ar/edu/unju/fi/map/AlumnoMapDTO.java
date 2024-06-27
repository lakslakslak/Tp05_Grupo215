package ar.edu.unju.fi.map;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.DTO.AlumnoDTO;
import ar.edu.unju.fi.model.Alumno;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface AlumnoMapDTO {
	@Mapping(source="dni",target="dni") 
	@Mapping(source="nombre",target="nombre") // Source = nombre del atributo de alumno --- target = nombre del atributo en DTO
	@Mapping(source="apellido",target="apellido") 
	@Mapping(source="email",target="email") 
	@Mapping(source="telefono",target="telefono") 
	@Mapping(source="fechadenacimiento",target="fechadenacimiento") 
	@Mapping(source="domicilio",target="domicilio") 
	@Mapping(source="lu",target="lu") 
	@Mapping(source="estado",target="estado") 
	AlumnoDTO convertirAlumnoAAlumnoDTO(Alumno a);
	
	@InheritInverseConfiguration //Revierte la confifuración anterior
	Alumno convertirAlumnoDTOAAlumno(AlumnoDTO ddto);	

	List<AlumnoDTO> convertirListaAlumnosAListaAlumnosDTO(List<Alumno> listaAlumno);
	
	List<Alumno> convertirListaAlumnosDTOAListaAlumnos(List<AlumnoDTO> listaAlumnosDTO);

}
