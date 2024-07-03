package ar.edu.unju.fi.model;

import java.time.LocalDate;
import java.util.Set;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {

    @NonNull
    @Column(name = "alu_DNI", nullable = false)
    private String dni;

    @NonNull
    @Column(name = "alu_Nombre", nullable = false)
    private String nombre;

    @NonNull
    @Column(name = "alu_Apellido", nullable = false)
    private String apellido;

    @NonNull
    @Column(name = "alu_Email", nullable = false)
    private String email;

    @NonNull
    @Column(name = "alu_Telefono", nullable = false)
    private String telefono;

    @NonNull
    @Column(name = "alu_FechaNac", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNac;

    @NonNull
    @Column(name = "alu_Domicilio", nullable = false)
    private String domicilio;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alu_Lu")
    private Long lu;

    @NonNull
    @Column(name = "alu_Estado", nullable = false)
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    @ManyToMany
    @JoinTable(
        name = "materia_alumno",
        joinColumns = @JoinColumn(name = "alumno_id"),
        inverseJoinColumns = @JoinColumn(name = "materia_id")
    )
    private Set<Materia> materias;
}
