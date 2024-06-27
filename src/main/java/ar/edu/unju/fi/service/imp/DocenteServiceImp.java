package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.DocenteDTO;
import ar.edu.unju.fi.map.DocenteMapDTO;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.service.DocenteService;

@Service
public class DocenteServiceImp implements DocenteService{

	@Autowired
	DocenteRepository docenteRepository;
	@Autowired 
	DocenteMapDTO docenteMapDTO;
	
	@Override
	public void guardarDocente (DocenteDTO docente) {
		docenteMapDTO.convertirDocenteDTOADocente(docente);
		docenteRepository.save
		(docenteMapDTO.convertirDocenteDTOADocente(docente));
	}

	@Override
	public List<Docente> mostrarDocentes() {
		// TODO Auto-generated method stub
		//return carreraRepository.findAll();
		return docenteRepository.findDocenteByEstado(true);
	}

	@Override
	public void borrarDocente(String legajo) {
		System.out.println("este es el legajo: "+legajo);
		// TODO Auto-generated method stub
		List<Docente> todosLosDocentes = docenteRepository.findAll();
		for (int i = 0; i < todosLosDocentes.size(); i++) {
		      Docente docente = todosLosDocentes.get(i);
		      if (docente.getLegajo().equals(legajo)) {
		        docente.setEstado(false);
		        docenteRepository.save(docente);
		        break;
		      }
		    }
	}
	



	@Override
	public DocenteDTO buscarDocente(String legajo) {
		
		List<Docente> todasLasDocentes = docenteRepository.findAll();
		for (Docente docente : todasLasDocentes){
			if (docente.getLegajo().equals(legajo)){
				return docenteMapDTO.convertirDocenteADocenteDTO(docente);
			}
		}
		return null;
	}

	@Override
	public void modificarDocente(DocenteDTO docenteModificada) {

	    DocenteDTO docenteBuscada = buscarDocente(docenteModificada.getLegajo());
	    if (docenteBuscada != null) {
	    	
		List<Docente> todasLasDocentes = docenteRepository.findAll();
		
			for (int i = 0 ; i < todasLasDocentes.size() ; i++) {
				
				DocenteDTO docente = docenteMapDTO.convertirDocenteADocenteDTO(todasLasDocentes.get(i));
				
				if (docente.getLegajo().equals(docenteModificada.getLegajo())) {
					todasLasDocentes.set(i, docenteMapDTO.convertirDocenteDTOADocente(docenteModificada));
					break;
					}
				}
			docenteRepository.saveAll(todasLasDocentes);
		   } 
	    	else {
	    		System.out.println("El docente no se ha encontrado ");
	    }
	}

}