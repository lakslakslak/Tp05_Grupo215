package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.model.Carrera;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarreraMapDTO {

	@Mapping(source = "id", target = "id")
	@Mapping(source = "codigo", target = "codigo")
	@Mapping(source = "nombre", target = "nombre")
	@Mapping(source = "duracion", target = "duracion")
	@Mapping(source = "estado", target = "estado")

	CarreraDTO toDto(Carrera carrera);

	@InheritInverseConfiguration
	Carrera toEntity(CarreraDTO carreraDTO);

	List<CarreraDTO> listCarreraToListCarreraDTO(List<Carrera> listadoCarrera);

	List<Carrera> listCarreraDTOToListCarrera(List<CarreraDTO> listadoCarreraDTO);
}
