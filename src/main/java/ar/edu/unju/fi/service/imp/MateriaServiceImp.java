package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.MateriaDTO;
import ar.edu.unju.fi.map.MateriaMAPDTO;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.*;
import ar.edu.unju.fi.service.MateriaService;

@Service
public class MateriaServiceImp implements MateriaService{

	@Autowired
	MateriaRepository materiaRepository;
	
	@Autowired
	MateriaMAPDTO materiaMapDTO;
	
	@Override
	public void guardarMateria(MateriaDTO materiaDTO) {
		materiaRepository.save
		(materiaMapDTO.convertirMateriaDTOAMateria(materiaDTO));
	}

	@Override
	public List<Materia> mostrarMateria() {
		return materiaRepository.findMateriaByEstado(true);
	}

	@Override
    public void borrarMateria(String codigo) {
        System.out.println("este es el codigo: "+codigo);
        List<Materia> todasLasMaterias = materiaRepository.findAll();
        for (int i = 0; i < todasLasMaterias.size(); i++) {
        	Materia materia = todasLasMaterias.get(i);
              if (materia.getCodigo().equals(codigo)) {
                materia.setEstado(false);
                materiaRepository.save(materia);
                break;
              }
            }
    }

	@Override
    public void modificarMateria(MateriaDTO materiaModificada) {

		MateriaDTO materiaBuscada = buscarMateria(materiaModificada.getCodigo());
        if (materiaBuscada != null) {

        List<Materia> todasLasMaterias = materiaRepository.findAll();

            for (int i = 0 ; i < todasLasMaterias.size() ; i++) {

            	MateriaDTO materia = materiaMapDTO.convertirMateriaAMateriaDTO(todasLasMaterias.get(i));

                if (materia.getCodigo().equals(materiaModificada.getCodigo())) {
                    todasLasMaterias.set(i, materiaMapDTO.convertirMateriaDTOAMateria(materiaModificada));
                    break;
                    }
                }
            materiaRepository.saveAll(todasLasMaterias);
           } 
            else {
                System.out.println("La carrera no se ha encontrado ");
        }
}

    @Override
    public MateriaDTO buscarMateria(String codigo) {

        List<Materia> todasLasMaterias = materiaRepository.findAll();

        for (Materia materia : todasLasMaterias){
            if (materia.getCodigo().equals(codigo)){
                return materiaMapDTO.convertirMateriaAMateriaDTO(materia);
            }
        }
        return null;
    }
	
}