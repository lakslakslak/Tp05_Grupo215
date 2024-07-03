package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.mapper.AlumnoMapDTO;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.service.IAlumnoService;

@Service
public class AlumnoServiceImp implements IAlumnoService{
	
	@Autowired
	AlumnoRepository alumnoRepository;
	
	@Autowired
	AlumnoMapDTO alumnoMapDTO;

	@Override
	public List<AlumnoDTO> getListaAlumnos() {
		List<Alumno> alumnos = alumnoRepository.findByEstado(true);
		return alumnoMapDTO.listAlumnoToListAlumnoDTO(alumnos);
	}
	 
	@Override
	public AlumnoDTO findAlumnoByLu(Long lu) {
		return alumnoMapDTO.toDto(alumnoRepository.findById(lu).get());
	}

	@Override
	public void agregarUnAlumno(AlumnoDTO alumnoDTO) {
		alumnoDTO.setEstado(true);
        alumnoRepository.save(alumnoMapDTO.toEntity(alumnoDTO));
	}

	@Override
	public void actualizarAlumno(AlumnoDTO alumnoDTO) {
		alumnoRepository.save(alumnoMapDTO.toEntity(alumnoDTO));
	}

	@Override
	public void eliminarUnAlumno(Long lu) {
		AlumnoDTO alumnoDTO = findAlumnoByLu(lu);
        if (alumnoDTO != null) {
            alumnoDTO.setEstado(false);
            alumnoRepository.save(alumnoMapDTO.toEntity(alumnoDTO));
        } else {
            throw new RuntimeException("El alumno con lu " + lu + " no existe.");
        }
	}
}