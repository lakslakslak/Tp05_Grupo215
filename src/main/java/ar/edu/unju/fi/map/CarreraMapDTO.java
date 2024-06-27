package ar.edu.unju.fi.map;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.DTO.CarreraDTO;
import ar.edu.unju.fi.model.Carrera;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface CarreraMapDTO {
	
	@Mapping(source="codigo",target="codigo") 
	@Mapping(source="nombre",target="nombre") // Source = nombre del atributo de carrera --- target = nombre del atributo en DTO
	@Mapping(source="duracion",target="duracion") 
	@Mapping(source="estado",target="estado") 
	CarreraDTO convertirCarreraACarreraDTO(Carrera c);
	
	@InheritInverseConfiguration //Revierte la confifuración anterior
	Carrera convertirCarreraDTOACarrera(CarreraDTO cdto);	

	List<CarreraDTO> convertirListaCarrerasAListaCarrerasDTO(List<Carrera> listaCarreras);
	
	List<Carrera> convertirListadCarrerasDTOAListaCarreras(List<CarreraDTO> listaCarrerasDTO);
}
