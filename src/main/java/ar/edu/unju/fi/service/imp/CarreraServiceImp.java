package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.mapper.CarreraMapDTO;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.ICarreraService;

import java.util.List;

@Service
public class CarreraServiceImp implements ICarreraService {

	@Autowired
	CarreraRepository carreraRepository;

	@Autowired
	CarreraMapDTO carreraMapDTO;

	@Override
	public List<CarreraDTO> getListaCarreras() {
		List<Carrera> carreras = carreraRepository.findByEstado(true);
		return carreraMapDTO.listCarreraToListCarreraDTO(carreras);
	}

	@Override
	public CarreraDTO findCarreraById(Long id) {
		return carreraMapDTO.toDto(carreraRepository.findById(id).orElse(null));
	}

	@Override
	public void agregarUnaCarrera(CarreraDTO carreraDTO) {
		carreraDTO.setEstado(true);
		carreraRepository.save(carreraMapDTO.toEntity(carreraDTO));
	}

	@Override
	public void actualizarCarrera(CarreraDTO carreraDTO) {
		carreraRepository.save(carreraMapDTO.toEntity(carreraDTO));
	}

	@Override
	public void eliminarUnaCarrera(Long id) {
		CarreraDTO carreraDTO = findCarreraById(id);
		if (carreraDTO != null) {
			carreraDTO.setEstado(false);
			carreraRepository.save(carreraMapDTO.toEntity(carreraDTO));
		} else {
			throw new RuntimeException("La carrera con ID " + id + " no existe.");
		}
	}
}
