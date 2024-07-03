package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.DocenteDTO;

@Service
public interface IDocenteService {
	public List<DocenteDTO> getListaDocentes();
	public DocenteDTO findDocenteByLegajo(Long legajo);
	public void agregarUnDocente(DocenteDTO docenteDTO);
	public void actualizarDocente(DocenteDTO docenteDTO);
	public void eliminarUnDocente(Long legajo);
}
