package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.CarreraDTO;
import ar.edu.unju.fi.model.Carrera;

@Service
public interface CarreraService {
	
	public void guardarCarrera(CarreraDTO carreraDTO);
	public List<Carrera> mostrarCarreras();
	public void borrarCarrera(String codigo);
	public void modificarCarrera(CarreraDTO carreraModificada);
	public CarreraDTO buscarCarrera(String codigo);

}