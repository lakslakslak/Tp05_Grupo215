package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.MateriaMapDTO;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.IMateriaService;
@Service
public class MateriaServiceImp implements IMateriaService {

    @Autowired
    MateriaRepository materiaRepository;
    
    @Autowired
    MateriaMapDTO materiaMapDTO;

	@Override
	public List<MateriaDTO> getListaMaterias() {
		 List<Materia> materias = materiaRepository.findByEstado(true);
	     return materiaMapDTO.listMateriaToListMateriaDTO(materias);
	}
	

	@Override
	public MateriaDTO findMateriaByCodigo(Long codigo) {
		return materiaMapDTO.toDto(materiaRepository.findById(codigo).get());
	}

	@Override
	public void agregarUnaMateria(MateriaDTO materiaDTO) {
		materiaDTO.setEstado(true);
        materiaRepository.save(materiaMapDTO.toEntity(materiaDTO));
		
	}

	@Override
	public void actualizarMateria(MateriaDTO materiaDTO) {
		 materiaRepository.save(materiaMapDTO.toEntity(materiaDTO));
	}

	@Override
	public void eliminarUnaMateria(Long codigo) {
		 MateriaDTO materiaDTO = findMateriaByCodigo(codigo);
	        if (materiaDTO != null) {
	            materiaDTO.setEstado(false);
	            materiaRepository.save(materiaMapDTO.toEntity(materiaDTO));
	        } else {
	            throw new RuntimeException("La materia con código " + codigo + " no existe.");
	        }
	}

}
