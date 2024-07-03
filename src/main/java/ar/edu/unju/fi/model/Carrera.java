package ar.edu.unju.fi.model;

import java.util.List;
import org.springframework.stereotype.Component;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "duracion", nullable = false)
    private int duracion; // duración en años

    @Column(name = "estado", nullable = false)
    private boolean estado;

    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
    private List<Alumno> alumnos;

    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
    private List<Materia> materias;
}
