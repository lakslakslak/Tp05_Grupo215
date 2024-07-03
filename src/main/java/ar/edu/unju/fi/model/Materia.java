package ar.edu.unju.fi.model;

import java.util.Set;
import org.springframework.stereotype.Component;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Table(name = "MATERIAS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;
    
    @NonNull
    @Column(name = "cantidad_horas", nullable = false)
    private int cantidadHoras;
    
    @NonNull
    @Column(name = "curso", nullable = false)
    private String curso;
    
    @NonNull
    @Column(name = "estado", nullable = false)
    private boolean estado;
    
    @NonNull
    @Column(name = "modalidad", nullable = false)
    private String modalidad;
    
    @NonNull
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @ManyToMany(mappedBy = "materias")
    private Set<Alumno> alumnos;
    
    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;
    
    @OneToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;
}
