package ar.edu.unju.fi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import ar.edu.unju.fi.model.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {
	List<Materia> findByEstado(boolean estado);
	@Override
	Optional<Materia> findById(Long id);
}
