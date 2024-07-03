package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.model.Alumno;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AlumnoMapDTO {
	@Mapping(source = "dni", target = "dni")
	@Mapping(source = "nombre", target = "nombre")
	@Mapping(source = "apellido", target = "apellido")
	@Mapping(source = "email", target = "email")
	@Mapping(source = "telefono", target = "telefono")
	@Mapping(source = "fechaNac", target = "fechaNac")
	@Mapping(source = "domicilio", target = "domicilio")
	@Mapping(source = "lu", target = "lu")
	@Mapping(source = "estado", target = "estado")
	
	AlumnoDTO toDto(Alumno alumno);
	
	@InheritInverseConfiguration
	Alumno toEntity(AlumnoDTO alumnoDTO);
	
	List<AlumnoDTO> listAlumnoToListAlumnoDTO (List<Alumno> listaAlumno);
	
	List<Alumno> listAlumnoDTOToListAlumno (List<AlumnoDTO>listaAlumnoDTO);
}
