package ar.edu.unju.fi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Docente;
@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {
	List<Docente> findByEstado(boolean estado);
	@Override
	Optional<Docente> findById(Long id);
}
