package ar.edu.unju.fi.service;

import java.util.List;


import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.MateriaDTO;
@Service
public interface IMateriaService {
	public List<MateriaDTO> getListaMaterias();
	public MateriaDTO findMateriaByCodigo(Long codigo);
	public void agregarUnaMateria(MateriaDTO materiaDTO);
	public void actualizarMateria(MateriaDTO materiaDTO);
	public void eliminarUnaMateria(Long codigo);
}
