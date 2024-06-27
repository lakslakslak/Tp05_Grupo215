package ar.edu.unju.fi.map;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.DTO.DocenteDTO;
import ar.edu.unju.fi.model.Docente;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface DocenteMapDTO {
	
	@Mapping(source="legajo",target="legajo") 
	@Mapping(source="nombre",target="nombre") // Source = nombre del atributo de carrera --- target = nombre del atributo en DTO
	@Mapping(source="apellido",target="apellido") 
	@Mapping(source="email",target="email") 
	@Mapping(source="telefono",target="telefono") 
	@Mapping(source="estado",target="estado") 
	DocenteDTO convertirDocenteADocenteDTO(Docente d);
	
	@InheritInverseConfiguration //Revierte la confifuración anterior
	Docente convertirDocenteDTOADocente(DocenteDTO ddto);	

	List<DocenteDTO> convertirListaDocentesAListaDocentesDTO(List<Docente> listaDocente);
	
	List<Docente> convertirListadDocentesDTOAListaDocentes(List<DocenteDTO> listaDocentesDTO);
}