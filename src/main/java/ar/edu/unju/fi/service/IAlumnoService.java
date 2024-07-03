package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDTO;

@Service
public interface IAlumnoService {
	public List<AlumnoDTO> getListaAlumnos();
	public AlumnoDTO findAlumnoByLu(Long lu);
	public void agregarUnAlumno(AlumnoDTO alumnoDTO);
	public void actualizarAlumno(AlumnoDTO alumnoDTO);
	public void eliminarUnAlumno(Long lu);
}
