package ar.edu.unju.fi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.dto.CarreraDTO;

@Service
public interface ICarreraService {
	List<CarreraDTO> getListaCarreras();

	CarreraDTO findCarreraById(Long id);

	void agregarUnaCarrera(CarreraDTO carreraDTO);

	void actualizarCarrera(CarreraDTO carreraDTO);

	void eliminarUnaCarrera(Long id);
}
