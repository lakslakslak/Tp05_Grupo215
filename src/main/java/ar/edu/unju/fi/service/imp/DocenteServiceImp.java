package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.mapper.DocenteMapDTO;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.service.IDocenteService;
@Service
public class DocenteServiceImp implements IDocenteService {

    @Autowired
    DocenteRepository docenteRepository;
    @Autowired
    DocenteMapDTO docenteMapDTO;

    @Override
    public List<DocenteDTO> getListaDocentes() {
        List<Docente> docentes = docenteRepository.findByEstado(true);
        return docenteMapDTO.listDocenteToListDocenteDTO(docentes);
    }

    @Override
    public DocenteDTO findDocenteByLegajo(Long legajo) {
        return docenteMapDTO.toDto(docenteRepository.findById(legajo).get());
    }

    @Override
    public void agregarUnDocente(DocenteDTO docenteDTO) {
        docenteDTO.setEstado(true);
        docenteRepository.save(docenteMapDTO.toEntity(docenteDTO));
    }

    @Override
    public void actualizarDocente(DocenteDTO docenteDTO) {
        docenteRepository.save(docenteMapDTO.toEntity(docenteDTO));
    }

    @Override
    public void eliminarUnDocente(Long legajo) {
        DocenteDTO docenteDTO = findDocenteByLegajo(legajo);
        if (docenteDTO != null) {
            docenteDTO.setEstado(false);
            docenteRepository.save(docenteMapDTO.toEntity(docenteDTO));
        } else {
            throw new RuntimeException("El docente con legajo " + legajo + " no existe.");
        }
    }
}