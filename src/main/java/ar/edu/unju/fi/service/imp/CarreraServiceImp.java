package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.CarreraDTO;
import ar.edu.unju.fi.map.CarreraMapDTO;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.CarreraService;

@Service
public class CarreraServiceImp implements CarreraService{

	@Autowired
	CarreraRepository carreraRepository;
	
	@Autowired
	CarreraMapDTO carreraMapDTO;
	
	@Override
	public void guardarCarrera(CarreraDTO carreraDTO) {
		// TODO Auto-generated method stub
		//carrera.setEstado(true);
		
		carreraMapDTO.convertirCarreraDTOACarrera(carreraDTO);
		carreraRepository.save
		(carreraMapDTO.convertirCarreraDTOACarrera(carreraDTO));
	}

	@Override
	public List<Carrera> mostrarCarreras() {
		// TODO Auto-generated method stub
		//return carreraRepository.findAll();
		return carreraRepository.findCarreraByEstado(true);
	}

	@Override
	public void borrarCarrera(String codigo) {
		System.out.println("este es el codigo: "+codigo);
		// TODO Auto-generated method stub
		List<Carrera> todasLasCarreras = carreraRepository.findAll();
		for (int i = 0; i < todasLasCarreras.size(); i++) {
		      Carrera carrera = todasLasCarreras.get(i);
		      if (carrera.getCodigo().equals(codigo)) {
		        carrera.setEstado(false);
		        carreraRepository.save(carrera);
		        break;
		      }
		    }
	}

	@Override
	public void modificarCarrera(CarreraDTO carreraModificada) {
		List<Carrera> todasLasCarreras = carreraRepository.findAll();
		for (int i = 0 ; i < todasLasCarreras.size() ; i++) {
			CarreraDTO carrera = carreraMapDTO.convertirCarreraACarreraDTO(todasLasCarreras.get(i));
			if (carrera.getCodigo().equals(carreraModificada.getCodigo())) {
				todasLasCarreras.set(i, carreraMapDTO.convertirCarreraDTOACarrera(carreraModificada));
				break;
			}
		}
	}

	@Override
	public CarreraDTO buscarCarrera(String codigo) {
		
		List<Carrera> todasLasCarreras = carreraRepository.findAll();
		for (Carrera carrera : todasLasCarreras){
			if (carrera.getCodigo().equals(codigo)){
				return carreraMapDTO.convertirCarreraACarreraDTO(carrera);
			}
		}
		return null;
	}
	
}